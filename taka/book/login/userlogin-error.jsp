<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>

メールアドレスまたはパスワードが違います。

<form action="Login.action" method="post">
<p>メールアドレス<input type="mailaddress" name="email"></p>
<p>パスワード<input type="password" name="pass"></p>
<p><input type="submit" value="ログイン"></p>
</form>
<a href="http://localhost:8080/book/reissuepass/reissuepassmail.jsp">パスワード再発行</a>

<%@include file="../html/footer.html" %>
