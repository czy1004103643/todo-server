package com.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.dao.UserDao;
import com.tms.entity.User;

@Service
public class ChatService {
	
	@Autowired
	private UserDao userDao;
	public List<User> getAllUsers(long uid){
		return userDao.findAllWithoutMe(uid);
	};
	
	
}
