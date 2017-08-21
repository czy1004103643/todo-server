package com.tms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.tms.dao.UserDao;
import com.tms.entity.User;
import com.tms.utils.Utils;

@Service
public class SiteService {
	
	@Autowired
	private UserDao userDao;
	private ApplicationContext act = Utils.getApplicationContext();
	
	public int signup(User user){
		
		return userDao.save(user);
	}
}
