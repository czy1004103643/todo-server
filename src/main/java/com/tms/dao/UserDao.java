package com.tms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tms.entity.User;

public interface UserDao {
	
	public User findUserByUsername(@Param("username") String username);
	
	public List<User> findAll(@Param("status") int status);
	
	public int save(@Param("user") User user);

	public User findUserById(@Param("uid") long uid);

	public List<User> findAllWithoutMe(@Param("uid") long uid);

	public User findUserByTruename(@Param("truename") String truename);
}
