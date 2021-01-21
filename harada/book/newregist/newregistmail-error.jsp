<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/userlogin_header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>


<header>

  <div id="back">
    <a href="" id="modoru">＜</a>
  </div>

  <div id="newregpin_title">
    新規会員登録
  </div>

</header>


<!-- メールアドレス送信エラーのJSPファイルです-->
<form action="http://<%= ipadress%>:8080/book/firstselect/userfirstselect.jsp" method="post">
  <div id="newregmail_messe">登録するメールアドレスを入力してください。パスワード入力用メールをお送りします。
  </div>

<div id = email><input type="mailaddress" name="email"  placeholder="info@example.com"></div>
<div id = mail_error>メールアドレスが重複しています。<br>再入力してください。</div>
<div id = sendmail_error><input type="submit" value="送信"></div>

</form>

<%@include file="../html/footer.html" %>
