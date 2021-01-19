<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>

<header>

  <div id="back">
    <a href="" id="modoru">＜</a>
  </div>

  <div id="newregpin_title">
    新規会員登録
  </div>

</header>


<!-- メールアドレス送信のJSPファイルです-->
<form action="Login.action" method="post">
  <div id="newregmail_messe">
登録するメールアドレスを入力してください。パスワード入力用メールをお送りします。
  </div>
<p id = email><input type="mailaddress" name="email"  placeholder="info@example.com"></div>
<div id = sendmail><input type="submit" value="送信"></div>
</form>

<%@include file="../html/footer.html" %>
