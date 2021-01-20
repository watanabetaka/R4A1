<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>

<h1>まいらいずおおいたへ
    ようこそ</h1>

<p><input type="button" onclick="location.href='http://<%= ipadress%>:8080/book/cpnewregist/newregistmail.jsp'" value="新規会員登録"></p>

<p><input type="button" onclick="location.href='http://<%= ipadress%>:8080/book/login/userlogin.jsp'" value="ログイン"></p>


<%@include file="../html/footer.html" %>
