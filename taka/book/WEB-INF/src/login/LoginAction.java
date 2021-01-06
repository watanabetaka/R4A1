package login;

import bean.User;
import dao.LoginuserDAO;
import tool.Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import session.Passwordutil;


public class LoginAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		//session生成
		HttpSession session=request.getSession();
		//入力されたメールアドレスをString型のemail変数に格納する
		String email=request.getParameter("email");
		//入力されたメールアドレスをString型のpass変数に格納する
		String pass=request.getParameter("pass");
		//emailをsaltととしてemailをハッシュ化する
		String hashpass = Passwordutil.getSafetyPassword("pass","email");
		//ログイン検査用のDAO
		LoginuserDAO dao=new LoginuserDAO();
		//emailとpassの検索結果をuserに格納
		User user = dao.search(email, hashpass);

		//userがnullでなければsessionへのユーザID格納とcookie生成を行う
		if (user !=null) {
			//sessionの名前にuser、値にユーザIDを格納する
			session.setAttribute("user", Integer.toString(user.getUser_id()));
			//sessionから取得したユーザIDを変数session_idに格納する
			String session_id = (String)session.getAttribute("user");
			//名前がuserで値がユーザIDのcookieを生成する
			Cookie cookie = new Cookie("user", session_id);
			//cookieのpathを生存期間を1ヶ月に設定する
			cookie.setMaxAge(60*60*24*30);
			// cookieのpathをbook直下にしていしている
			cookie.setPath("/book");
				// cookieを追加
			response.addCookie(cookie);
			//スワイプ画面へ遷移させる
			RequestDispatcher dispatch = request.getRequestDispatcher("../sightseeing_swipe/Swipe.action");
			dispatch.forward(request, response);
		}
		//
		return "userlogin-error.jsp";
	}
}
