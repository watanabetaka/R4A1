<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<!-- パスワード送信エラーのJSPファイルです-->
<form action="Login.action" method="post">
<p id = warn>パスワード入力が間違っています</p>
<p id = email>パスワード<input type="password" name="pass"  placeholder="Chelsea35!"></p>
<p id = send><input type="submit" value="送信"></p>
</form>

<%@include file="../footer.html" %>
