//クーポン取得お知らせ通知処理
document.getElementById("twitter").onclick = function() {
  // ここに#buttonをクリックしたら発生させる処理を記述する
  $(function(){
     location.href = "http://" + ipadress + ":8080/book/favorite/couponregistration";
  });
};
