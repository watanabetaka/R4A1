package swipe;

import bean.Swipe;
import dao.SwipeDAO;
import tool.Action;
import javax.servlet.http.*;

public class SwipeAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {


		// String user_id = session.getAttribute("user");

		int user_id=2;

		SightSeeingDAO dao=new SightSeeingDAO();
		SightSeeing user = dao.search(id);

		if (user !=null) {
			session.setAttribute("user", user);
			return "userlogin-out.jsp";
		}

		return "userlogin-error.jsp";
	}
}
