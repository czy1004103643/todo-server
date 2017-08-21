package com.tms.mina;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class Server {
	
	private static int port = 9123;
	private static IoAcceptor acceptor;
	private static Map<String,Long> sessionMap = new HashMap<String,Long>(10);
	

	public static void main(String[] args) {
		Handler handler = new Handler();
		acceptor = new NioSocketAcceptor();
		//添加日志过滤器
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
		acceptor.setHandler(handler);
		acceptor.getSessionConfig().setReadBufferSize(2048);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);
		
		try{
			acceptor.bind(new InetSocketAddress(Server.port));			
		}catch(Exception e){
			acceptor.unbind(new InetSocketAddress(Server.port));
			e.printStackTrace();
		}
	}
	
	public static Map<String, Long> getSessionMap() {
		return sessionMap;
	}
	
	/**
	 * 根据用户id获得session
	 */
	public static IoSession getSession(String whom){		
		if(sessionMap.containsKey(whom)){
			long id = sessionMap.get(whom);
			Map<Long, IoSession> managedSessions = acceptor.getManagedSessions();
			if(managedSessions.containsKey(id)){
				return managedSessions.get(id);	
			}			
		}
		return null;			
	}
}
