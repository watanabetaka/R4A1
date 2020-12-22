package newregist;

import bean.User;
import dao.RegistuserDAO;
import tool.Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import session.Passwordutil;

public class PassAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String pass = request.getParameter("pass");
		String email = (String)session.getAttribute("email");

		String hashpass = Passwordutil.getSafetyPassword("pass","email");

		RegistuserDAO dao=new RegistuserDAO();
		int line = dao.insert(email,hashpass);

		if(line > 0){
			session.removeAttribute("email");
			int user_id = dao.searchid(email);
			session.setAttribute("user", Integer.toString(user_id));
			Cookie cookie = new Cookie("user", Integer.toString(user_id));
			cookie.setMaxAge(60*60*24);
			cookie.setPath("/book");
			response.addCookie(cookie);
			RequestDispatcher dispatch = request.getRequestDispatcher("../sightseeing_swipe/Swipe.action");
			dispatch.forward(request, response);
		}
		return "userlogin.jsp";
	}
}
