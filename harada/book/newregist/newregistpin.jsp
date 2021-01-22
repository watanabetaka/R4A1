<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/newregist_header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>


<header>
  <div id="newregpin_title">
    新規会員登録
  </div>
</header>



<!-- メールアドレス送信のJSPファイルです-->
<div id = "newregpin_form">
<form action="Pin.action" method="post">
    <div id="newregmail_messe">メールで送られた6桁のPINを入力して下さい。
  </div>
  <div id = "email"><input type="pin" id = "pin" name="pin"placeholder="暗証番号6桁"></div>
<span id="result"></span>
  <div id ="sendmail"><input type="submit" name = "send"id = "send" value="次へ" ></div>
</form>
</div>
<%@include file="../html/footer.html" %>
