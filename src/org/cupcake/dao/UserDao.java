package org.cupcake.dao;

import java.sql.SQLException;
import java.util.List;

import org.cupcake.entity.User;

public interface UserDao {

	public User getUserById(int id);  
	public User getUserByName(String name);  
	
	public List<User> getAllUser();  
	
	public boolean addUser(User user);  
	
	public boolean delUser(String id);  
	
	public boolean updateUser(User user); 
}
