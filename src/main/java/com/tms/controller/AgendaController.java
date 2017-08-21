package com.tms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tms.entity.Agenda;
import com.tms.service.AgendaService;

@RestController
@RequestMapping("/app/agenda")
@Transactional
public class AgendaController {
	
	private static Gson gson = new Gson();
	
	@Autowired
	private AgendaService service;
	/**
	 * 增
	 * @param title
	 * @param content
	 * @param user
	 */
	@ResponseBody
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public int create(Integer userId,String type,String agendaJson){		
		Agenda agenda = gson.fromJson(agendaJson,Agenda.class);
		agenda.setUserId(userId);				
		return service.create(agenda);
	}

	
	@ResponseBody
	@RequestMapping("/delete/{agendaId}")
	public int delete(@PathVariable("agendaId") Integer agendaId){
		return service.delete(agendaId);
	}
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public int update(Integer userId,String type,String agendaJson){
		Agenda agenda = gson.fromJson(agendaJson,Agenda.class);
		agenda.setUserId(agenda.getUser().getId());		
		return service.update(agenda);
	}
	
	/**
	 * @param userId
	 * @param 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/find-all/{userId}/{type}",method=RequestMethod.GET)
	public String findAll(@PathVariable("userId") Integer userId,@PathVariable("type") Integer type,@RequestParam(value="keyWord",required=false) Integer keyWord){		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("type", type);
		List<Agenda> list = service.findAll(map);		
		return gson.toJson(list);
	}
	
	/**
	 * 通知别人的任务
	 * @param userId
	 * @param type
	 * @param agendaJson
	 * @param truename
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/notice",method=RequestMethod.POST)
	public int notice(Integer userId,String type,String agendaJson,String truename){	
		Agenda agenda = gson.fromJson(agendaJson, Agenda.class);
		return service.notice(agenda, truename);		
	}
	
	@ResponseBody
	@RequestMapping(value="/all-lucky",method=RequestMethod.GET)
	public List<Agenda> findAllLucky(){
		return service.findALlLucky();
	}
	
	@ResponseBody
	@RequestMapping(value="/open-lucky",method=RequestMethod.POST)	
	public int openLucky(Integer userId,String type,String agendaJson){
		Agenda agenda = gson.fromJson(agendaJson, Agenda.class);
		agenda.setUserId(userId);
		if(agenda.getStatus() == 2){
			agenda.setStatus(-10086);
		}else{
			agenda.setStatus(0);
		}			
		return service.update(agenda);
	}
}
