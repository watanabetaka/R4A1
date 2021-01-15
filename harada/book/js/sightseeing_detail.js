//郵便番号、電話番号、営業時間、最寄り駅からの時間、
// 予約サイトURLを加工して表示するファイル

// 変数の初期化
let insert;
let temp;


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


// 電話番号が10桁の場合の、電話番号に - を挿入する処理
insert = '';

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


// 営業時間を , 区切りで改行する処理
insert = '';

for(let i = 0 ; i < business_hour.length ; i++){
  temp = business_hour[i];
  if(business_hour[i] === ','){
    $('#business_hour').append(insert + "<br>");
    insert = '';
  }else{
    insert = insert + temp;
  }
}
$('#business_hour').append(insert);


// 最寄り駅からの時間を , 区切りで改行する処理
insert = '';

for(let i = 0 ; i < nearest_station_time.length ; i++){
  temp = nearest_station_time[i];
  if(nearest_station_time[i] === ','){
    $('#nearest_station_time').append(insert + "<br>");
    insert = '';
  }else{
    insert = insert + temp;
  }
}
$('#nearest_station_time').append(insert);


// 予約サイトURLが登録されていたら、予約サイトのURLと挿入画像を表示する処理
if(reservation_url.length !== 0){
  $('#reservation_url').html('<a target="_blank" href="' + reservation_url + '" id="jaran">外部サイトで表示</a>');
}
