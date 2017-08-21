package com.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.tms.dao.WordDao;
import com.tms.entity.Word;

@Service
public class WordService {
	
	private Gson gson = new Gson();
	
	@Autowired
	private WordDao dao;
			
	public void save(Word word){
		dao.save(word);		
	}
	
	public List<Word> findAll(){
		List<Word> list = dao.findAll();
		return list;
	}
}
