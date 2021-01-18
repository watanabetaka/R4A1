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

<!-- パスワード登録のJSPファイルです-->
<div id ="newregpass_messe">
登録するパスワードを入力してください。<br><br>
パスワード入力の際の注意事項<br>
※大文字・小文字・数字・記号を含める<br>
※8文字以上、10文字以内
</div>


<form action="Login.action" method="post">
<p id = pass><input type="password" name="pass"  placeholder="パスワード"></p>

<div id = sendpass><input type="submit" value="送信"></div>
</form>

<%@include file="../html/footer.html" %>
