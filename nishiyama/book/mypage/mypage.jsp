<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/mypage_header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>


<!-- ヘッダー部分 -->
<header>
<div id="mypage_title">
マイページ
</div>
</header>

<script>
document.getElementsByTagName("title")[0].innerHTML="マイページ";
</script>

<!-- 会員情報変更ボタン -->
<div class=fade>
<div class=mypage>
<div class=mypage_button_txt>メールアドレス　
  <input type="button" id =mailchange onclick="location.href='http://<%= ipadress%>:8080/book/mypage/mailchange.jsp'" value="変更">
</div>

<div class = mypage_button_txt>パスワード　　　
  <input type="button" id =passchange onclick="location.href='http://<%= ipadress%>:8080/book/mypage/passchange.jsp'" value="変更">
  </div>


<div class=txt>※設定したメールアドレス・パスワード<br>　は忘れないようにしてください</div>

<!-- ログアウトボタン -->
<div class=mypage_logout>
  <input type="button" id = logout onclick ="location.href='http://<%= ipadress%>:8080/book/login/Logout.action'"  value="ログアウト">
  </div>
  </div>

</div>

<!-- ヘッダー部分 -->
<%@include file="../html/gamenhuta.html" %>
<%@include file="../html/footer.html" %>
