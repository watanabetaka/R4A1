<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/userfirstselect_header.html" %>

<h1>まいらいずおおいたへ
    ようこそ</h1>

<p><input type="button" onclick="location.href='http://<%@include file="../ipadress/ipadress.jsp" %>:8080/book/newregist/newregistmail.jsp'" value="新規会員登録"></p>

<p><input type="button" onclick="location.href='http://<%@include file="../ipadress/ipadress.jsp" %>:8080/book/login/userlogin.jsp'" value="ログイン"></p>

 <a href="http://<%@include file="../ipadress/ipadress.jsp" %>:8080/book/cpfirstselect/cpuserfirstselect.jsp">企業はこちらから</a>

<%@include file="../html/footer.html" %>
