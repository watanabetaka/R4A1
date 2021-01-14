<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<!-- メールアドレス送信のJSPファイルです-->
<form action="Pin.action" method="post">
<p>暗証番号<input type="pin" id = "pin" name="pin"></p>
<span id="result"></span>
<p><input type="submit" name = "send"id = "send" value="送信"></p>
</form>
<%@include file="../html/footer.html" %>
