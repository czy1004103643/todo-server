package com.tms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tms.entity.Agenda;

public interface AgendaDao {

	public int create(@Param("agenda") Agenda agenda);
	
	public int delete(@Param("agendaId") int agendaId);
	
	public int update(@Param("agenda") Agenda agenda);
	
	/**
	 * 
	 * @param userId
	 * @param type 0查的我的，1查看别人给我的
	 * @return
	 */
	public List<Agenda> findAll(Map <String,Object>map);
	
	/**
	 * 查看所有红包任务 
	 */
	public List<Agenda> findAllLucky();
	
	public List<Agenda> search();
}

