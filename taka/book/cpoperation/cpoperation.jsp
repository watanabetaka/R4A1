<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>

<h1>まいらいずおおいたへ
    ようこそ</h1>


<p><input type="button"id = cpinfo onclick="location.href='http://localhost:8080/book/cpoperation/Examingflag.action'" value="企業情報入力"></p>

<p><input type="button" id = mailpass onclick="location.href='http://localhost:8080/book/cpmypage/mypage.jsp'" value="メアド・パスワード変更"></p>

<p><input type="button" id = coupon onclick="location.href='http://localhost:8080/book/cplogin/Logout.action'" value="クーポン申請"></p>

<p><input type="button" id = logout "location.href='http://localhost:8080/book/cplogin/Logout.action'"  value="ログアウト"></p>

<%@include file="../html/footer.html" %>
