package org.cupcake.controller;

import javax.annotation.Resource;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.cupcake.entity.User;
import org.cupcake.interceptor.Auth;
import org.cupcake.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class LoginController {
	
	@Resource(name="userService")  
	private UserService userService;  
	
    @RequestMapping("")
    public String home(){
        return "Login";
    }

    @RequestMapping("validateLogin")
    public String validateLogin(HttpServletRequest request){
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	request.getSession().setAttribute("id", id);
    	request.getSession().setAttribute("pw", pw);
    	System.out.println("-----------------in validate login");
        return "redirect:getAllUser";
    }
    @RequestMapping("reg")
    public String toRegister(){
        return "register";
    }
    
    @RequestMapping("reguser")
    public String toRegUser(@Valid User user, BindingResult result){
	    /*
    	String msg = "{\"result\":\"success\"}";  
	    if(result.hasErrors()){  
	    	msg = "{\"result\":\"error\"}";  
	    }  
	    response.setContentType("application/json");  
	    try {  
	        PrintWriter out = response.getWriter();  
	        out.write(msg);  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	    */
    	System.out.println("----there are errors 数量:"+result.getErrorCount());
	    if(!result.hasErrors()){
	    	userService.addUser(user);
	    	return "redirect:";
	    }
        return "redirect:reg";
    }

    @Auth
	@RequestMapping("getAllUser")  
	public String getAllUser(HttpServletRequest request){  
	    request.setAttribute("userList", userService.getAllUser());  
    	System.out.println("-------------------in getAllUser");
	    return "overview";  
	}  
    
    @Auth
    @ResponseBody
	@RequestMapping("getAllUser/jsonAllUser")  
	public List<User> jsonAllUser(HttpServletRequest request){  
    	List<User> list = userService.getAllUser();
    	System.out.println("-------------------in jsonAllUser");
	    return list;  
	}  

    @Auth
	@RequestMapping("getUser")  
	public String getUser(String id,HttpServletRequest request){  
	    request.setAttribute("user", userService.getUserById(Integer.valueOf(id)));  
	    return "editUser";  
	}  

    @Auth
	@RequestMapping("toAddUser")  
	public String toAddUser(){  
	    return "addUser";  
	}  

    @Auth
	@RequestMapping("addUser")  
	public String addUser(@Valid User user, BindingResult result){  
    	System.out.println("用户名in addUser：======"+user.getLogin_name());  
    	if(result.hasErrors()) return "redirect:getAllUser";
	    System.out.println("用户名：======"+user.getLogin_name());  
	    userService.addUser(user);  
	    return "redirect:getAllUser";  
	}  

    @Auth
	@RequestMapping("delUser")  
	public void delUser(String id,HttpServletResponse response){  
	    String result = "{\"result\":\"error\"}";  
	    if(userService.delUser(id)){  
	        result = "{\"result\":\"success\"}";  
	    }  
	    response.setContentType("application/json");  
	    try {  
	        PrintWriter out = response.getWriter();  
	        out.write(result);  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	}  

    @Auth
	@RequestMapping("updateUser")  
	public String updateUser(@Valid User user, BindingResult result,HttpServletRequest request){  
	    if(result.hasErrors()) return "redirect:getAllUser";
    	if(userService.updateUser(user)){  
	        user = userService.getUserById(user.getUser_id());  
	        request.setAttribute("user", user);  
	        return "redirect:getAllUser";  
	    }else{  
	        return "error";  
	    }  
	}
	    
}