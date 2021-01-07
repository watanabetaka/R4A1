package firstselect;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.http.Cookie;
import java.io.*;
import javax.servlet.*;
import tool.Action;
import session.Session;
import dao.UserDAO;

public class CookiejudgeAction extends Action {

	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
				// cookie・sessionよりuser_idを取得
				Session session = new Session();
				int user_id = session.getUser_id(request,response);
				String tmp = Integer.toString(user_id);

					if(tmp != null){
							RequestDispatcher dispatch = request.getRequestDispatcher("../sightseeing_swipe/Swipe.action");
							dispatch.forward(request, response);
					}else{
						return "userfirstselect.jsp";
      		}
			return "userfirstselect.jsp";
    }

}
