<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<header>
  <div id="back">
    <a href="" id ="modoru">＜</a>
  </div>
  <div id="mypage_title">
    会員情報変更
  </div>
</header>

<div id=mypagemail_form>

<form action='MailChange.action' method='post'>
  <div class =all>
<div class = mypagemail>
  <div>現在の<br>　パスワード　</div>
</div>
<div class = now>
<input type='text' id='now_pass' name='now_pass' placeholder="Type Your Password here"></p>
</div>　
</div>

<div class=all>
<div class = mypagemail>
  <div>新しい<br>メールアドレス</div>　　　　
</div>
<div class = now>
<input type='text' id='new_address' name='new_address' placeholder="info@example.com">
  <p><span id='result' value='false'>　</span></p>
</div>
</div>
<div class=all>
<div class = mypagemail>
<div>新しい<br>メールアドレス<br>（確認）</div>
</div>
<div class = now>
<input type='text' id='new_address_2' placeholder="info@example.com">
  <p><span id='result_2' value='false'>　</span></p>
</div>
</div>
</div>

<div class=all>
  <div class = mypagemail>
<div><span id='result_3' value='false'>不適切です</font></span></div>
</div>
</div>

<div id="p_txt">パスワードは
  <br>※アルファベットの大文字・数字を
  <br>　含める
  <br>※8文字以上
    <br><br><font color="red">メールアドレスまたはパスワードが間違っています。<br>再入力してください。</font><br>
</div>
<div id = "touroku"><input type='submit' name='send' value="登録" disabled></div>
</form>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/mypagemailcheck.js"></script>
<script>
<%@include file="../html/footer.html" %>
