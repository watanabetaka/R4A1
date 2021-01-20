<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/userlogin_header.html" %>


<header>
  <div id="back">
    <a href="" id="modoru">＜</a>
  </div>
  <div id="newregpin_title">
    新規会員登録
  </div>
</header>

<takayoshi>
<p> ＊パスワード入力の際の注意事項<br>
1.英字の大文字小文字を含めること<br>
2.数字と記号を含めること
</p>
<form action="Pass.action" method="post">
<label for="password"><b>パスワード  </b></label><br>
<input name="pass" id="password" type="password" placeholder="Type Your Password here" onKeyUp="confirm()"/>
<span id="result"></span>
<br>
<input name="pass" id="password_confirm" type="password" placeholder="Type Your Password here" onKeyUp="confirm()"/>
<span id="result_confirm"></span>
<p><input type="submit" name = "send"id = "send" value="送信"  disabled ></p>
</form>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/passwordcheck.js"></script>
<script>
function confirm(){
var password = document.getElementById("password").value;
var password_confirm = document.getElementById("password_confirm").value;
var t1=document.getElementById("result");
var t2=document.getElementById("result_confirm");
var inputElement = $('input[name="send"]');
if(password==password_confirm){
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

<%-- <kawawata> --%>
<%-- <!-- パスワード登録のJSPファイルです-->
<div id ="newregpass_messe">
登録するパスワードを入力してください。<br><br>
パスワード入力の際の注意事項<br>
※大文字・小文字・数字・記号を含める<br>
※8文字以上、10文字以内
</div>


<form action="Login.action" method="post">
<p id = pass><input type="password" name="pass"  placeholder="パスワード"></p>

<div id = sendpass><input type="submit" value="登録"></div>
</form> --%>

<%@include file="../html/footer.html" %>
