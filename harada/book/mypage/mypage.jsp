<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<p>メールアドレス　　　<input type="button" id =mailchange onclick="location.href='http://10.23.104.39:8080/book/mypage/mailchange.jsp'" value="変更"></p>
<p>パスワード　　　　　<input type="button" id =passchange onclick="location.href='http://10.23.104.39:8080/book/mypage/passchange.jsp'" value="変更"></p>
<br><input type="button" id = logout onclick ="location.href='http://10.23.104.39:8080/book/login/Logout.action'"  value="ログアウト">
<%@include file="../html/gamenhuta.html" %>

<%@include file="../html/footer.html" %>
