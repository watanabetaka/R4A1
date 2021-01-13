package cpmypage;

import bean.User;
import dao.MypageDAO;
import tool.Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import session.*;

public class MailChangeAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		//既存のsession取得
		Session session = new Session();
		// 入力されたメールアドレスを取得
		boolean flag=true;
		boolean flag_2=false;
		boolean flag_3=false;
		String now_pass = request.getParameter("now_pass");
    String new_address=request.getParameter("new_address");
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
		new_hashpass = 	Passwordutil.getSafetyPassword(now_pass,new_address);

		flag=dao.checkmail(new_address);

		if(flag==false){
			flag_2=dao.updatemail(new_address,user_id,hashpass);
			if(flag_2==true){
				flag_3=dao.updatepass(new_hashpass,user_id);
				if(flag_3==true){
					return "../cpmypage/success.jsp";
				}else{
					return "../cpmypage/mailchangeerror.jsp";
				}
			}else{
				return "../cpmypage/mailchangeerror.jsp";
			}
		}else{
			return "../cpmypage/mailchangeerror.jsp";
		}
	}
}
