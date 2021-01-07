<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<form action='checkresult' method='post'>
<p>現在のパスワード　　　　<input type='text' id='now_pass' placeholder="Type Your Password here"></p>
<p>新しいパスワード　　　　<input type='text' id='new_pass' placeholder="Type Your Password here" onKeyUp="confirm()"><span id="result"></span></p>
<p>新しいパスワード（確認）<input type='text' id='new_pass_2' placeholder="Type Your Password here" onKeyUp="confirm()"><span id=result_2></span></p>
<script>
function confirm(){
  var pass_1 = document.getElementById("new_pass").value;
  var pass_2 = document.getElementById("new_pass_2").value;
  var t1=document.getElementById("result");
  var t2=document.getElementById("result_2");
  var inputElement = $('input[name="send"]');
  if(pass_1==pass_2){
    t2.innerHTML = "適切です";
  }else{
    t2.innerHTML = "不適切です";
  }
  if(t1.innerHTML="適切です"||t2.innerHTML="適切です"){
    inputElement.prop('disabled', false);
  }else{
    inputElement.prop('disabled', true);
  }
}
</script>
</form>
<p>パスワードは
  <br>※大文字・小文字・数字・記号を含める
  <br>※8文字以上10文字以下
</p>
<p><input type='button' name='send' value="登録"></p>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="../js/mypagepasscheck.js"></script>
<%@include file="../html/footer.html" %>
