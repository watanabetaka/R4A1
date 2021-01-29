<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/cpoperation_header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>


<!-- ヘッダー部分 -->
<header>
  <div id="back">
    <a href="http://<%= ipadress%>:8080/book/cpoperation/cpoperation.jsp" id ="back_button">＜</a>
  </div>
<div id="mypage_title">
メアド・パスワード変更　　
</div>
</header>

<script>
document.getElementsByTagName("title")[0].innerHTML="メアド・パスワード変更";
</script>

<!-- 会員情報変更ボタン -->
<div class=fade>
<div class=mypage>
<div class=mypage_button_txt>メールアドレス　
  <input type="button" id =mailchange onclick="location.href='http://<%= ipadress%>:8080/book/cpmypage/mailchange.jsp'" value="変更">
</div>

<div class = mypage_button_txt>パスワード　　　
  <input type="button" id =passchange onclick="location.href='http://<%= ipadress%>:8080/book/cpmypage/passchange.jsp'" value="変更">
  </div>


<div class=txt>※設定したメールアドレス・パスワード<br>　は忘れないようにしてください</div>

</div>
</div>
<!-- ヘッダー部分 -->
<%@include file="../html/footer.html" %>
