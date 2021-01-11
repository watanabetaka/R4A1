package cpoperation;

import tool.Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;

public class ExamingflagAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

      // Cookieの取得
    Cookie[] cookies=request.getCookies();
      //拡張for文で配列に入っているcookieをすべて取り出す
    for (Cookie cookie : cookies) {
      //cookieの配列に入っているcookieValue取得
        String value=cookie.getValue();
      //cookievalueか確認
			System.out.println(value);
      if(value.equals("true")){

      //cookieのvalueがtrueならcpexamination.jspへ遷移する。
        return "../cpoperation/cpexamination.jsp";
      }
    }
    //cookieのvalueがtrueでなければcpinfo.jspへ遷移する。
    return "../cpoperation/cpinfo.jsp";
  }
}
