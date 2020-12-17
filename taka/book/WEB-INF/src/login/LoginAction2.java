package login;

import javax.servlet.http.*;
import bean.User;
import dao.UserDAO;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import java.io.PrintWriter;

@WebServlet(urlPatterns={"/login/LoginAction2"})

public class LoginAction2 extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

		HttpSession session=request.getSession();

		try{
			String email=request.getParameter("email");
			String pass=request.getParameter("pass");

			UserDAO dao=new UserDAO();
			User user = dao.search(email, pass);

			Cookie cookie = new Cookie("a","a");
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);

		if (user !=null) {
			session.setAttribute("user", user.getUser_id());
			System.out.println(session);
			System.out.println(user.getUser_id());
			String disp = "/CookieAction";
      RequestDispatcher dispatch = request.getRequestDispatcher(disp);
			dispatch.forward(request, response);
		}
		request.getRequestDispatcher("userlogin-error.jsp")
			.forward(request, response);

		} catch (Exception e){

		}

	}
}
