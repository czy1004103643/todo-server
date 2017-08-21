package com.tms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tms.entity.TaskRecord;

public interface TaskRecordDao {
	
	public List<TaskRecord> findAll(@Param("id") Long id);

	public int save(@Param("record") TaskRecord record);
}
