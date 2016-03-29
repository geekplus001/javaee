package servlet;

import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/*
 * �����û�session������
 */
public class UserSessionListener implements HttpSessionListener {
    public UserSessionListener() {
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("sessionDestroyed...");
    	List<String> users = (List<String>) se.getSession().getServletContext().getAttribute("online");
    	String username = (String) se.getSession().getAttribute("username");
    	users.remove(username);
    }
	
}
