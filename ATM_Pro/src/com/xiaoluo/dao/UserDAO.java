package com.xiaoluo.dao;

import java.util.List;

import com.xiaoluo.bean.User;

public interface UserDAO
{
	public void saveUser(User user);
	
	public List<User> getAllUser();
	
	public void updateUser(User user);
	
	public User getSingleUser(int id);
	
	public void deleteUser(int id);
}
