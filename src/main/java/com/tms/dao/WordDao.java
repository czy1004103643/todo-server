package com.tms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tms.entity.Word;

public interface WordDao {
	
	public List<Word> findAll();
	
	public int save(@Param("word") Word word);
}
