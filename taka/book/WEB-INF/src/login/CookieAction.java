package login;

import javax.servlet.http.*;
import bean.User;
import dao.UserDAO;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import java.io.PrintWriter;


public class CookieAction extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

		try{
		HttpSession session=request.getSession();
		String ses = (String)session.getAttribute("user");
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
		  for (Cookie cookie : cookies) {
				cookie.setValue(ses);
		    String name=cookie.getName();
		    String value=cookie.getValue();
		  }
		}
		request.getRequestDispatcher("userlogin.jsp")
			.forward(request, response);
	}catch(Exception e){

	}




	}
}
