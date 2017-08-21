package com.tms.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class Utils {
	
	private static ApplicationContext act;
	
	public static String getTime(){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}
	
	public static String getTime(String timePattern){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(timePattern);
		return dateFormat.format(date);
	}
	
	public static boolean isRequestMethodPost(HttpServletRequest request){
		if ("POST".equals(request.getMethod())){
		      return true;
		   }
		return false;
	}
	
	
	
    public static ApplicationContext getApplicationContext() throws BeansException{
        if(act == null){
            //act  = new FileSystemXmlApplicationContext("src/main/resources/beans/bean.xml");
        	act =ContextLoader.getCurrentWebApplicationContext();
        }
        return act;
    }
}
