<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<form action='PassChange.action' method='post'>
<p>現在のパスワード　　　　<input type='text' id='now_pass' name='now_pass' placeholder="Type Your Password here"></p>
<p>新しいパスワード　　　　<input type='text' id='new_pass' name='new_pass' placeholder="Type Your Password here"><span id='result' value='false'></span></p>
<p>新しいパスワード（確認）<input type='text' id='new_pass_2' placeholder="Type Your Password here"><span id='result_2' value='false'></span></p>
<span id='result_3'>不適切です</span>
<p>パスワードは
  <br>※アルファベットの大文字・数字を含める
  <br>※8文字以上
    <br><br><font color="red">パスワードが間違っています。<br>再入力してください。</font><br>
</p>
<p><input type='submit' name='send' value="登録" disabled></p>
</form>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/mypagepasscheck.js"></script>
<%@include file="../html/footer.html" %>
