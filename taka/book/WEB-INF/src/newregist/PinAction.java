package newregist;

import bean.User;
import dao.LoginuserDAO;
import tool.Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;



public class PinAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		String pin = request.getParameter("pin");

		//session取得
		HttpSession session=request.getSession();
		///sessionから取得したIDをString型に変換
		String sessionpin = (String)session.getAttribute("pin");

		if(pin.equals(sessionpin)){
			session.removeAttribute("pin");
			return "newregistpass.jsp";
		}else{
			return "newregistpin-error.jsp";
		}
	}
}
