package login;

import bean.User;
import dao.UserDAO;
import tool.Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

public class Cookiesession extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
    HttpSession session=request.getSession();
    //ログインか新規会員登録からメニュー画面へ遷移したばあい
    if(session.getAttribute("user") != null){
            String session_id = (String)session.getAttribute("user");
            int user_id = Integer.parseInt(session_id);//ここにセッションのユーザIDが入ってます
            System.out.println(user_id);
       //ログインか新規会員登録以外からメニュー画面へ遷移した場合
    }else{
      Cookie[] cookies=request.getCookies();

      if (cookies!=null) {
         int user_id;
         for (Cookie cookie : cookies) {
            String name=cookie.getName();
            if(name.equals("user")){
              String value=cookie.getValue();
              user_id = Integer.parseInt(value);//ここにセッションのユーザIDが入ってます
              System.out.println(user_id);
              return "userlogin.jsp";
            }
          }
       } else {
         System.out.println("クッキーは存在しません");
       }
    }
    return "userlogin.jsp";
  }
}
