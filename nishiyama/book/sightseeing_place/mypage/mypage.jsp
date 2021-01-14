<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<header>
<div id="mypage_title">
  会員情報変更
</div>
</header>
<div id=mypage1>
<div id=mymail>メールアドレス
  <input type="button" id =mailchange onclick="location.href='http://localhost:8080/book/mypage/mailchange.jsp'" value="変更">
</div>
<div id = mypass>パスワード
  <input type="button" id =passchange onclick="location.href='http://localhost:8080/book/mypage/passchange.jsp'" value="変更">
</div>
</div>
<%@include file="../html/footer.html" %>
