$(document).ready(function() {

    $('#mail').keyup(function() {
        $('#result').html(checkemail($('#mail').val()));
    })

    function checkemail(email) {
      var address = email;
        let inputElement = $('input[name="send"]');
      var reg = /^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}\.[A-Za-z0-9]{1,}$/;
      console.log(11);
      console.log(address);
        if (reg.test(address)) {
          inputElement.prop('disabled', false);
          console.log(11);
          return '適切です'
        } else {
          console.log(11);
          inputElement.prop('disabled', true);
          return '不適切です'
        }
    }
});
