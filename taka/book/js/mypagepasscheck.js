$(document).ready(function() {

    $('#new_pass').keyup(function() {
        $('#result').html(checkStrength($('#new_pass').val()))
    })

    function checkStrength(pass) {

        var strength = 0 ;//強さ
        let inputElement = $('input[name="send"]');

        // 文字数が7以上であれば-1
        if (pass.length <= 7) strength -= 1
        // 文字数が7より大きいければ+1
        if (pass.length > 7) strength += 1
        // 英字の大文字と小文字を含んでいれば+1
        if (pass.match(/[A-Z]/)) strength += 1
        // 英字と数字を含んでいれば+1
        if (pass.match(/([0-9])/)) strength += 1

        // 点数を元に強さを計測
        if (strength > 2) {
            $('#result').removeClass();
            document.getElementById("result").innerHTML = "入力方式が合致しています";
            if(document.getElementById("result").innerHTML=="入力方式が合致しています"&&document.getElementById("result_2").innerHTML=="上の入力と一致しています"){
              inputElement.prop('disabled', false);
            }
        } else {
            $('#result').removeClass();
            inputElement.prop('disabled', true);
            document.getElementById("result").innerHTML = "入力方式と合致していません";
        }

      }
});
