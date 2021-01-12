package firstselect;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.http.Cookie;
import java.io.*;
import javax.servlet.*;
import tool.Action;
import session.Session;
import dao.CookiejudgeDAO;

public class CookiejudgeAction extends Action {

	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
				// user_idを取得
				Session session = new Session();
				int user_id = session.getUser_id(request,response);

					//user_idが存在しているかを確認
					if(user_id != 0){
						CookiejudgeDAO dao = new CookiejudgeDAO();
						int userkind_id = dao.searchuserkind_id(user_id);
							if(userkind_id == 1){
								RequestDispatcher dispatch = request.getRequestDispatcher("../sightseeing_swipe/Swipe.action");
								dispatch.forward(request, response);
							}else if(userkind_id == 2){
								return "../cpoperation/cpoperation.jsp";
							}
					}
			return "userfirstselect.jsp";
    }

}
