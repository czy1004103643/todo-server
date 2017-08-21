package com.tms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.tms.entity.User;
import com.tms.service.SiteService;
import com.tms.utils.Utils;

@Controller
@RequestMapping(value="/app/site")
public class SiteController {
	
	private static ApplicationContext act = Utils.getApplicationContext();
	@Autowired
	private SiteService service;
	
	@ResponseBody
	@RequestMapping(value="/signup")
	public Object signup(HttpServletRequest request,HttpServletResponse response,
			User user){
		ModelAndView view = new ModelAndView("signup");
		
		String serverToken = (String) WebUtils.getSessionAttribute(request,"token");
		if(Utils.isRequestMethodPost(request)){
			int result = service.signup(user);
			if(result == 1){
				view.addObject("info", "注册成功！");
				return "<h1>注册成功，欢迎您：" + user.getTruename() + "</h1>";
			}
		}
		view.addObject("token",serverToken);
		return view;
	}
}
