package org.cupcake.service;

import java.util.List;

import org.cupcake.dao.UserDao;
import org.cupcake.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;  
	
	public void setUserDao(UserDao userDao) {  
	    this.userDao = userDao;  
	}  

	public User getUserById(int id) {  
	    return userDao.getUserById(id);  
	}  
	public User getUserByName(String name) {  
	    return userDao.getUserByName(name);  
	}  
	
	public List<User> getAllUser() {  
	    return userDao.getAllUser();  
	}  
	
	public boolean addUser(User user) {  
		try{
			userDao.addUser(user);  
		}
		catch(Exception e){
			System.out.println("---failed adding user in userService");
			return false;
		}
		return true;
	}  
	
	public boolean delUser(String id) {  
	
	    return userDao.delUser(id);  
	}  
	
	public boolean updateUser(User user) {  
	    return userDao.updateUser(user);  
	}  
	
	public boolean login(String id, String pw){
		System.out.println(id+" "+pw+"in servicelogin");
		if(getUserByName(id)==null){
			System.out.println("didn't find user with name:"+id);
			return false;
		}
		else{
			System.out.println("----got the user with name:"+id+" now trying to match the pw");
			if(getUserByName(id).getPassword().equalsIgnoreCase(pw)){
				System.out.println("-------the pw is also good:"+pw);
				return true;
			}
			else{
				System.out.println("-------the pw is not good:"+pw+" it should be:"+getUserByName(id).getPassword());
				return false;
			}
		}
	}
}
