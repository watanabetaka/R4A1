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



		String email=request.getParameter("email");
		String pass=request.getParameter("pass");

		UserDAO dao=new UserDAO();
		User user = dao.search(email, pass);
		Integer userid = new Integer(user.getUser_id);
		String value = userid.toString();
		Cookie cookie = new Cookie("a",value);
		cookie.setMaxAge(60*60*24);

		if (user !=null) {
			return "userlogin-out.jsp";
		}

		return "userlogin-error.jsp";
	}
}
