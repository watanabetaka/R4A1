package login;

import bean.User;
import dao.LoginuserDAO;
import tool.Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;



public class LoginAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String email=request.getParameter("email");
		String pass=request.getParameter("pass");

		LoginuserDAO dao=new LoginuserDAO();
		User user = dao.search(email, pass);



		if (user !=null) {
			session.setAttribute("user", Integer.toString(user.getUser_id()));
			// session.setAttribute("user2", "aaa");
			String session_id = (String)session.getAttribute("user");
			Cookie cookie = new Cookie("user", session_id);
			cookie.setMaxAge(60*60*24);
			cookie.setPath("/book");
			response.addCookie(cookie);
			RequestDispatcher dispatch = request.getRequestDispatcher("../sightseeing_swipe/Swipe.action");
			dispatch.forward(request, response);
		}

		return "userlogin-error.jsp";
	}
}
