<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@page import="bean.Sightseeing_Place, java.util.List" %>

<%-- 児玉くん --%>
<%-- 左上のソートバーのボタン --%>
<header>
    <div id="nav-drawer">
      <input id="nav-input" type="checkbox" class="nav-unshown">
      <label id="nav-open" for="nav-input"><span></span></label>
      <label id="nav-close" for="nav-input" class="nav-unshown"></label>
      <div id="nav-content">

         <div id="area-drawer">
            <input id="area-input" type="checkbox" class="nav-unshown">
            <label id="area-open" for="area-input"><span></span></label>
            <label id="area-close" for="area-input" class="nav-unshown"></label>
            <div id="area-content">
              <p>エリア選択</p>
              <form>
               <div>
                <input type="checkbox" id="oitashi" name="" value="">
                <label for="oitashi">大分市</label>
               </div>
               <div>
                <input type="checkbox" id="beppushi" name="" value="">
                <label for="beppushi">別府市</label>
               </div>
               <div>
                <input type="checkbox" id="yufushi" name="" value="">
                <label for="yufushi">由布市</label>
               </div>
               <div>
                <button type="submit">検索</button>
               </div>
             </form>
            </div>
          </div>

         <div id="genre-drawer">
            <input id="genre-input" type="checkbox" class="nav-unshown">
            <label id="genre-open" for="genre-input"><span></span></label>
            <label id="genre-close" for="genre-input" class="nav-unshown" ></label>
            <div id="genre-content">
              <p>ジャンル選択</p>
              <form>
               <div>
                <input type="checkbox" id="hotel" name="" value="">
                <label for="hotel">ホテル・旅館</label>
               </div>
               <div>
                <input type="checkbox" id="onsen" name="" value="">
                <label for="onsen">温泉</label>
               </div>
               <div>
                <input type="checkbox" id="zyouseki" name="" value="">
                <label for="zyouseki">城跡</label>
               </div>
               <div>
                <button type="submit">検索</button>
               </div>
             </form>
            </div>
          </div>

        <div>
          <p>位置情報</p>
          <div class="toggle-switch">
    　　　　　  <input id="toggle" class="toggle-input" type='checkbox' />
    　　　　　  <label for="toggle" class="toggle-label"/>
    　　　　  　<span></span>
    　　　　　</div>
        </div>

        <div>
         <button type="submit">検索</button>
        </div>

       </div>
    </div>
     <%-- 原田くん --%>
     <%-- 観光地の表示 --%>

     <%-- サーブレットより、listを取得 --%>
     <% List<Sightseeing_Place> list=(List<Sightseeing_Place>)request.getAttribute("list"); %>

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
     <%-- スワイプ機能関連のjavascriptファイルを読み込み --%>
     <%-- <script type="text/javascript" src="../js/swipe_drag.js"></script> --%>

</header>

<%-- 観光地の写真を表示 --%>
<div id="picture">
  <img src="<% for(Sightseeing_Place s: list){ out.print(s.getPicture_Path()); } %>">
</div>

<%-- 以下、観光地詳細画面（渡邊） --%>

<%-- 住所の表示 --%>
<%-- 郵便番号の表示 --%>
<div id="postal_code">
  <%
  for(Sightseeing_Place s: list){
    out.print(s.getPostal_Code());
  }
  %>
</div>

<div id="street_adress">
  <%
  for(Sightseeing_Place s: list){
    out.print(s.getStreet_Adress());
  }
  %>
</div>

<div id="phone_number">
  <%
  for(Sightseeing_Place s: list){
    out.print(s.getPhone_Number());
  }
  %>
</div>

<div id="business_hour">
  <%
  for(Sightseeing_Place s: list){
    out.print(s.getBusiness_Hour());
  }
  %>
</div>

<div id="nearest_station_time">
  <%
  for(Sightseeing_Place s: list){
    out.print(s.getNearest_Station());
  }
  %>
</div>

<%-- 観光地詳細画面（末松） --%>

<%-- 入力された観光地名でGoogle検索 --%>
<a href="https://www.google.com/search?q=<% for(Sightseeing_Place s: list){ out.print(s.getSightseeing_Name()); } %>" id="google">Googleで検索</a>

<div class="yajirushi"><img src="../image/yajirushi.jpg"></div>

<%-- 予約サイトURLのURL挿入 --%>
<a href="<% for(Sightseeing_Place s: list){ out.print(s.getUrl()); } %>" id="jaran">じゃらんで表示</a>

<div class="yajirushi"><img src="../image/yajirushi.jpg"></div>

<%@include file="../gamenhuta.html" %>

<%@include file="../footer.html" %>
