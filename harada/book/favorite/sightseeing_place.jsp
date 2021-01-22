<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/sightseeing_place_header.html" %>
<%@page import="bean.Sightseeing_Place, java.util.List" %>
<%@include file="../ipadress/ipadress.jsp" %>

<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<%-- 観光地詳細画面の表示 --%>
<%-- 原田 --%>

<%-- サーブレットより、listを取得 --%>
<% List<Sightseeing_Place> list=(List<Sightseeing_Place>)request.getAttribute("list"); %>

<header>
  <%-- お気に入り一覧画面へ戻るボタン --%>
  <div id="back">
    <a id="modoru" href="favoritelist">＜</a>
  </div>

  <%-- タイトルの表示 --%>
  <div id="favorite_title">お気に入り</div>

  <%-- 削除ボタン --%>
  <%-- <この画面を実行しようとしている方へ> --%>
  <%-- 現在、削除ボタンが他のCSSで加工されている要素と重なってしまっており、ボタンとしての機能を持っていません--%>
  <div id="delete">
    <%-- Favoritedelete.actionへ sightseeing_id の値を受け渡す --%>
    <form action="favoritedelete" id="delete_button">
      <input type="hidden" name="sightseeing_id" value="<%
      for(Sightseeing_Place s: list){
        out.print(s.getSightseeing_Id());
      }
      %>">
      <input type="hidden" name="ajax_trust" value="false">
      <input type="submit" value="削除" id="delete_submit" style="font-size:170%;">
        <%-- <button type="button" name="delete_button0" class="update_button0" id="not_delete0">
      	<font size="5">削除
    	</font>
      </button> --%>
    </form>
  </div>

</header>

<div class="fade">

  <%-- 観光地の表示 --%>

  <%-- 観光地名の表示 --%>


  <div id="pankuzu">
    <%-- ぱんくずリストの表示 --%>
      <a id="city_name" href="http://<%= ipadress%>:8080/book/favorite/Favoritesort.action?array_genre=<%for(Sightseeing_Place s: list){out.print(s.getGenre_Name());}%>"><%for(Sightseeing_Place s: list){out.print(s.getGenre_Name());}%></a>
      >
      <a id="genre_name" href="http://<%= ipadress%>:8080/book/favorite/Favoritesort.action?array_city=<%for(Sightseeing_Place s: list){out.print(s.getCity_Name());}%>"><%for(Sightseeing_Place s: list){out.print(s.getCity_Name());}%></a>
      ><div id="sightseeing_place"><%for(Sightseeing_Place s: list){out.print(s.getSightseeing_Name());}%></div>
  </div>

  <%-- 観光地の写真を表示 --%>
  <div id="picture">
    <img src="<% for(Sightseeing_Place s: list){ out.print(s.getPicture_Path()); } %>" id ="pictures" >
  </div>

  <%-- 郵便番号の表示 javascriptにて加工--%>
  <div  id="syousai">

    <%-- 下線を表示 --%>
    <p class="kasenfirst">&nbsp;</p>

    <div class="image_class adress_container">
      <div class="adress"><img class="adress_image" src="../image/map.png"></div>
    </div>

    <div class="adress_container">
      <div class="adress" id="postal_code_insert"></div>

      <%-- 住所の表示 --%>
      <div class="adress" id="street_adress">
        <%
        for(Sightseeing_Place s: list){
          out.print(s.getStreet_Adress());
        }
        %>
      </div>
    </div>

    <div class="nothing"></div>

    <%-- 電話番号の表示 javascriptにて加工 --%>
    <div class="phone image_class"><img class="phone_image" src="../image/call.png"></div>
    <div class="phone" id="phone_number"></div>

    <div class="nothing"></div>

    <%-- 営業時間の表示 javascriptにて加工--%>
    <div class="business_hour image_class image_business"><img class="businesshour_image" src="../image/business_hour.jpg"></div>
    <div class="business_hour" id="business_hour"></div>

    <div class="nothing"></div>

    <%-- 最寄り駅と最寄り駅からの時間を表示 javascriptにて加工--%>
    <div class="neareststation neareststation_container"><img class="neareststation_image" src="../image/walk.jpg"></div>
    <div class="neareststation" id="nearest_station_time"></div>

    <%-- 下線を表示 --%>
    <div class="nothing_kasen"></div>
    <p class="kasen">&nbsp;</p>

    <div class="external">
      <%-- 観光地名をGoogle検索 --%>
      <%-- 下記のURLでは、iOSアプリでしか機能しない --%>
      <a target="_blank" href="google://search?q=<% for(Sightseeing_Place s: list){ out.print(s.getSightseeing_Name()); } %>" id="google"><div class="google">Googleで検索</div></a>
      <%-- <a target="_blank" href="https://www.google.co.jp" id="google">Googleで検索</a> --%>

      <%-- 観光地の予約サイトURLの挿入 javascriptにて加工--%>
      <%-- もし企業が予約サイトURLを登録していなければ表示されない --%>
      <div id="reservation_url"></div>
    </div>





    <%-- SNSでシェアする機能（末松君実装） --%>
    <%-- 末松くんへ --%>
    <%-- 下記のaタグのフォーマットに従って作ってください --%>
    <%-- <a target="_blank" href="https://twitter.com/?lang=ja" id="twitter">Twitterでシェア</a> --%>

    <%--twitterでレビューする際の処理--%>
    <div class="content">
      <%-- Twitterボタン --%>
      <a class="twitter btn" href="http://twitter.com/share?url= &text=%0a↑観光地の観光地の感想を書いてね！%0a%20%23まいらいずおおいた" target="_blank" id="twitter"><div class="share">Twitterでシェア</div><img class="share" id="twitter_image" src="../image/twitter.jpg"></a>
    </div>
  </div>
  <%-- <a target="_blank" href="https://www.instagram.com/?hl=ja" id="instagram">Instagramでシェア</a>
  <a target="_blank" href="https://ja-jp.facebook.com/" id="facebook">facebookでシェア</a> --%>

  <%-- <script type="text/javascript" src="../js/CouponRegistration.js"></script> --%>

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

  // IPアドレスをjavascriptに変換
   let ipadress = '<%= ipadress%>';
  </script>

  <%-- 観光地の体裁を整えるjavascriptファイルを読み込み --%>
  <script type="text/javascript" src="../js/sightseeing_detail.js"></script>
  <%-- SNSでシェアした際のJavascriptファイルを読み込み --%>
  <script type="text/javascript" src="../js/Couponpresent.js"></script>

</div>

<%@include file="../html/gamenhuta.html" %>

<%@include file="../html/footer.html" %>
