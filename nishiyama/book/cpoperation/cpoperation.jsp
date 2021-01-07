<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>

<h1>まいらいずおおいたへ
    ようこそ</h1>


<p><input type="button"id = cpinfo onclick="location.href='http://localhost:8080/book/cpoperation/Examingflag.action'" value="企業情報入力"></p>

<p><input type="button" id = mailpass onclick="location.href='http://localhost:8080/book/login/userlogin.jsp'" value="メアド・パスワード変更"></p>

<p><input type="button" id = coupon onclick="location.href='http://localhost:8080/book/login/userlogin.jsp'" value="クーポン申請"></p>

<form action="Logout.action" method="post">
<p><input type="submit" id = logout  value="ログアウト"></p>
</form>

<%@include file="../html/footer.html" %>
