<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>

<<<<<<< HEAD
=======
<%@ page import = "tool.Page"%>
<%@ page import = "tool.Action"%>
<%@ page import = "java.io.IOException"%>
<%@ page import = "java.io.PrintWriter"%>
<%@ page import = "javax.servlet.ServletException"%>
>>>>>>> 33c3bf7e6a8edefefc9637a207f2b05e216f8982
<%@ page import = "javax.servlet.http.Cookie"%>
<%@ page import = "javax.servlet.http.*"%>

<%
<<<<<<< HEAD
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
          String value=cookie.getValue();
          user_id = Integer.parseInt(value);//ここにセッションのユーザIDが入ってます
          out.println(user_id);
        }
      }
   } else {
     out.println("クッキーは存在しません");
   }
}

%>
<%@include file="../html/footer.html" %>
=======
// セッションからユーザIDを取得
String session_id = (String)session.getAttribute("user");
// 生成していたcookieを取得する
Cookie[] cookies=request.getCookies();

if (cookies!=null) {
  int count=0;
  for (Cookie cookie : cookies) {
    cookie.setValue(session_id);
    String name=cookie.getName();
    String value=cookie.getValue();
    int user_id = Integer.parseInt(value);
    if(count==0){
        out.println(user_id);
    }
    count++;
  }
} else {
  out.println("クッキーは存在しません");
}
// out.println(user_id);

%>
<p><input type="button" onclick="location.href='http://localhost:8080/book/login/userlogin-out.jsp'" value="クッキーへ"></p> --%>
<%@include file="../footer.html" %>
>>>>>>> 33c3bf7e6a8edefefc9637a207f2b05e216f8982
