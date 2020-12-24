<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@page import="bean.Sightseeing_Place, java.util.List" %>

<%-- 観光地詳細画面の表示 --%>
<%-- 原田 --%>

<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<%-- サーブレットより、listを取得 --%>
<% List<Sightseeing_Place> list=(List<Sightseeing_Place>)request.getAttribute("list"); %>
<header>
  <%-- 末松が作成した、お気に入り一覧画面へ戻るボタン --%>
  <div id="back">
    <form action="">
      <input type="submit" value="＜">
    </form>
  </div>

  <%-- タイトルの表示 --%>
  <div id="favorite_title">お気に入り</div>

  <%-- 削除ボタン --%>
  <div id="delete">
    <script>
      let sightseeing_id = '<%
      for(Sightseeing_Place s: list){
        out.print(s.getSightseeing_Id());
      }
      %>';
    </script>

    <form action="Favoritedelete.action" id="delete_button">
      <input type="submit" value="削除" onclick=delete_send();>
    </form>
  </div>
</header>

<%-- 観光地の表示 --%>


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

<%-- 以下、観光地詳細画面（渡邊） --%>

<%-- 郵便番号の表示 --%>
<div id="postal_code">〒
  <div id="postal_code_insert">
    <script>
    let postal_code= '<%
      for(Sightseeing_Place s: list){
        out.print(s.getPostal_Code());
      }
      %>';
    </script>
  </div>
</div>

<%-- 住所の表示 --%>
<div id="street_adress">
  <%
  for(Sightseeing_Place s: list){
    out.print(s.getStreet_Adress());
  }
  %>
</div>

<%-- 電話番号の表示 --%>
<div id="phone_number">
  <script>
    let phone_number = '<%
    for(Sightseeing_Place s: list){
      out.print(s.getPhone_Number());
    }
    %>';
  </script>
</div>

<%-- 営業時間の表示 --%>
<div id="business_hour">
  <%
  for(Sightseeing_Place s: list){
    out.print(s.getBusiness_Hour());
  }
  %>
</div>

<%-- 最寄り駅と最寄り駅からの時間を表示 --%>
<div id="nearest_station_time">
  <%
  for(Sightseeing_Place s: list){
    out.print(s.getNearest_Station());
  }
  %>
</div>

<%-- 観光地詳細画面（末松） --%>

<%-- 観光地名をGoogle検索 --%>
<a href="https://www.google.com/search?q=<% for(Sightseeing_Place s: list){ out.print(s.getSightseeing_Name()); } %>" id="google">Googleで検索</a>

<div class="yajirushi"><img src="../image/yajirushi.jpg"></div>


<%-- 観光地の予約サイトURLの挿入 --%>
<%-- もし企業が予約サイトURLを登録していなければ表示されない --%>
<div id="reservation_url">
  <%-- <a href="<% for(Sightseeing_Place s: list){ out.print(s.getUrl()); } %>" id="jaran">じゃらんで表示</a> --%>
  <script>
    let reservation_url='<%
    for(Sightseeing_Place s: list){
      out.print(s.getUrl());
    } %>';
    </script>
</div>

<%-- <div class="yajirushi"><img src="../image/yajirushi.jpg"></div> --%>

<%-- 観光地の体裁を整えるjavascriptファイルを読み込み --%>
<script type="text/javascript" src="../js/sightseeing_detail.js"></script>


<%@include file="../gamenhuta.html" %>

<%@include file="../footer.html" %>
