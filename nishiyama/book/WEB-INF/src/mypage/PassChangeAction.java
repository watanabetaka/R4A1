package mypage;

import bean.User;
import dao.MypageDAO;
import tool.Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import session.*;

public class PassChangeAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		//既存のsession取得
		Session session = new Session();
		// 入力されたメールアドレスを取得
		boolean flag=false;
		String now_pass = request.getParameter("now_pass");
    String new_address=request.getParameter("new_address");
    String email = "";
		String hashpass="";
		int user_id = session.getUser_id(request,response);

		// 会員情報変更用のdaoを呼び出し
		MypageDAO dao=new MypageDAO();

		email=dao.getmail(user_id);
		/*パスワードとメールアドレスを連結してハッシュ化したものをパスワード
		として格納*/
		hashpass = 	Passwordutil.getSafetyPassword(now_pass,email);


		flag=dao.updatemail(new_address,user_id,hashpass);
		if(flag==true){
			return "../mypage/success.jsp";
		}else{
			return "../mypage/mailchangeerror.jsp";
		}
	}
}
