$(document).ready(function() {

$('#new_address').keyup(function() {
  $('#result').html(checkemail($('#new_address').val()))
})

function checkemail(new_address) {
  var address = new_address;
  let inputElement = $('input[name="send"]');
  var reg = /^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}\.[A-Za-z0-9]{1,}$/;;
  if (reg.test(address)) {
    $('#result_1').removeClass()
    document.getElementById("result").innerHTML = "適切です";
    if(document.getElementById("result").innerHTML=="適切です"&&document.getElementById("result_2").innerHTML=="適切です"){
      inputElement.prop('disabled', false);
    }
    console.log(document.getElementById("result").innerHTML);
    console.log(document.getElementById("result_2").innerHTML);
  } else {
    $('#result_1').removeClass()
    inputElement.prop('disabled',true);
    console.log(document.getElementById("result").innerHTML);
    console.log(document.getElementById("result_2").innerHTML);
  }
}
});
