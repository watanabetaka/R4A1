package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

public class Session {
	public  int getUser_id( HttpServletRequest request,HttpServletResponse response){
			//ユーザーIDを格納する変数
			int user_id=0;
			//ログイン済みかどうかを判断する変数
			boolean loginflag = false;

		try{
    	HttpSession session=request.getSession();
			// ログインか新規会員登録からメニュー画面へ遷移した場合
    	if(session.getAttribute("user") != null){
			//sessionから取得したIDをString型に変換
      String session_id = (String)session.getAttribute("user");
			//int型に変換
      user_id = Integer.parseInt(session_id);
 		//ここにセッションのユーザIDが入ってます
      //ログインか新規会員登録以外からメニュー画面へ遷移した場合

    	}else{
				// Cookieの取得
      Cookie[] cookies=request.getCookies();
			//拡張for文で配列に入っているcookieをすべて取り出す
        for (Cookie cookie : cookies) {
					//cookieの配列に入っているcookiename取得
        		String name=cookie.getName();
					//cookienameがuserか確認
          if(name.equals("user")){
					//cookienameがuserならログイン済みとして、loginflagをtrueに変換
						loginflag = true;
					//cookieの配列に入っているcookievalue（ユーザIDが入っている）を取得
            String value=cookie.getValue();
            //ここにセッションのユーザIDが入ってます
            user_id = Integer.parseInt(value);
          }
        }
					// loginflagがfalseならトップ画面へ戻す
				  if (!loginflag ) {
						RequestDispatcher dispatch = request.getRequestDispatcher("../firstselect/userfirstselect.jsp");
						dispatch.forward(request, response);
      	}
    	}
		}catch(Exception e){
			System.out.println();
		}
		// 設定したユーザIDを戻り値に返します
		return user_id;
  }
}
