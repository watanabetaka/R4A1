<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<%@page import="bean.Sightseeing_Place, java.util.List" %>

<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<%-- 観光地詳細画面の表示 --%>
<%-- 原田 --%>

<%-- サーブレットより、listを取得 --%>
<% List<Sightseeing_Place> list=(List<Sightseeing_Place>)request.getAttribute("list"); %>

<header>
  <%-- お気に入り一覧画面へ戻るボタン --%>
  <div id="back">
    <a href="favoritelist">＜</a>
  </div>

  <%-- タイトルの表示 --%>
  <div id="favorite_title">お気に入り</div>

  <%-- 削除ボタン --%>
  <%-- <この画面を実行しようとしている方へ> --%>
  <%-- 現在、削除ボタンが他のCSSで加工されている要素と重なってしまっており、ボタンとしての機能を持っていません--%>
  <div id="delete">
    <%-- Favoritedelete.actionへ sightseeing_id の値を受け渡す --%>
    <form action="Favoritedelete.action" id="delete_button">
      <input type="hidden" name="sightseeing_id" value="<%
      for(Sightseeing_Place s: list){
        out.print(s.getSightseeing_Id());
      }
      %>">
      <%-- エラーが生じた時は、下記のコードをコメントアウトして再度実行してください --%>
      <%-- <input type="hidden" name="test" value="aaa"> --%>
      <input type="submit" value="CSSにて、他の要素とボタンが重なっており、現在、削除できません">
    </form>
  </div>

</header>

<%-- 観光地の表示 --%>

<%-- ぱんくずリストの表示 --%>
<div id="breadcrumb">
  <a href="http://192.168.68.103:8080/book/favorite/Favoritesort.action?array_genre=<%for(Sightseeing_Place s: list){out.print(s.getGenre_Name());}%>"><%for(Sightseeing_Place s: list){out.print(s.getGenre_Name());}%></a>
  >
  <a href="http://192.168.68.103:8080/book/favorite/Favoritesort.action?array_city=<%for(Sightseeing_Place s: list){out.print(s.getCity_Name());}%>"><%for(Sightseeing_Place s: list){out.print(s.getCity_Name());}%></a>
  >
  <%for(Sightseeing_Place s: list){out.print(s.getSightseeing_Name());}%>
</div>

<%-- 観光地名の表示 --%>
<div id="sightseeing_place">
<%
for(Sightseeing_Place s: list){
 out.print(s.getSightseeing_Name());
}
%>
</div>

<%-- 市名の表示 --%>
<div id="city_name">
<%
for(Sightseeing_Place s: list){
 out.print(s.getCity_Name());
}
%>
</div>

<%-- ジャンルの表示 --%>
<div id="genre_name">
<%
for(Sightseeing_Place s: list){
 out.print(s.getGenre_Name());
}
%>
</div>

<%-- 観光地の写真を表示 --%>
<div id="picture">
  <img src="<% for(Sightseeing_Place s: list){ out.print(s.getPicture_Path()); } %>">
</div>

<%-- 郵便番号の表示 javascriptにて加工--%>
<div id="postal_code">〒
  <div id="postal_code_insert"></div>
</div>

<%-- 住所の表示 --%>
<div id="street_adress">
  <%
  for(Sightseeing_Place s: list){
    out.print(s.getStreet_Adress());
  }
  %>
</div>

<%-- 電話番号の表示 javascriptにて加工 --%>
<div id="phone_number"></div>

<%-- 営業時間の表示 javascriptにて加工--%>
<div id="business_hour"></div>

<%-- 最寄り駅と最寄り駅からの時間を表示 javascriptにて加工--%>
<div id="nearest_station_time"></div>

<%-- 観光地名をGoogle検索 --%>
<%-- 下記のURLでは、iOSアプリでしか機能しない --%>
<a target="_blank" href="google://search?q=<% for(Sightseeing_Place s: list){ out.print(s.getSightseeing_Name()); } %>" id="google">Googleで検索</a>
<%-- <a target="_blank" href="https://www.google.co.jp" id="google">Googleで検索</a> --%>

<div class="yajirushi"><img src="../image/yajirushi.jpg"></div>

<%-- 観光地の予約サイトURLの挿入 javascriptにて加工--%>
<%-- もし企業が予約サイトURLを登録していなければ表示されない --%>
<div id="reservation_url"></div>




<%-- SNSでシェアする機能（末松君実装） --%>
<%-- 末松くんへ --%>
<%-- 下記のaタグのフォーマットに従って作ってください --%>
<%-- <a target="_blank" href="https://twitter.com/?lang=ja" id="twitter">Twitterでシェア</a> --%>
<a target="_blank" href="https://twitter.com/share?ref_src=twsrc%5Etfw" class="twitter-share-button" data-text="「」に行きました！" data-url=" " data-hashtags="まいらいずおおいた" id="twitter">twitterでシェア</a>
<a target="_blank" href="https://www.instagram.com/?hl=ja" id="instagram">Instagramでシェア</a>
<a target="_blank" href="https://ja-jp.facebook.com/" id="facebook">facebookでシェア</a>

<%-- twitterのAPI --%>
<script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>

<%-- JAVAの値をJavascriptに変換 --%>
<script>
let postal_code= '<%
for(Sightseeing_Place s: list){
  out.print(s.getPostal_Code());
}
%>';

let phone_number = '<%
for(Sightseeing_Place s: list){
  out.print(s.getPhone_Number());
}
%>';

let business_hour= '<%
for(Sightseeing_Place s: list){
  out.print(s.getBusiness_Hour());
}
%>';

let nearest_station_time= '<%
for(Sightseeing_Place s: list){
  out.print(s.getNearest_Station());
}
%>';

let reservation_url='<%
for(Sightseeing_Place s: list){
  out.print(s.getUrl());
} %>';
</script>

<%-- 観光地の体裁を整えるjavascriptファイルを読み込み --%>
<script type="text/javascript" src="../js/sightseeing_detail.js"></script>

<%@include file="../html/gamenhuta.html" %>

<%@include file="../html/footer.html" %>
