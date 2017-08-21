package com.tms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tms.entity.ChatMessage;

public interface ChatMessageDao {
	
	public int save(@Param("message") ChatMessage message);
	
	public List<ChatMessage> geUnSentMessages(@Param("uid") Long uid);
}
