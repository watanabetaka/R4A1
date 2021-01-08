<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<form action='PassChange.action' method='post'>
<p>現在のパスワード　　　　<input type='text' id='now_pass' name='now_pass' placeholder="Type Your Password here"></p>
<p>新しいパスワード　　　　<input type='text' id='new_pass' name='new_pass' placeholder="Type Your Password here" onKeyUp="confirm()"><span id="result"></span></p>
<p>新しいパスワード（確認）<input type='text' id='new_pass_2' placeholder="Type Your Password here" onKeyUp="confirm()"><span id=result_2></span></p>
<script>
function confirm(){
  var pass_1 = document.getElementById("new_pass").value;
  var pass_2 = document.getElementById("new_pass_2").value;
  var t1=document.getElementById("result");
  var t2=document.getElementById("result_2");
  var inputElement = $('input[name="send"]');
  if(pass_1==pass_2){
    t2.innerHTML = "上の入力と一致しています";
  }else{
    t2.innerHTML = "上の入力と一致していません";
  }
  if(t1.innerHTML=="入力方式が合致しています"&&t2.innerHTML=="上の入力と一致しています"){
    inputElement.prop('disabled', false);
  }else{
    inputElement.prop('disabled', true);
  }
}
</script>
<span id='result_3'>不適切です</span>
<p>パスワードは
  <br>※アルファベットの大文字・数字を含める
  <br>※8文字以上
</p>
<p><input type='submit' name='send' value="登録" disabled></p>
</form>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/mypagepasscheck.js"></script>
<%@include file="../html/footer.html" %>
