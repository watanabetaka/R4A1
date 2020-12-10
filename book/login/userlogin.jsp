<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<form action="Login.action" method="post">
<p id = email>メールアドレス<input type="mailaddress" name="email"></p>
<p id = pass>パスワード<input type="password" name="pass"></p>
<p id = login><input type="submit" value="ログイン"></p>
</form>

<%@include file="../footer.html" %>
