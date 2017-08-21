package com.tms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tms.dao.UserDao;
import com.tms.entity.User;
import com.tms.service.ApiService;
import com.tms.utils.Utils;

@Controller
@RequestMapping("/app/api")
@Transactional
public class ApiController {
	
	public static Logger log = LoggerFactory.getLogger(ApiController.class);
    
	private static ApplicationContext act = Utils.getApplicationContext();
	
	private Gson gson = new Gson();
	
	@Autowired
	private ApiService service;
	
	@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username, String password){	
		return service.login(username, password);
	}
	
	@ResponseBody
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String signup(String json){
		User user = gson.fromJson(json, User.class);
		return service.signup(user);
	}
	
	@ResponseBody
	@RequestMapping(value="/all-users/{status}",method=RequestMethod.GET)
	public String getUsers(@PathVariable int status){		
		return service.getUsers(status);
	}
	
	@RequestMapping(value="help",method=RequestMethod.GET)
	public String getHelp(){
		return "help";
	}
}
