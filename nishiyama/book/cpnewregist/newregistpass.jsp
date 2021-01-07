<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<body>
  <p> ＊パスワード入力の際の注意事項<br>
  1.英字の大文字小文字を含めること<br>
  2.数字と記号を含めること
  </p>
<form action="Cppass.action" method="post">
<label for="password"><b>パスワード : </b></label>
<input name="pass" id="password" type="password" placeholder="Type Your Password here"/>&nbsp;&nbsp;
<span id="result"></span>
<p><input type="submit" name = "send"id = "send" value="送信"  disabled ></p>
</form>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/passwordcheck.js"></script>
<%@include file="../html/footer.html" %>
