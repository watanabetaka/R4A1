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
		Integer userid = new Integer(user.getUser_id());
		String tmp = userid.toString();
		String name = "かちゅみaaaaa";
		System.out.println(value);
		Cookie cookie = new Cookie("a","value");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);

		if (cookies!=null) {
		  for (Cookie cookie : cookies) {
		    String name=cookie.getName();
		    String value=cookie.getValue();
				value = tmp
			}

		HttpSession session = request.getSession();

		if (user !=null) {
			return "userlogin-out.jsp";
		}

		return "userlogin-error.jsp";
	}
}
