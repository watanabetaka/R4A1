$(document).ready(function() {

    $('#password').keyup(function() {
        $('#result').html(checkStrength($('#password').val()))
    })

    function checkStrength(password) {

        var strength = 0 ;//強さ
        let inputElement = $('input[name="send"]');


        if (password.length < 6) {
            $('#result').removeClass()
            $('#result').addClass('short')
            return '不適切です'
        }

        // 文字数が7より大きいければ+1
        if (password.length > 7) strength += 1
        // 英字の大文字と小文字を含んでいれば+1
        if (password.match(/([a-z].*[A-Z])||([A-Z].*[a-z])/)) strength += 1
        // 英字と数字を含んでいれば+1
        if (password.match(/([0-9])/)) strength += 1

        // 点数を元に強さを計測
        if (strength > 2) {
            $('#result').removeClass();
            document.getElementById("result").innerHTML = "正しい入力です";
            if(document.getElementById("result").innerHTML=="正しい入力です"&&document.getElementById("result_confirm").innerHTML=="上記のパスワードと一致しています"){
              console.log(document.getElementById("result").innerHTML);
              inputElement.prop('disabled', false);
            }
        } else {
            $('#result').removeClass();
            inputElement.prop('disabled', true);
        }

      }
});
