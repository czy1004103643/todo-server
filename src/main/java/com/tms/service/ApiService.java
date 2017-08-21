package com.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.tms.dao.UserDao;
import com.tms.entity.User;
import com.tms.utils.Utils;

@Service
public class ApiService {
	
	@Autowired
	private UserDao userDao;
	private ApplicationContext act = Utils.getApplicationContext();
	private static Gson gson = new Gson();
	
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public String login(String username,String password){				
		User user = userDao.findUserByUsername(username);
		
		if(user != null && user.getPassword().equals(password)){
			return user.toString();
		}
		return "0";	
	}
	
	public String signup(User user){
		User temp = userDao.findUserByUsername(user.getUsername());
		if(temp != null){
			return "0";
		}
		userDao.save(user);
		user = userDao.findUserByUsername(user.getUsername());
		return gson.toJson(user);
	}
	
	public String getUsers(int status){		 
		List<User> list = userDao.findAll(status);
		return gson.toJson(list);
	}
}
