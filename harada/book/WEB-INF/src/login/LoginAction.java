package login;

import bean.User;
import dao.UserDAO;
import tool.Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;



public class LoginAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();




		String email=request.getParameter("email");
		String pass=request.getParameter("pass");

		UserDAO dao=new UserDAO();
		User user = dao.search(email, pass);

		Cookie cookie = new Cookie("user_id","ss");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);

		if (user !=null) {
			session.setAttribute("user", Integer.toString(user.getUser_id()));
			return "userlogin-out.jsp";
		}

		return "userlogin-error.jsp";
	}
}
