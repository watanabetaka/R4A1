// すいません途中でjQueryも使ってます（あとちょっと汚いですたぶん）　ｂｙ原田

// このJSファイルで行っていること
// ・クーポン重複の際の重複枚数表示
// ・日付加工の処理し、有効期限時間の残りの時間を表示
// ・有効期限時間が来たら、自動的に画面を更新し、獲得クーポンデータベースから行を削除
// ・モーダルウィンドウをクリックした際のクラスの追加・削除（CSSのため）
// ・モーダルウィンドウのYESボタンをクリックした際のサーブレットへの送信


console.log(array_sightseeing_name);
console.log(array_coupon_id);
console.log(array_get_coupon_etime);


// クーポン表示・非表示の加工用変数
let temp = [];
let temp_submit = 0;
let count = 1;
let dummy_count = 0;
let temp_date;
let temp_current;
let temp_hour;
let temp_minute;
let temp_second;

// クーポンを獲得していなかった時の処理
if(array_coupon_id.length == 0){
  $('#coupon').append('<div id="no_coupon">まだクーポンを獲得していません<br>');
  $('#coupon').append('観光地の感想をSNSでシェアして、クーポンをゲットしよう！</div>');
}

const coupon = document.getElementById('coupon');
const opens = document.getElementsByClassName('open');
const close = document.getElementById('close');
const modal = document.getElementById('modal');
const mask = document.getElementById('mask');
const yes = document.getElementById('YES');

// 同じクーポンの場合、そのクーポンの枚数を表示する処理

// 表示するクーポンのループ
for(let i = 0 ; i < array_coupon_id.length ; i++){

  // dummy_countという文字列を含まなかった場合の処理
  if(!array_coupon_id[i].match('dummy_count')){

    // 比較対象のクーポンのループ
    for(let j = i + 1 ; j < array_coupon_id.length ; j++){

      // 比較したクーポンIDが同じ数字の場合の処理
      if(array_coupon_id[i] == array_coupon_id[j]){
        count++;
        // 一致した要素[j]を今後の比較対象から外すため、ダミーの文字列と数値を配列にいれる
        array_coupon_id[j] = 'dummy_count' + dummy_count;
        dummy_count++;
      }
    }

    // HTML文の表示
    $('#coupon').append('<div id="deco_parent' + i + '" class="deco_parent"></div>');
    $('#deco_parent' + i).append('<div class="deco"><img class="picture" src="../image/' + array_picture_path[i] + '"></div>');
    $('#deco_parent' + i).append('<div class="deco"><p class="name sightseeing_name">' + array_sightseeing_name[i] + '</p><p class="name coupon_name">' + array_coupon_name[i] + '</p><font color="red"><p id="insert_time' + i + '" class="name valid"></p></font></div>');

    // 日付加工用の変数
    let array_count;
    let insert = '';
    let insert_auth = '';
    let temp_etime;
    let array_etime = array_get_coupon_etime[i];
    let dead = '';

    // array_get_coupon_etime が null の場合、表示しない処理
    if(array_get_coupon_etime[i] != 'null'){
      array_count=0;

      // デフォルトの日付型は yyyy-mm-dd hh:mm:ss のため、変換する処理
      // 同時に後で用いる、 javascript のデータ型にも変換する
      if(array_etime.match('-') || array_etime.match(':')){
        for(let temp_count = 0 ; temp_count < array_etime.length ; temp_count++){
          temp_etime = array_etime[temp_count];
          // console.log(temp_etime);
          if(temp_etime == '-' && array_count === 0){
            insert = insert + '/';
            insert_auth = insert_auth + '/';
            array_count ++;
          }else if(temp_etime == '-' && array_count === 1){
            insert = insert + '/';
            insert_auth = insert_auth + '/';
            array_count ++;
          }else if(temp_etime == ' ' && array_count === 2){
            insert = insert + ' ';
            insert_auth = insert_auth + ' ';
            array_count ++;
          }else if(temp_etime == ':' && array_count === 3){
            insert = insert + ':';
            insert_auth = insert_auth + ':';
            dead='dead';
            array_count ++;
          }else if(temp_etime == ':' && array_count === 4){
            insert = insert + ':';
            array_count ++;
          }else if(temp_etime == '.' && array_count === 5){
            insert = insert + '';
            array_count ++;
          }else if(array_count > 5){
            // 秒以降は何も表示しない
          }else{
            insert = insert + temp_etime;
            if(dead != 'dead'){
            insert_auth = insert_auth + temp_etime;
            }
          }


        }
      }


      setInterval('showClock(' + i + ')',1000);
      // console.log(i);
      function showClock(i){
        // 日付加工用の変数
        let array_count;
        let insert = '';
        let insert_auth = '';
        let temp_etime;
        let array_etime = array_get_coupon_etime[i];
        let dead = '';

        // array_get_coupon_etime が null の場合、表示しない処理
        if(array_get_coupon_etime[i] != 'null'){
          array_count=0;

          // デフォルトの日付型は yyyy-mm-dd hh:mm:ss のため、変換する処理
          // 同時に後で用いる、 javascript のデータ型にも変換する
          if(array_etime.match('-') || array_etime.match(':')){
            for(let temp_count = 0 ; temp_count < array_etime.length ; temp_count++){
              temp_etime = array_etime[temp_count];
              // console.log(temp_etime);
              if(temp_etime == '-' && array_count === 0){
                insert = insert + '/';
                insert_auth = insert_auth + '/';
                array_count ++;
              }else if(temp_etime == '-' && array_count === 1){
                insert = insert + '/';
                insert_auth = insert_auth + '/';
                array_count ++;
              }else if(temp_etime == ' ' && array_count === 2){
                insert = insert + ' ';
                insert_auth = insert_auth + ' ';
                array_count ++;
              }else if(temp_etime == ':' && array_count === 3){
                insert = insert + ':';
                insert_auth = insert_auth + ':';
                dead='dead';
                array_count ++;
              }else if(temp_etime == ':' && array_count === 4){
                insert = insert + ':';
                array_count ++;
              }else if(temp_etime == '.' && array_count === 5){
                insert = insert + '';
                array_count ++;
              }else if(array_count > 5){
                // 秒以降は何も表示しない
              }else{
                insert = insert + temp_etime;
                if(dead != 'dead'){
                insert_auth = insert_auth + temp_etime;
                }
              }


            }
          }
        }
        // クーポンの有効期限日の表示
        temp_date = new Date();
        temp_current = new Date(insert);
        temp_date = new Date(temp_current - temp_date);
        if(temp_date > 0){
          temp_minute = temp_date.getMinutes();
          temp_second = temp_date.getSeconds();
          // console.log(temp_minute);
        }else{
          temp_minute = 0;
          temp_second = 0;
        }

        if(temp_minute === 0 && temp_second ===0){
          // reloadメソッドによりページをリロード
           window.location.reload();
        }else{
          if(temp_minute === 0){
            document.getElementById('insert_time' + i).innerHTML = '残り' + temp_second + '秒 有効';
          }else{
            document.getElementById('insert_time' + i).innerHTML = '残り' + temp_minute + '分' + temp_second + '秒 有効';
          }
        }

        }

    }

    $('#deco_parent' + i).append('</div>');

    // 当該クーポンの重複枚数の表示
    $('#deco_parent' + i).append('<div class="deco count">×' + count + '</div>');

    // クーポンの有効期限が設定されている場合、クーポンの発行ができないようにする
    if(array_get_coupon_etime[i] != 'null'){
      $('#deco_parent' + i).append('<div class="deco"><input type="button" id="' + array_get_coupon_id[i] + '" class="btn not_open" value="発行中" style="width: 100%; padding: 5%";></div>');
    }else{
      $('#deco_parent' + i).append('<div class="deco"><input type="button" id="' + array_get_coupon_id[i] + '" class="btn open" value="発行" style="width: 100%; padding: 5%";></div>');
    }
    $('#deco_parent' + i).append('<br clear="all">');
    $('#deco_parent' + i).append('<p class="kasen">&nbsp;</p>');
    $('#deco_parent' + i).append('</div>');
  }

  // クーポンの重複枚数の初期化
  count=1;
}

// 全ての発行ボタンに、クリックしたら get_coupon_id を取得し、変数に保存する処理 を加える処理
for(let i=0; i < opens.length ; i++){
  temp[i]=opens[i].getAttribute('id');
  opens[i].addEventListener('click', function () {
    temp_submit=opens[i].getAttribute('id');
    modal.classList.remove('hidden');
    mask.classList.remove('hidden');
  });
}


// モーダルウィンドウの NO ボタンを押した際の処理
close.addEventListener('click', function () {
  modal.classList.add('hidden');
  mask.classList.add('hidden');
});

//モーダルウィンドウ外をクリックした場合の処理
mask.addEventListener('click', function () {
  modal.classList.add('hidden');
  mask.classList.add('hidden');
});


// モーダルウィンドウの YES ボタンを押した際の処理
// get_coupon_idをサーブレットに送信する
yes.addEventListener('click', function () {

  // ajax通信で送信するデータを変数に保存
  let request={
    get_coupon_id:temp_submit
  };
  // ajax通信の実行
  $.ajax({
    // 送信したいリクエストタイプを指定
    type : "GET",
    // 通信するサーブレットのURLを指定
    url  : "http://10.23.104.39:8080/book/coupon/couponupdate",
    // 送信するデータを指定
    data : request,
    // 非同期通信であればtrue、同期通信であればfalseを指定
    async: true,
    error:function(){
      alert("エラーが発生し、処理できませんでした。:　管理者にお問合せください"+textStatus+errorThrown);
    }

  });

  // reloadメソッドによりページをリロード
   window.location.reload();
});
