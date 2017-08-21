package com.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tms.entity.User;
import com.tms.service.ChatService;

@Controller
@RequestMapping("/app/chat")
public class ChatController {
	
	@Autowired
	private ChatService service;
	
	private static Gson gson = new Gson();
	
	@ResponseBody
	@RequestMapping(value="/who-is-online")
	public String checkWhoIsOnline(Long uid){
		List<User> list = service.getAllUsers(uid);		
		return gson.toJson(list);
	}
}
