// このjavascriptファイルにおいて行っていること
// 要素をドラッグ可能にし、アイメーションを追加
// サーブレットとのajax通信を行い、データベースへ追加（レスポンスはなし）

// 添え字の初期化
count=0;

// 配列の中身をconsoleに表示
console.log(array_sightseeing_id);
console.log(array_sightseeing_name);
console.log(array_city_name);
console.log(array_picture_path);

// ドキュメント内のイベントの取得
$(document).ready(function(event) {

  // 最初に表示する観光地情報を表示
  addNewSightseeing();

  function swipe() {
    // 指定したIDをドラッグを可能に
    Draggable.create("#picture_path", {
      // なめらかにアニメーションを動かす命令
      throwProps:true,

      // 指が離れる前と離れた後のX軸の変化を取得するメソッド
      // ＋なら右スワイプ、値がーなら左スワイプと判定
      onDragEnd:function(endX) {

        if(Math.round(this.endX) > 0 ) {
          swipeLike();
        }
        else {
          swipeDislike();
        }

        // 指が離れる前と離れた後のX軸の変化値を表示
        console.log(Math.round(this.endX));
      }
    });
  }

  function swipeLike() {

    // ajax通信で送信するデータを変数に保存
    let request={
      sightseeing_id:array_sightseeing_id[count-1]
    };

    // ajax通信の実行
    $.ajax({
      // 送信したいリクエストタイプを指定
      type : "GET",
      // 通信するサーブレットのURLを指定
      url  : "http://localhost:8080/book/sightseeing_swipe/favorite_insert",
      // 送信するデータを指定
      data : request,
      // 非同期通信であればtrue、同期通信であればfalseを指定
      async: true,
      // エラーが発生した際に表示させるアラート
      error:function(XMLHttpRequest,textStatus,errorThrown){
        alert("エラーが発生し、お気に入りに登録できませんでした。:"+textStatus+errorThrown);
      }

    });

    // アニメーションを加えたい要素を変数に挿入
    let picture_path = $("#picture").find('#picture_path');

    // スワイプ後のアニメーションの指定
    let swipe = new TimelineMax({repeat:0, yoyo:false, repeatDelay:0, onComplete:remove, onCompleteParams:[picture_path]});
    swipe.staggerTo(picture_path, 0.8, {bezier:[{left:"+=400", top:"+=300", rotation:"60"}], ease:Power1.easeInOut});

    // 次の観光地情報を表示
    addNewSightseeing();
  }

  function swipeDislike() {

    // アニメーションを加えたい要素を変数に挿入
    let picture_path = $("#picture").find('#picture_path');


    // スワイプ後のアニメーションの指定
    let swipe = new TimelineMax({repeat:0, yoyo:false, repeatDelay:0, onComplete:remove, onCompleteParams:[picture_path]});
    swipe.staggerTo(picture_path, 0.8, {bezier:[{left:"+=-350", top:"+=300", rotation:"-60"}], ease:Power1.easeInOut});

    // 次の観光地情報を表示
    addNewSightseeing();
  }

  // 要素の削除
  function remove(picture_path) {
      $(picture_path).remove();
  }

  // 観光地名、市名、写真を表示するメソッド
  function addNewSightseeing() {

    let sightseeing_name = array_sightseeing_name[count];
    let city_name = array_city_name[count];
    let picture_path = array_picture_path[count];
    if(count !== array_sightseeing_name.length){
      $('#sightseeing_place').html(sightseeing_name);
      $('#city_name').html(city_name);
      $("#picture").prepend('<img id="picture_path" src="'+picture_path+ '">');
    }else{
      $('#sightseeing_place').html("");
      $('#city_name').html("");
      $("#picture").prepend('<div id="no_sightseeing">表示できる観光地はありません</div>');
    }

    count=count+1;

    swipe();
  }

});
