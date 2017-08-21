package com.tms.mina;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.google.gson.Gson;
import com.tms.entity.ChatMessage;
import com.tms.entity.User;


/**
 * 负责session对象的创建监听以及消息发送和接收的监听
 * @author ljt
 *
 */
public class Handler extends IoHandlerAdapter{
		
	private Gson gson = new Gson(); 
	private String resource = "com/tms/mina/mybatis-config.xml";    
	private InputStream inputStream;    
	private SqlSessionFactory ssf;    
	private SqlSession session;    
   
	public Handler(){
		super();
		init();
		
	}
	
	@Override
	public void sessionCreated(IoSession session) throws Exception{
		super.sessionCreated(session);					
	}
	
	@Override
	public void sessionOpened(IoSession session) throws Exception {		
		super.sessionOpened(session);	
		System.out.println(session.getId() + "已上线！");
	}
	
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {		
		super.messageReceived(session, message);		
		ChatMessage cm = gson.fromJson((String)message, ChatMessage.class);
		try{
			handleMessage(session, cm);	
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(message);
	}
	
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {		
		super.messageSent(session, message);		
		System.out.println("消息转发完成（2）");
	}
	
	@Override
	public void sessionClosed(IoSession session) throws Exception {		
		super.sessionClosed(session);
		System.out.println(session.getId() + "已下线！");
	}
	
	/**
	 * 消息处理
	 * @param mySession
	 * @param message
	 */
	private void handleMessage(IoSession mySession,ChatMessage message){
		System.out.println("开始处理消息:"+message.getType());		
		this.session = ssf.openSession(); 
		if("hello".equals(message.getType())){			
			Map<String,Long> sessionMap = Server.getSessionMap();
			String me = message.getFromWhom();
			sessionMap.put(me, mySession.getId());	
			
			List<ChatMessage> messages = session.selectList("getUnSentMessages", message.getFromWhom());
			if(messages.size() > 0){
				ChatMessage cm = new ChatMessage();
				cm.setType("manyMessages");
				cm.setContent(gson.toJson(messages));
				cm.setToWhom(me);			
				mySession.write(gson.toJson(cm));
				
				for(ChatMessage m : messages){
					m.setStatus("1");
					this.session.update("ChatMessageDao.update",m);
				}
				this.session.commit();
				this.session.close();
			}
			
		}else if("chat".equals(message.getType())){			
			String toWhom = message.getToWhom();
			IoSession session = Server.getSession(toWhom);	
			if(session != null){
				String msg = gson.toJson(message);
				session.write(msg);				
			}else{
				System.out.println(toWhom + "不在线");				
				ChatMessage cm = new ChatMessage();
				cm.setType("response");
				cm.setToWhom(message.getFromWhom());
				cm.setStatus("0");		
				mySession.write(gson.toJson(cm));
				this.session.insert("ChatMessageDao.save",message);
				this.session.commit();
				this.session.close();
			}			
		}				
	};
	
	private void init() {				    
		try {
			this.inputStream = Resources.getResourceAsStream(resource);
			
			this.ssf = new SqlSessionFactoryBuilder().build(this.inputStream);    
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}		 
	}
}
