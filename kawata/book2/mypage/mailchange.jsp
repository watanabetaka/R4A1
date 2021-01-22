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
<form action='checkresult' method='post'>
<div class =zenbu>
<div class = mypagemail>
    <div class =mypagemail_ima>現在の</div>
    <div class=mypagepas>　パスワード　</div>
</div>
<div class = gennsai>
    <input type='text' id='now_pass' placeholder="Type Your Password here">
</div>　
</div>
<div class=zenbu>
<div class = mypagemail>
  <div class =mypagemail_ima>新しい</div>
  <div class=mypagepas>メールアドレス</div>　　　　
</div>
<div class = gennsai>
  <input type='text' id='new_address' placeholder="info@example.com" onKeyUp="confirm()">
    <%-- <span id='result'>不適切です</span> --%>
</div>
</div>
<div class=zenbu>
<div class = mypagemail>
<div class =mypagemail_ima>新しい</div>
<div class=mypagepas>メールアドレス</div>
<div class =mypagemail_ima>（確認）</div>
</div>
<div class = gennsai>
  <input type='text' id='new_address_2' placeholder="info@example.com" onKeyUp="confirm()">
  <%-- <span id='result_2'>不適切です</span></div>   --%>
</div>　
</div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/mypagemailcheck.js"></script>
<script>
function confirm(){
  var address_1 = document.getElementById("new_address").value;
  var address_2 = document.getElementById("new_address_2").value;
  var t1=document.getElementById("result");
  var t2=document.getElementById("result_2");
  var inputElement = $('input[name="send"]');
  if(address_1==address_2){
    t2.innerHTML = "適切です";
  }else{
    t2.innerHTML = "不適切です";
  }
  if(t1.innerHTML=="適切です"&&t2.innerHTML=="適切です"){
    inputElement.prop('disabled', false);
  }else{
    inputElement.prop('disabled', true);
  }
}
</script>
</form>
<div id="pasuu">パスワードは
  <br>※大文字・小文字・数字・記号を含める
  <br>※8文字以上10文字以下
</div>
<div id = "touroku"><input type='button' name='send' value="登録" disabled></div>

<%@include file="../html/footer.html" %>
