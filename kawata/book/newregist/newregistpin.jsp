<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>

<header>
  <div id="newregpin_title">
    新規会員登録
  </div>
</header>



<!-- メールアドレス送信のJSPファイルです-->
<div id = "newregpin_form">
<form action="Pin.action" method="post">
  <div id="newregpin_messe">メールで送られてきた6桁のPINを入力してください。
  </div>
<div id="pin_pin"><input type="pin" id = "pin" name="pin"placeholder="暗証番号6桁"></div>
<span id="result"></span>
<div id="sub_pin"><input type="submit" name = "send"id = "send" value="次へ" ></div>
</form>
</div>
<%@include file="../html/footer.html" %>
