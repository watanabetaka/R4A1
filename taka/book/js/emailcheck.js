$(document).ready(function() {

    $('#email').keyup(function() {
        $('#result').html(checkemail($('#email').val()))
    })

    function checkemail(email) {
      var address = email;
        let inputElement = $('input[name="send"]');
      var reg = /^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}\.[A-Za-z0-9]{1,}$/;;
        if (reg.test(address)) {
          document.getElementById("result").innerHTML = "適切です";
          if(document.getElementById("result").innerHTML=="適切です"&&document.getElementById("result_2").innerHTML=="適切です"){
            inputElement.prop('disabled', false);
          }
          console.log(document.getElementById("result").innerHTML);
          console.log(document.getElementById("result_2").innerHTML);
        } else {
          $('#result_1').removeClass()
          inputElement.prop('disabled',true);
    }
});
