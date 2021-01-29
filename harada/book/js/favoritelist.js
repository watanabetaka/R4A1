//削除ボタンの処理
delete_button();

function delete_button(){

  $('#not_delete').on('click' , function(){

    $('button[name="delete_button"]').html('<font size=5>終了</font>');
    $('#not_delete').attr('id', 'while_delete');

    for(sightseeing_id of array_sightseeing_id){
      $('#' + sightseeing_id).prepend('<button type="button" id="button_id' + sightseeing_id + '" class="delete_button" name="sightseeing_id" value="' + sightseeing_id + '"><b class="minus">―</b></button>');
    }

    $('.favoimg').attr('type','button');

    $('.delete_button').on('click', function() {
        // ajax通信で送信するデータを変数に保存
        let request={
          sightseeing_id: $(this).val(),
          ajax_trust:"true"
        };
        // ajax通信の実行
        $.ajax({
          // 送信したいリクエストタイプを指定
          type : "GET",
          // 通信するサーブレットのURLを指定
          url  : "http://" + ipadress + ":8080/book/favorite/favoritedelete",
          // 送信するデータを指定
          data : request,
          // 非同期通信であればtrue、同期通信であればfalseを指定
          async: true,
          error:function(){
            alert("エラーが発生し、処理できませんでした。:　管理者にお問合せください"+textStatus+errorThrown);
          }
        });

        for(soezi in array_sightseeing_id){
          if(array_sightseeing_id[soezi] == $(this).val()){
            array_sightseeing_id.splice(soezi,1);
          }
        }
        $('#' + $(this).val()).remove();
    });

    $('#while_delete').on('click' , function(){
      if(0 === array_sightseeing_id.length){
        $('#mada').html('まだ観光地を登録していません！');
      }
      $('.favoimg').attr('type','submit');
      $('button[name="delete_button"]').html('<font size=5>削除</font>');
      $('#while_delete').attr('id', 'not_delete');
      $('.delete_button').remove();
      delete_button();
    });
  });
}
