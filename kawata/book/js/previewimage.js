function previewImage(obj)
{
  //写真ファイルを読み込むためのオブジェクト
	var fileReader = new FileReader();
  //ユーザがアップロードした画像ファイルをreadAsDataURLで読み込む
  fileReader.readAsDataURL(obj.files[0]);
  // previewのsrcにreadAsDataURLで読み込んだファイルを入れる
	fileReader.onload = (function() {
		document.getElementById('preview').src = fileReader.result;
	});
}
