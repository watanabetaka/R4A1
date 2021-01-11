package cplogin;

import bean.User;
import dao.LoginuserDAO;
import tool.Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import session.Passwordutil;


public class CploginAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String email=request.getParameter("email");
		String pass=request.getParameter("pass");

		String hashpass = Passwordutil.getSafetyPassword(pass,email);

		LoginuserDAO dao=new LoginuserDAO();
		User user = dao.search(email, hashpass);



		if (user !=null) {
			session.setAttribute("user", Integer.toString(user.getUser_id()));
			// session.setAttribute("user2", "aaa");
			String session_id = (String)session.getAttribute("user");
			//ccokieにユーザIDを設定する。
			Cookie cookie = new Cookie("user", session_id);
			//企業情報を登録する際に使うcookieで、cookieに名前はcpinfoexaming,値にtrueを設定する
			 			 cookie = new Cookie("cpinfoexamingflag", "false");
			//cookie1の生存期間を２か月に設定
			cookie.setMaxAge(60*60*24*60);
			//cookieのpathを"/book"にする
			cookie.setPath("/book");
			//cookieの追加を行う
			response.addCookie(cookie);
			RequestDispatcher dispatch = request.getRequestDispatcher("../cpoperation/cpoperation.jsp");
			dispatch.forward(request, response);
		}

		return "userlogin-error.jsp";
	}
}
