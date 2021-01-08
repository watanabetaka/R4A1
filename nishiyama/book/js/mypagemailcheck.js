$(document).ready(function() {

$('#new_address').keyup(function() {
  $('#result').html(checkemail())
})

$('#new_address_2').keyup(function() {
  $('#result').html(checkemail())
})

function checkemail() {
  let inputElement = $('input[name="send"]');
  var t1=document.getElementById("new_address");
  var t2=document.getElementById("new_address_2");
  var r1=document.getElementById("result");
  var r2=document.getElementById("result_2");
  var r3=document.getElementById("result_3");
  var reg = /^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}\.[A-Za-z0-9]{1,}$/;;
  if (reg.test(t1.value)) {
    $('#result').removeClass()
    r1.value = "true";
    r1.innerHTML = "入力方式が合致しています";

  } else {
    $('#result').removeClass()
    r1.value = "false";
    r1.innerHTML = "入力方式が間違っています";
    r2.innerHTML = "上の入力と一致していません";
    inputElement.prop('disabled',true);
    r3.innerHTML="不適切です";
  }
  if (t1.value==t2.value) {
    $('#result').removeClass()
    r2.value = "true";
    r2.innerHTML = "入力が一致しています";
    if(r1.value=="true"&&r2.value=="true"){
      inputElement.prop('disabled', false);
      r3.innerHTML="適切です";
    }
  } else {
    $('#result').removeClass()
    r2.value = "false";
    r2.innerHTML = "上の入力と一致していません";
    inputElement.prop('disabled',true);
    r3.innerHTML="不適切です";
  }
}
});
