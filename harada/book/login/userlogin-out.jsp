<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%@ page import = "tool.Page"%>
<%@ page import = "tool.Action"%>
<%@ page import = "java.io.IOException"%>
<%@ page import = "java.io.PrintWriter"%>
<%@ page import = "javax.servlet.ServletException"%>
<%@ page import = "javax.servlet.http.Cookie"%>
<%@ page import = "javax.servlet.http.*"%>

<%
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
