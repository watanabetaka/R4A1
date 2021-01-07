$(document).ready(function() {

    $('#new_pass').keyup(function() {
        $('#result').html(checkStrength($('#new_pass').val()))
    })

    function checkStrength(new_pass) {

        var strength = 0 ;//強さ
        let inputElement = $('input[name="send"]');


        if (new_pass.length < 6) {
            $('#result').removeClass()
            $('#result').addClass('short')
            return '不適切です'
        }

        // 文字数が7より大きいければ+1
        // if (new_pass.length > 7) strength += 1
        // // 英字の大文字と小文字を含んでいれば+1
        if (new_pass.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/)) strength += 1
        // 英字と数字を含んでいれば+1
        if (new_pass.match(/([a-zA-Z])/) && new_pass.match(/([0-9])/)) strength += 1
        // 記号を含んでいれば+1
        if (new_pass.match(/([!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1
        // 記号を2つ含んでいれば+1
        if (new_pass.match(/(.*[!,%,&,@,#,$,^,*,?,_,~].*[!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1
        // 点数を元に強さを計測
        if (strength < 2 && new_pass.length > 8) {
            $('#result').removeClass()
            document.getElementById("result").innerHTML = "適切です";
            if(document.getElementById("result").innerHTML=="適切です"&&document.getElementById("result_2").innerHTML=="適切です"){
              inputElement.prop('disabled', false);
            }
        } else {
            $('#result').removeClass()
            document.getElementById("result").innerHTML = "不適切です";
            inputElement.prop('disabled',true);
        }
    }
});
