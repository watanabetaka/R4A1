<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/newregist_header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>

<!-- メールアドレス送信のJSPファイルです-->
<header>


  <div id="newregpin_title">
    新規会員登録
  </div>

</header>

<div id="newregmail_messe">メールで送られた6桁のPINを入力して下さい。
</div>
<form action="Pin.action" method="post">
<div id = email><input type="pin" id = "pin" name="pin"placeholder="暗証番号6桁"></div>
<span id="result"></span>
<div id = mail_error>PINが間違えています<br>再入力してください。</div>
<div id = sendmail_error><input type="submit" name = "send"id = "send" value="次へ"  ></div>
</form>
<%@include file="../html/footer.html" %>
