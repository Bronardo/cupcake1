package org.cupcake.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.cupcake.service.UserService;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Resource(name="userService") 
    private UserService userService;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception { 
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            Auth auth = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
            if(auth == null || auth.validate() == false)
            	return true;
            else{                
                String contextPath=request.getContextPath();
                HttpSession session = request.getSession();
                if(session.getAttribute("valid")==null){
                    String username = (String)session.getAttribute("id");
                    String password = (String)session.getAttribute("pw");
                    /*
                    session.removeAttribute("id");
                    session.removeAttribute("pw");
                    */
                    System.out.println(username+"=====|==="+password);
                    if(userService.login(username, password))//处理成功
                    {
                    	session.setAttribute("valid", "1");
                    	System.out.println("------prehandle success!!!!!!");
                    	return true;
                    }
                    else//处理失败
                    {
                    	System.out.println("------------prehandle failed");
                        response.sendRedirect(contextPath);
                        return false;
                    }       
                	
                }
                else return true;
            }
        }
        else
            return true;   
     }

}
