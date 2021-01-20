<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>

<header>
  <div id="back">
    <a href="" id ="modoru">＜</a>
  </div>
  <div id="login_title">
    ログイン
  </div>
</header>


<div id=login_form>
<form action="Login.action" method="post">
<div id = email><input type="mailaddress" name="email" placeholder="メールアドレス"></div>
<div id = pass><input type="password" name="pass"placeholder="パスワード"></div>
<div id = login_error>
メールアドレスまたはパスワードが間違っています。<br>再入力してください。
</div>
<div id = login1><input type="submit" value="ログイン"></div>
</form>
</div>

<%@include file="../html/footer.html" %>
