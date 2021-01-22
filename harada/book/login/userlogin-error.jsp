<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/userlogin_header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>

<header>
  <div id="back">
    <a href="Login.action" id ="modoru">＜</a>
  </div>
  <div id="login_title">
    ログイン
  </div>
</header>


<div id=login_form>
<form action="Login.action" method="post">
  <div id = login_error>
  メールアドレスまたはパスワードが間違っています。<br>再入力してください。
  </div>
<div id = email><input type="mailaddress" name="email" placeholder="メールアドレス"></div>
<div id = pass><input type="password" name="pass"placeholder="パスワード"></div>

<div id = login1><input type="submit" value="ログイン"></div>
<div id = repass><a class="reissuepass" href="http://<%= ipadress%>:8080/book/reissuepass/reissuepassmail.jsp">パスワード再発行</a></div>
</form>
</div>

<%@include file="../html/footer.html" %>
