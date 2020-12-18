<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>

<%@ page import = "javax.servlet.http.Cookie"%>
<%@ page import = "javax.servlet.http.*"%>

<%


//ログインか新規会員登録からメニュー画面へ遷移したばあい
if(session.getAttribute("user") != null){
        String session_id = (String)session.getAttribute("user");
        int user_id = Integer.parseInt(session_id);
        out.println(user_id);  //ここにセッションのユーザIDが入ってます
   //ログインか新規会員登録以外からメニュー画面へ遷移した場合
}else{
  Cookie[] cookies=request.getCookies();

  if (cookies!=null) {
     int user_id;
     for (Cookie cookie : cookies) {
        String name=cookie.getName();
        if(name.equals("user")){
          out.print("クッキーから取得したよ");
          String value=cookie.getValue();
          //ここにセッションのユーザIDが入ってます
          user_id = Integer.parseInt(value);
          out.println(user_id);
        }
      }
   } else {
     out.println("クッキーは存在しません");
   }
}

%>
<%@include file="../html/footer.html" %>
