package session;

import bean.Favorite;
import dao.FavoriteDAO;
import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import javax.servlet.*;
// ajax通信の開始
public class Session {
	// 右スワイプされたsightseeing_idを取得し、favoriteデータベースに挿入するメソッド
	public  int getUser_id( HttpServletRequest request){
    HttpSession session=request.getSession();
    int user_id=0;

    if(session.getAttribute("user") != null){
      String session_id = (String)session.getAttribute("user");
      user_id = Integer.parseInt(session_id);
      System.out.println(user_id);  //ここにセッションのユーザIDが入ってます
      //ログインか新規会員登録以外からメニュー画面へ遷移した場合
    }else{
      Cookie[] cookies=request.getCookies();

      if (cookies!=null) {
        for (Cookie cookie : cookies) {
          String name=cookie.getName();
          if(name.equals("user")){
            String value=cookie.getValue();
            //ここにセッションのユーザIDが入ってます
            user_id = Integer.parseInt(value);
            System.out.println(name);
          }
        }
      } else {
        System.out.println("クッキーは存在しません");
        // return "userlogin.jsp";
      }
    }

    return user_id;

  }

}
