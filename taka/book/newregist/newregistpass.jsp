<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<!-- パスワード登録のJSPファイルです-->
<p> ＊パスワード入力の際の注意事項<br>
1.英字の大文字小文字を含めること<br>
2.数字と記号を含めること
</p>
<form action="Login.action" method="post">
<p id = pass>パスワード<input type="password" name="pass"  placeholder="Chelsea35!"></p>
<p id = send><input type="submit" value="送信"></p>
</form>

<%@include file="../footer.html" %>
