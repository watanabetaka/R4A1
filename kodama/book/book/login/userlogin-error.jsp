<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

ログイン名またはパスワードが違います。

<form action="Login.action" method="post">
<p>メールアドレス<input type="mailaddress" name="email"></p>
<p>パスワード<input type="password" name="pass"></p>
<p><input type="submit" value="ログイン"></p>
</form>

<%@include file="../footer.html" %>
