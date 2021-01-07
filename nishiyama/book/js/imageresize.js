$(function() {
  var file = null; // 選択されるファイル
  var blob = null; // 画像(BLOBデータ)
  const THUMBNAIL_WIDTH = 500; // 画像リサイズ後の横の長さの最大値
  const THUMBNAIL_HEIGHT = 500; // 画像リサイズ後の縦の長さの最大値

  // ファイルが選択されたら
  $('input[type=file]').change(function() {

    // ファイルを取得
    file = $(this).prop('files')[0];
    // 選択されたファイルが画像かどうか判定
    if (file.type != 'image/jpeg' && file.type != 'image/png') {
      // 画像でない場合は終了
      file = null;
      blob = null;
      return;
    }

    // 画像をリサイズする
    var image = new Image();
    var reader = new FileReader();
    reader.onload = function(e) {
      image.onload = function() {
        var width = 300, height = 300;
        // サムネ描画用canvasのサイズを上で算出した値に変更
        var canvas = $('#canvas')
                     .attr('width', width)
                     .attr('height', height);
        var ctx = canvas[0].getContext('2d');
        // canvasに既に描画されている画像をクリア
        ctx.clearRect(0,0,width,height);
        // canvasにサムネイルを描画
        ctx.drawImage(image,0,0,image.width,image.height,0,0,width,height);

        // canvasからbase64画像データを取得
        var base64 = canvas.get(0).toDataURL('image/jpeg');
        // base64からBlobデータを作成
        var barr, bin, i, len;
        bin = atob(base64.split('base64,')[1]);
        len = bin.length;
        barr = new Uint8Array(len);
        i = 0;
        while (i < len) {
          barr[i] = bin.charCodeAt(i);
          i++;
        }
        blob = new Blob([barr], {type: 'image/jpeg'});
        console.log(blob);
      }
      image.src = e.target.result;
    }
    reader.readAsDataURL(file);
  });


});
