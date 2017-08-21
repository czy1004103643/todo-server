package com.tms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tms.dao.AgendaDao;
import com.tms.dao.UserDao;
import com.tms.entity.Agenda;
import com.tms.entity.User;

@Service
public class AgendaService {
	
	@Autowired
	private AgendaDao agendaDao;
	@Autowired
	private UserDao userDao;
	
	public int create(Agenda agenda){
		return agendaDao.create(agenda);
	};
	
	public int delete(int id){
		return agendaDao.delete(id);
	};
	
	public int update(Agenda agenda){
		return agendaDao.update(agenda);
	};
	
	/**
	 * 查看所有任务
	 * @param userId
	 * @param type 0查的我的，1查看别人给我的
	 * @return
	 */
	public List<Agenda> findAll(Map <String,Object>map){
		return agendaDao.findAll(map);
	};
	
	/**
	 * 通知别人的任务
	 * @param agenda
	 * @param truename
	 * @return
	 */	
	public int notice(Agenda agenda,String truename){
		User user = userDao.findUserByTruename(truename);
		agenda.setUserId(user.getId());
		agenda.setStatus(0);
		return agendaDao.create(agenda);
	}
	
	public List<Agenda> search(){
		return null;
	}

	public List<Agenda> findALlLucky() {

		return agendaDao.findAllLucky();
	};
}
