<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="../html/mypage_header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>

<!-- ヘッダー部分 -->
<header>
  <div id="back">
    <a href="http://<%= ipadress%>:8080/book/mypage/mypage.jsp" id ="back_button">＜</a>
  </div>
  <div id="mypage_title">
メールアドレス変更　　
  </div>
</header>

<div class=fade>
<!-- 入力フォーム -->
<div class=mypage_form_list>

<form action='MailChange.action' method='post'>
  <div class =all>
<div class = mypage_form_txt>
  <div>　現在の<br>　　パスワード　</div>
</div>
<div class = inputer>
<input type='text' class=mypage_form id='now_pass' name='now_pass' placeholder="Type Your Password here"><br>
</div>　
</div>

<div class=all>
<div class = mypage_form_txt>
  <div>　新しい<br>　メールアドレス</div>　　　　
</div>
<div class = inputer>
<input type='text' class=mypage_form id='new_address' name='new_address' placeholder="info@example.com">
  <div><span id='result' value='false'>　</span></div>
</div>
</div>

<div class=all>
<div class = mypage_form_txt>
<div>　新しい<br>　メールアドレス<br>　（確認）</div>
</div>
<div class = inputer>
<input type='text' class=mypage_form id='new_address_2' placeholder="info@example.com">
  <div><span id='result_2' value='false'>　</span></div>
</div>
</div>

</div>

<!-- 検証結果を表示 -->
<br>
<div class=all>
  <div class = mypage_result>
<div><span id='result_3' class=result_off value='false'>不適切です</span></div>
</div>
</div>



<!-- 注意書き -->
<div class=txt>パスワードは
  <br>※アルファベット大文字・数字を含める
  <br>※8文字以上
</div>

<!-- 登録ボタン -->
<div class = "touroku">
  <input type='submit' id='send' name='send' value="登録" disabled>
  </div>

</form>

</div>

<!-- サーブレット -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/mypagemailcheck.js"></script>

<!-- フッター部分 -->
<%@include file="../html/gamenhuta.html" %>
<%@include file="../html/footer.html" %>
