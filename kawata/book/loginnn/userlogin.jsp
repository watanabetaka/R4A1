<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>


<div id="login">

<header>
    <div id="userlogin">ログイン</div>
</header>

<form action="Login.action" method="post">
<p id="email">
<input type="mailaddress" name="email" placeholder="メールアドレス"></p>
<p id="pass">
<input type="password" name="pass" placeholder="パスワード"></p>
<p id="login"><input type="submit" value="ログイン"></p>
</form>

</div>

<%@include file="../footer.html" %>
