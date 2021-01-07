<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<form action='checkresult' method='post'>
<p>現在のパスワード　　　　　　<input type='text' id='now_pass' placeholder="Type Your Password here"></p>
<p>新しいメールアドレス　　　　<input type='text' id='new_address' placeholder="info@example.com" onKeyUp="confirm()"><span id='result'></span></p>
<p>新しいメールアドレス（確認）<input type='text' id='new_address_2' placeholder="info@example.com" onKeyUp="confirm()"><span id='result_2'></span></p>
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
    console.log(t1.innerHTML);
    console.log(t1.innerHTML);
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
<p><input type='button' name='send' value="登録" disabled></p>

<%@include file="../html/footer.html" %>
