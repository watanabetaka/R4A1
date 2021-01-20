<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/userlogin_header.html" %>


<header>
  <div id="back">
    <a href="" id="modoru">＜</a>
  </div>
  <div id="newregpin_title">
    新規会員登録
  </div>
</header>

<!-- パスワードエラーのJSPファイルです-->
<form action="Login.action" method="post">
<div id="newregpass_messe">
登録するパスワードを入力してください。<br><br>
パスワード入力の際の注意事項<br>
※大文字・小文字・数字・記号を含める<br>
※8文字以上、10文字以内
</div>
<p id = email><input type="mailaddress" name="email"  placeholder="パスワード"></p>
<div id = pass_error>
パスワードが注意事項を満たしていません。
再入力してください。
</div>
<div id = sendpass_error><input type="submit" value="登録"></div>
</form>

<%@include file="../html/footer.html" %>
