<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>

<form action="Login.action" method="post">
<p id = email>メールアドレス<input type="mailaddress" name="email"></p>
<p id = pass>パスワード<input type="password" name="pass"></p>
<p id = login><input type="submit" value="ログイン"></p>
</form>
<a href="http://localhost:8080/book/reissuepass/reissuepassmail.jsp">パスワード再発行</a>

<%@include file="../html/footer.html" %>
