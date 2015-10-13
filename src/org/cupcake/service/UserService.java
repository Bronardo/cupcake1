package org.cupcake.service;

import java.util.List;

import org.cupcake.entity.User;

public interface UserService {

	public User getUserById(int id);
	public User getUserByName(String name);
	
	public List<User> getAllUser();
	
	public boolean addUser(User user);
	
	public boolean delUser(String id);
	
	public boolean updateUser(User user);
	
	public boolean login(String id, String pw);
	
}
