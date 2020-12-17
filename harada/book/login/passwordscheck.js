$(document).ready(function() {

    $('#pass').keyup(function() {
        $('#result').html(checkStrength($('#pass').val()))
    })

    function checkStrength(pass) {

        var strength = 0 //強さ

        if (pass.length < 6) {
            $('#result').removeClass()
            $('#result').addClass('short')
            return '短すぎる！！'
        }

        // 文字数が7より大きいければ+1
        if (pass.length > 7) strength += 1
        // 英字の大文字と小文字を含んでいれば+1
        if (pass.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/)) strength += 1
        // 英字と数字を含んでいれば+1
        if (pass.match(/([a-zA-Z])/) && pass.match(/([0-9])/)) strength += 1
        // 記号を含んでいれば+1
        if (pass.match(/([!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1
        // 記号を2つ含んでいれば+1
        if (pass.match(/(.*[!,%,&,@,#,$,^,*,?,_,~].*[!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1

        // 点数を元に強さを計測
        if (strength < 2) {
            $('#result').removeClass()
            $('#result').addClass('弱いです〜')
            return 'Weak'
        } else if (strength == 2) {
            $('#result').removeClass()
            $('#result').addClass('良い感じ！！')
            return 'Good'
        } else {
            $('#result').removeClass()
            $('#result').addClass('強いです！!')
            return 'Strong'
        }
    }
});
