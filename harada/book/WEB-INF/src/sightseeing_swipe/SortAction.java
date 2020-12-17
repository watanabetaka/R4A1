package sightseeing_swipe;

import bean.Sightseeing;
import dao.SightseeingDAO;
import tool.Action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.List;
import tool.Page;
import java.util.Collections;

public class SwipeAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		PrintWriter out=response.getWriter();
		Page.header(out);

		// String user_id = session.getAttribute("user");

		int user_id=2;

		SightseeingDAO dao=new SightseeingDAO();
		List<Sightseeing> list = dao.search();


		Collections.shuffle(list);

		request.setAttribute("list",list);

		// request.getRequestDispatcher("sightseeing_swipe.jsp").forward(request,response);
		return "sightseeing_swipe.jsp";
	}
}
