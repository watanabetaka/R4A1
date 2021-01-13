package cpmypage;

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
		boolean flag_2=false;
		String now_pass = request.getParameter("now_pass");
    String new_pass=request.getParameter("new_pass");
    String email = "";
		String hashpass="";
		String new_hashpass="";
		int user_id = session.getUser_id(request,response);

		// 会員情報変更用のdaoを呼び出し
		MypageDAO dao=new MypageDAO();

		email=dao.getmail(user_id);
		/*パスワードとメールアドレスを連結してハッシュ化したものをパスワード
		として格納*/
		hashpass = 	Passwordutil.getSafetyPassword(now_pass,email);
		new_hashpass = 	Passwordutil.getSafetyPassword(new_pass,email);

		flag=dao.updatepass(new_hashpass,user_id);

		if(flag==true){
			flag_2=dao.updatepass(new_hashpass,user_id);
			if(flag_2==true){
				return "../cpmypage/success.jsp";
			}else{
				return "../cpmypage/mailchangeerror.jsp";
			}
		}else{
			return "../cpmypage/mailchangeerror.jsp";
		}
	}
}
