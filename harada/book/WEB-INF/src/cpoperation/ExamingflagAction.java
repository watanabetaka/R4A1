package cpoperation;

import tool.Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;
import dao.CpinfoexamingDAO;
import session.*;

public class ExamingflagAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		//sessionクラスインスタンス化
		Session session = new Session();
		//int user_idにユーザIDが入っている
		int user_id = session.getUser_id(request,response);
		//TEMP_SIGHTSEEING_PLACEに企業情報登録済みか確認するDAO
		CpinfoexamingDAO dao = new CpinfoexamingDAO();
		//ユーザidでTEMP_SIGHTSEEING_PLACEに企業情報登録済みか確認するメソッドを呼び出し、結果をboolean型でcpexamingflagに入れる
		boolean cpexamingflag = dao.user_idsearch(user_id);
		//cpexamingflagがtrueなら../cpoperation/cpexamination.jspへ返す
		if(cpexamingflag){
			return "cpexamination.jsp";
		}
	//cpexamingflagがfalseならcpinfo.jspへ遷移する。
	return "cpinfo.jsp";
  }
}
