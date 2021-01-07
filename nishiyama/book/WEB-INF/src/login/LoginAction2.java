package login;

import bean.User;
import dao.UserDAO;
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

		UserDAO dao=new UserDAO();
		User user = dao.search(email, pass);



		if (user !=null) {
			session.setAttribute("user", Integer.toString(user.getUser_id()));
			String session_id = (String)session.getAttribute("user");
				Cookie cookie = new Cookie("user", session_id);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			String disp = "/Cookiesession";
      RequestDispatcher dispatch = request.getRequestDispatcher(disp);
      dispatch.forward(request, response);
			// return "userlogin-out.jsp";
		}

		return "userlogin-error.jsp";
	}
}
