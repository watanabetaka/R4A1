<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/userlogin_header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>
<header>
  <div id="back">
    <a href="http://<%= ipadress%>:8080/book/firstselect/userfirstselect.jsp" id ="modoru">＜</a>
  </div>
  <div id="login_title">
    ログイン
  </div>
</header>
<div id=login_form>
<form action="Login.action" method="post">
<div id = email><input type="mailaddress" name="email" placeholder="メールアドレス"></div>
<div id = pass><input type="password" name="pass"placeholder="パスワード"></div>
<div id = login><input type="submit" value="ログイン"></div>
</form>
</div>
<%@include file="../html/footer.html" %>
