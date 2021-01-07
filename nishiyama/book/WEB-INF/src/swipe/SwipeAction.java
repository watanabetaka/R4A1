package swipe;

import bean.Swipe;
import dao.SwipeDAO;
import tool.Action;
import javax.servlet.http.*;

public class SwipeAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String email=request.getParameter("email");
		String pass=request.getParameter("pass");

		UserDAO dao=new UserDAO();
		User user = dao.search(email, pass);

		if (user !=null) {
			session.setAttribute("user", user);
			return "userlogin-out.jsp";
		}

		return "userlogin-error.jsp";
	}
}
