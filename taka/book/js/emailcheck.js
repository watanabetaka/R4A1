$(document).ready(function() {

    $('#email').keyup(function() {
        $('#result').html(checkemail($('#email').val()))
    })

    function checkemail(email) {
      var address = email;
        let inputElement = $('input[name="send"]');
      var reg = /^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}\.[A-Za-z0-9]{1,}$/;;
        if (reg.test(address)) {
          $('#result').removeClass()
          $('#result').addClass('強いです！!')
          inputElement.prop('disabled', false);
          return '正しい入力方式です。送信ボタンが押せます。'
        } else {
          $('#result').removeClass()
          $('#result').addClass('弱いです〜')
          inputElement.prop('disabled', true);
          return '誤った入力方式です'
        }
    }
});
