<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<%-- javaで利用するクラスをインポート --%>
<%@page import="bean.Sightseeing_Place, java.util.List" %>

<%-- jqueryで利用するAPIをインポート --%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/latest/plugins/CSSPlugin.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/latest/easing/EasePack.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/latest/TweenLite.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/latest/TweenMax.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/1.15.0/utils/Draggable.min.js"></script>

<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<%-- 児玉くん --%>
<%-- 左上のソートバーのボタン --%>
<script type="text/javascript" src="../js/hamburger.js"></script>
<header>
  <div id="nav-drawer">
      <input id="nav-input" type="checkbox" class="nav-unshown">
      <label id="nav-open" for="nav-input"><span></span></label>
      <label id="nav-close" for="nav-input" class="nav-unshown"></label>
        <div id="nav-content">
          <p>エリア選択</p>
            <div id="area-drawer">
              <input id="area-input" type="checkbox" class="nav-unshown">
              <label id="area-open" for="area-input"><span></span></label>
              <label id="area-close" for="area-input" class="nav-unshown"></label>
              <div id="area-content">
                <p>エリア選択</p>
                <form name=area_form>
                 <div>
                  <input type="checkbox" class="area" name="area_name" value="">
                  <label class="city_kind">大分市</label>
                 </div>
                 <div>
                  <input type="checkbox" class="area" name="area_name" value="">
                  <label class="city_kind">竹田市</label>
                 </div>
                 <div>
                  <input type="checkbox" class="area" name="area_name" value="">
                  <label class="city_kind">由布市</label>
                 </div>
                </form>
                 <div>
                  <input type="buttom" value="決定" onclick="changeCheckbox('area-input');" />
                 </div>
              </div>
            </div>

            <p>ジャンル選択</p>
           <div id="genre-drawer">
              <input id="genre-input" type="checkbox" class="nav-unshown">
              <label id="genre-open" for="genre-input"><span></span></label>
              <label id="genre-close" for="genre-input" class="nav-unshown" ></label>
              <div id="genre-content">
                <p>ジャンル選択</p>
                <form name="genre_form">
                 <div>
                  <input type="checkbox" class="genre" name="genre_name" value="">
                  <label class="genre_kind">ホテル・旅館</label>
                 </div>
                 <div>
                  <input type="checkbox" class="genre" name="genre_name" value="">
                  <label class="genre_kind">レジャー</label>
                 </div>
                 <div>
                  <input type="checkbox" class="genre" name="genre_name" value="">
                  <label class="genre_kind">カフェ・スイーツ</label>
                 </div>
                </form>
                 <div>
                  <input type="buttom" value="決定" onclick="changeCheckbox('genre-input');" />
                 </div>
              </div>
           </div>


      <div class="switch">
        <p>位置情報</p>
          <label class="switch__label">
            <form name="location_form">
    　　　　    <input type="checkbox" id="location" name="location_name" class="switch__input"/>
            </form>
  　　　　    <span class="switch__content"></span>
  　　　　    <span class="switch__circle"></span>
  　　　　 </label>
       </div>

     <!--  <div class="toggle-switch">
         <input id="toggle" class="toggle-input" type='checkbox' />
         <label for="toggle" class="toggle-label"/>
       </div>   -->

      <%-- フォームの検索ボタンを押したらSortAction.javaをフォルダ内から探索して遷移する --%>
      <form action="Sort.action">
        <div id="actions">
          <%-- 検索ボタンを押したらjavascriptファイルを呼び出す処理 --%>
          <input type="submit" id="sendtojava" value="検索" onclick=send();>
        </div>
      </form>

     </div>
    </div>
     <%-- 原田くん --%>
     <%-- 観光地の表示 --%>

     <%-- サーブレットより、listを取得 --%>
     <% List<Sightseeing_Place> list=(List<Sightseeing_Place>)request.getAttribute("list"); %>

     <%-- javaの配列をjavascriptの配列に入れる --%>
     <script>
     let array_sightseeing_id = [<%
       for(Sightseeing_Place s: list){
         out.print("\""+s.getSightseeing_Id()+"\",");
       }
       %>];

     let array_sightseeing_name = [<%
       for(Sightseeing_Place s: list){
         out.print("\""+s.getSightseeing_Name()+"\",");
       }
       %>];

     let array_city_name = [<%
       for(Sightseeing_Place s: list){
         out.print("\""+s.getCity_Name()+"\",");
       }
       %>];

     let array_picture_path = [<%
       for(Sightseeing_Place s: list){
         out.print("\""+s.getPicture_Path()+"\",");
       }
       %>];
     </script>

     <%-- スワイプ機能関連のjavascriptファイルを読み込み --%>
     <script type="text/javascript" src="../js/swipe_drag.js"></script>

     <%-- 観光地名の表示 --%>
    <div id="sightseeing_place"></div>
    <%-- 市名の表示 --%>
    <div id="city_name"></div>

</header>

<%-- 観光地の写真を表示 --%>
<div id="picture"></div>

<%@include file="../html/gamenhuta.html" %>

<%@include file="../html/footer.html" %>
