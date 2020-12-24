// お気に入り観光地を削除する際に送信する、 sightseeing_id をformに挿入し、
//郵便番号、電話番号、予約サイトURLを加工して表示するファイル

console.log(sightseeing_id);
console.log(postal_code);
console.log(phone_number);
console.log(reservation_url);

// 変数の初期化
let insert;
let temp;

// 削除ボタンが押された際に、formに sightseeing_id を挿入するメソッド
function delete_send(){
  $('#delete_button').append('<input type="hidden" name="sightseeing_id" value="' + sightseeing_id +'">');
}


// 郵便番号の3桁目の次に - を挿入する処理
for(let i = 0 ; i < postal_code.length ; i++){
  temp = postal_code[i];
  if(i === 0){
    insert = temp;
  }else if(i === 3){
    insert = insert + '-' + temp;
  }else{
    insert = insert + temp;
  }
}
$('#postal_code_insert').html(insert);

insert = '';

// 電話番号が10桁の場合の、電話番号に - を挿入する処理
if(phone_number.length  === 10){
  for(let i = 0 ; i < phone_number.length ; i++){
    temp = phone_number[i];
    if(i === 0){
      insert = temp;
    }else if(i === 3){
      insert = insert + '-' + temp;
    }else if(i === 6){
      insert = insert + '-' + temp;
    }else{
      insert = insert + temp;
    }
  }
}

// 電話番号が11桁の場合の、電話番号に - を挿入する処理
if(phone_number.length  === 11){
  for(let i = 0 ; i < phone_number.length ; i++){
    temp = phone_number[i];
    if(i === 0){
      insert = temp;
    }else if(i === 3){
      insert = insert + '-' + temp;
    }else if(i === 7){
      insert = insert + '-' + temp;
    }else{
      insert = insert + temp;
    }
  }
}
// 編集したphone_numberをHTMLに追加
$('#phone_number').html(insert);

// 予約サイトURLが登録されていたら、予約サイトのURLと挿入画像を表示する処理
if(reservation_url.length !== 0){
  $('#reservation_url').html('<a href="' + reservation_url + '" id="jaran">予約サイトで表示</a><div class="yajirushi"><img src="../image/yajirushi.jpg"></div>');
}
