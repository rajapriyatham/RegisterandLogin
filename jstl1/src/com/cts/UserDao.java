package com.cts;

import java.util.ArrayList;

import com.cts.User;

public interface UserDao {
	public String addUserDetail(User user);
	public ArrayList<User> getAlluserDetails();
	public User checkLoginCredential(String username,String password);
	
	public User getUserById(Integer userId);
	public boolean updateUserById(User user);
	public boolean deleteUserById(Integer userId);
}
