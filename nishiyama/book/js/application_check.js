// クーポン申請画面の加工

// ユーザーが既にクーポン申請を行っていたら、"申請中です" の文字列を表示する
// ユーザーが観光地を登録していなければ、観光地を登録してくださいの文字列を表示する
// 上記の条件をクリアすれば、クーポン申請フォームを表示する

// 申請中のメッセージが入力されている場合はクーポン申請フォームを表示、入力されていない場合はメッセージを表示する
if(message === 'null'){

  // 観光地が登録されていない場合はメッセージを表示、登録している場合はクーポン申請フォームを表示する
  if(array_sightseeing_id.length === 0){
    $('#view').append('<div class="message">観光地を登録してください</div>')

  }else{
    $('#view').append('<form id="application_form" action="Couponinsert.action"><div class="coupon_application">観光地名を選択してください</div><select class=sightseeing_select name="sightseeing_id" id="select">');

    // 拡張for文的なやつで、id はプロパティではなく、インデックス値を返している
    for (let id in array_sightseeing_id) {
      $('#select').append('<option class="insert_sightid" value="' + array_sightseeing_id[id] + '">' + array_sightseeing_name[id] + '</option>');
    }

    $('#select').append('</select>')
    $('#application_form').append('<br><br><div class="coupon_application">クーポン割引情報</div><input type="text" id="coupon_name" name="coupon_name"><div id="forexample">（例）○○入場料200円引き</div><br><br><input type="submit" id="application_submit" value="申請">');
    $('#view').append('</form>');
  }

}else{
  $('#view').append('<div class="message">'+ message + '</div>')
}

// 送信ボタンが押されて、文字列が入力されていなかった場合の処理
$('form#application_form').submit(function(event){
  let coupon_name = $('#coupon_name').val();
  // 文字列が入力されているかの分岐
  if(coupon_name.length === 0){
    event.preventDefault();
    // id application_error が既に存在している場合の処理
    if(!$('#application_error').length){
      // coupon_application クラスの二つ目の子要素にエラー文を挿入する
      $('.coupon_application').eq(1).append('<div id="application_error"><font color="red">※クーポン割引情報を入力してください</font></div>  ')
        return false;
    }
  }
});
