$(document).ready(function() {

    $('#new_pass').keyup(function() {
        $('#result').html(checkStrength())
    })
    $('#new_pass_2').keyup(function() {
        $('#result').html(checkStrength())
    })

    function checkStrength() {

        var strength = 0 ;//強さ
        let inputElement = $('input[name="send"]');
        var t1=document.getElementById("new_pass");
        var t2=document.getElementById("new_pass_2");
        var r1=document.getElementById("result");
        var r2=document.getElementById("result_2");
        var r3=document.getElementById("result_3");


        // 文字数が7以上であれば-1
        if (t1.value.length <= 7) strength -= 1
        // 文字数が7より大きいければ+1
        if (t1.value.length > 7) strength += 1
        // 英字の大文字と小文字を含んでいれば+1
        if (t1.value.match(/[A-Z]/)) strength += 1
        // 英字と数字を含んでいれば+1
        if (t1.value.match(/([0-9])/)) strength += 1

        // 点数を元に強さを計測
        if (strength > 2) {
            $('#result').removeClass();
            r1.innerHTML = "入力方式が合致しています";
            r1.value="true";
            if(r1.value=="true"&&r2.value=="true"){
              r3.innerHTML=="適切です";
              inputElement.prop('disabled', false);
            }
        } else {
            $('#result').removeClass();
            r1.innerHTML = "入力方式と合致していません";
            r1.value="false";
            r3.innerHTML=="不適切です";
            inputElement.prop('disabled', true);
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
