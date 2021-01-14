$(document).ready(function() {

$('#new_address').keyup(function() {
  $('#result').html(checkemail())
})

$('#new_address_2').keyup(function() {
  $('#result_2').html(checkemail())
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
    r1.value = "true";
    r1.innerHTML = "入力方式が合致しています";
    $("#result").removeClass("result_off");
    $("#result").addClass("result_on");

  } else {
    r1.value = "false";
    r1.innerHTML = "入力方式が間違っています";
    $("#result").removeClass("result_on");
    $("#result").addClass("result_off");
    r2.innerHTML = "上の入力と一致していません";
    $("#result_2").removeClass("result_on");
    $("#result_2").addClass("result_off");
    inputElement.prop('disabled',true);
    r3.value="false";
    r3.innerHTML="不適切です";
    $("#result_3").removeClass("result_on");
    $("#result_3").addClass("result_off");
  }
  if (t1.value==t2.value) {
    r2.value = "true";
    r2.innerHTML = "入力が一致しています";
    $("#result_2").removeClass("result_off");
    $("#result_2").addClass("result_on");
    if(r1.value=="true"&&r2.value=="true"){
      inputElement.prop('disabled', false);
      r3.value="true";
      r3.innerHTML="適切です";
      $("#result_3").removeClass("result_off");
      $("#result_3").addClass("result_on");
    }
  } else {
    r2.value = "false";
    r2.innerHTML = "上の入力と一致していません";
    $("#result_2").removeClass("result_on");
    $("#result_2").addClass("result_off");
    inputElement.prop('disabled',true);
    r3.value="false";
    r3.innerHTML="不適切です";
    $("#result_3").removeClass("result_on");
    $("#result_3").addClass("result_off");
  }
}
});
