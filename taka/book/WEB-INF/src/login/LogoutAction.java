package login;

import tool.Action;
import javax.servlet.http.*;
import javax.servlet.*;

public class LogoutAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();
		// sessionが存在するか確認
		if(session.getAttribute("user") != null){
			//sessionに格納されているユーザID削除
			session.removeAttribute("user");
		}
			// Cookieの取得
		Cookie[] cookies=request.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				cookie.setPath("/book");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				}
		}
		return "../firstselect/userfirstselect.jsp";
	}
}
