<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>

<!-- ヘッダー部分 -->
<header>
  <div id="back">
    <a href="http://localhost:8080/book/mypage/mypage.jsp" id ="back_button">＜</a>
  </div>
  <div id="mypage_title">
パスワード変更　　
  </div>
</header>

<!-- 入力フォーム -->
<div class=mypage_form_list>

<form action='PassChange.action' method='post'>
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
<div>　新しい<br>　　パスワード　</div>
</div>
<div class = inputer>
<input type='text' class=mypage_form id='new_pass' name='new_pass' placeholder="Type Your Password here">
<div><span id='result' value='false'>　</span></div>
</div>
</div>

<div class=all>
<div class = mypage_form_txt>
<div>　新しい<br>　　パスワード　<br>　（確認）</div>
</div>
<div class = inputer>
<input type='text' class=mypage_form id='new_pass_2' placeholder="Type Your Password here">
<div><span id='result_2' value='false'>　</span></div>
</div>
</div>

</div>

<!-- 検証結果を表示 -->
<br>
<div class=all>
  <div class = mypage_result>
<div><span id='result_3' class=result_on value='false'>不適切です</span></div>
</div>
</div>

<!-- 注意書き -->
<div class=txt>パスワードは
  <br>※アルファベット大文字・数字を含める
  <br>※8文字以上
  <br><br>
  <div class=attention>パスワードが間違っています。<br>再入力してください。</div>
  </div>

<!-- 登録ボタン -->
<div class= "touroku">
  <input type='submit' id='send' name='send' value="登録" disabled>
  </div>

</form>

<!-- サーブレット -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/mypagepasscheck.js"></script>

<!-- フッター部分 -->
<%@include file="../html/footer.html" %>
