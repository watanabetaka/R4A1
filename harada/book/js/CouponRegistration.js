// ajax通信で送信するデータを変数に保存
//let request={
//  sightseeing_id:array_sightseeing_id[count-1]
//};
//Twitterのシェアボタンが押された場合
  // ajax通信の実行
  $.ajax({
    // 送信したいリクエストタイプを指定
    type : "GET",
    // 通信するサーブレットのURLを指定
    url  : "http://10.23.104.39:8080/book/favorite/couponregistration",
    // 送信するデータを指定
    //data : request,
    // 非同期通信であればtrue、同期通信であればfalseを指定
    async: false,

    // エラーが発生した際に表示させるアラート
    error:function(XMLHttpRequest,textStatus,errorThrown){
      alert("エラーが発生し、クーポンを取得できませんでした。:"+textStatus+errorThrown);
    }
  });
