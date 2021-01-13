package reissuepass;

import dao.RegistuserDAO;
import tool.Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import session.*;

public class RepassAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		// 入力されたメールアドレスが存在しているか
		boolean mailflag=false;
		// 入力されたメールアドレスを取得
		String address = request.getParameter("address");
		//　入力された新しいパスワード取得
    String pass=request.getParameter("pass");
		String new_hashpass="";

		//メールアドレス検索用のdaoを呼び出し
		RegistuserDAO dao = new RegistuserDAO();
		//入力されたメールアドレスが存在すればtrueが、しなければfalseが入る
		mailflag = dao.searchmail(address);
		if(mailflag){
			boolean passflag = false;
			/*パスワードとメールアドレスを連結してハッシュ化したものをパスワード
			として格納*/
			new_hashpass = 	Passwordutil.getSafetyPassword(pass,address);
			passflag = dao.updatepass(address,new_hashpass);
			if(passflag){
				return "reissuepass-success.jsp";
			}
		}
	return "reissuepass-error.jsp";
	}
}
