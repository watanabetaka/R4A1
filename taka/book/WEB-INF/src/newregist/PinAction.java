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
		//ユーザーから送られてきた暗証番号を変数pinに保存する
		String pin = request.getParameter("pin");

		//session取得
		HttpSession session=request.getSession();
		//sessionに暗証番号が格納されているか確認
		if(session.getAttribute("pin") != null){
		//sessionから取得したIDをString型に変換
			String sessionpin = (String)session.getAttribute("pin");
			//ユーザーが入力した暗証番号とsessionに格納されていた暗証番号等しいかチェックする
			if(pin.equals(sessionpin)){
			//等しければsessionに格納した暗証番号を削除する
				session.removeAttribute("pin");
			//パスワードを入力するjspに遷移させる
				return "newregistpass.jsp";
			//等しくなければ暗証番号エラー画面に遷移
			}else{
				return "newregistpin-error.jsp";
			}
		//sessionに入っていた暗証番号がタイムアウトになった場合の処理
		}else{
			//Top画面へ戻す
			return "../firstselect/userfirstselect.jsp";
		}
	}
}
