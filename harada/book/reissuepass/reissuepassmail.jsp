<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<p >現在のメールアドレスを入力して下さい</p>
<form action="Repassmail.action" method="post">
<p>現在のメールアドレス<input type="email" id = "email" name="email"  placeholder="info@example.com"></p>
<p><input type="submit" name = "send"id = "send" value="送信"  disabled ></p>
</form>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/emailcheck.js"></script>
<%@include file="../html/footer.html" %>
