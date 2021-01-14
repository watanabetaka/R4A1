<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>

<!-- ヘッダー部分 -->
<header>
<div id="mypage_title">
会員情報変更
</div>
</header>

<!-- 会員情報変更ボタン -->
<div id=mypage>
<div id=mymail>メールアドレス　
  <input type="button" id =mailchange onclick="location.href='http://localhost:8080/book/mypage/mailchange.jsp'" value="変更">
</div>
<div id = mypass>パスワード　　　
  <input type="button" id =passchange onclick="location.href='http://localhost:8080/book/mypage/passchange.jsp'" value="変更">
</div>
<br><br><br><br><br><br><br><br>

<!-- ログアウトボタン -->
<div id=logout>
  <input type="button" id = logout onclick ="location.href='http://localhost:8080/book/login/Logout.action'"  value="ログアウト">
  </div>
</div>

<!-- ヘッダー部分 -->
<%@include file="../html/footer.html" %>
