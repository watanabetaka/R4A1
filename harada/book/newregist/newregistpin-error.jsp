<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/newregist_header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>

<!-- メールアドレス送信のJSPファイルです-->
<p>暗証番号が違います</p>
<form action="Pin.action" method="post">
<p>暗証番号<input type="pin" id = "pin" name="pin"></p>
<span id="result"></span>
<p><input type="submit" name = "send"id = "send" value="送信"  ></p>
</form>
<%@include file="../html/footer.html" %>
