<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<form action='checkresult' method='post'>
<p>現在のパスワード　　　　　　<input type='text' id='now_pass' placeholder="Type Your Password here"></p>
<p>新しいメールアドレス　　　　<input type='text' id='new_address' placeholder="info@example.com" onKeyUp="confirm()"><span id="result"></span></p>
<p>新しいメールアドレス（確認）<input type='text' id='new_address_2' placeholder="info@example.com" onKeyUp="confirm()"><span id=txt></span></p>
<script>
function confirm(){
  var address_1 = document.getElementById("new_address").value;
  var address_2 = document.getElementById("new_address_2").value;
  var inputElement = $('input[name="send"]');
  if(address_1==address_2){
    document.getElementById("txt").innerHTML = "適切です";
    inputElement.prop('disabled', false);
  }else{
    document.getElementById("txt").innerHTML = "不適切です";
    inputElement.prop('disabled', true);
  }
}
</script>
</form>
<p>パスワードは
  <br>※大文字・小文字・数字・記号を含める
  <br>※8文字以上10文字以下
    <br><br><font color="red">メールアドレスまたはパスワードが間違っています。<br>再入力してください。</font><br>
</p>
<p><input type='button' name='send' value="登録" disabled></p>

  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="../js/mypagemailcheck.js"></script>
<%@include file="../html/footer.html" %>
