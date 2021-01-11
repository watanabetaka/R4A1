<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<!-- メールアドレス送信のJSPファイルです-->
<p>aaa</p>
<form action="MailSend.action" method="post">
<p>メールアドレス<input type="email" id = "email" name="email"  placeholder="info@example.com"></p>
<span id="result"></span>
<p><input type="submit" name = "send"id = "send" value="送信"  disabled ></p>
</form>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/emailcheck.js"></script>
<%@include file="../html/footer.html" %>
