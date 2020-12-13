package sightseeing_swipe;

import bean.SightSeeing;
import dao.SightSeeingDAO;
import tool.Action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.List;
import tool.Page;
public class SwipeAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		PrintWriter out=response.getWriter();
		Page.header(out);

		// String user_id = session.getAttribute("user");

		int user_id=2;

		SightSeeingDAO dao=new SightSeeingDAO();
		List<SightSeeing> list = dao.search();
		//
		// for(SightSeeing s : list){
		// 	out.println(s.getSightSeeing_Name());
		// 	out.println(s.getCity_Id());
		// 	out.println(s.getPicture_Path());
		// }

		request.setAttribute("list",list);

		request.getRequestDispatcher("result.jsp").forward(request,response);
		return "error";
	}
}
