<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/userlogin_header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>


<header>

  <div id="back">
    <a href="http://<%= ipadress%>:8080/book/firstselect/userfirstselect.jsp" id="modoru">＜</a>
  </div>

  <div id="newregpin_title">
    新規会員登録
  </div>

</header>


<!-- メールアドレス送信のJSPファイルです-->
<form action="MailSend.action" method="post">
  <div id="newregmail_messe">
    メールアドレス
  </div>
  <div id = "email"><input type="email" id = "mail" name="email"  placeholder="info@example.com"></div>
  <span id="result"></span>
  <div id ="sendmail"><input type="submit" name = "send" id = "send" value="送信"  disabled ></div>
</form>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/emailcheck.js"></script>

<!-- メールアドレス送信のJSPファイルです-->
<%-- <form action="Login.action" method="post">
  <div id="newregmail_messe">
登録するメールアドレスを入力してください。パスワード入力用メールをお送りします。
  </div>
<div id = "email"><input type="mailaddress" name="email"  placeholder="info@example.com"></div>
<div id = "sendmail"><input type="submit" value="送信"></div>
</form> --%>

<!-- メールアドレス送信のJSPファイルです-->
<%-- <form action="MailSend.action" method="post">
  <div id="newregmail_messe">
    メールアドレス
  </div>
<p id = email><input type="mailaddress" name="email"  placeholder="info@example.com"></p>
<span id="result"></span>
<div id = sendmail><input type="submit" name = "send" id = "send" value="送信"  disabled ></div>
</form>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/emailcheck.js"></script> --%>

<%@include file="../html/footer.html" %>
