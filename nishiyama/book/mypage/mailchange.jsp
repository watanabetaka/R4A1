<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<form action='PassChangeAction' method='post'>
<p>現在のパスワード　　　　　　<input type='text' id='now_pass' placeholder="Type Your Password here"></p>
<p>新しいメールアドレス　　　　<input type='text' id='new_address' placeholder="info@example.com"><span id='result' value='false'></span></p>
<p>新しいメールアドレス（確認）<input type='text' id='new_address_2' placeholder="info@example.com"><span id='result_2' value='false'></span></p>
</form>
<span id='result_3'>不適切です</span>
<p>パスワードは
  <br>※アルファベットの大文字・数字を含める
  <br>※8文字以上
</p>
<p><input type='button' name='send' value="登録" disabled></p>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/mypagemailcheck.js"></script>
<%@include file="../html/footer.html" %>
