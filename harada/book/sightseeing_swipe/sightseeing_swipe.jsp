<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/sightseeing_swipe_header.html" %>
<%-- javaで利用するクラスをインポート --%>
<%@page import="bean.Sightseeing_Place, java.util.List,bean.City,bean.Genre" %>
<%@include file="../ipadress/ipadress.jsp" %>

<%-- jqueryで利用するAPIをインポート --%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/latest/plugins/CSSPlugin.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/latest/easing/EasePack.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/latest/TweenLite.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/latest/TweenMax.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/1.15.0/utils/Draggable.min.js"></script>

<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<%-- サーブレットより、listを取得 --%>
<% List<Sightseeing_Place> list=(List<Sightseeing_Place>)request.getAttribute("list"); %>
<% List<City> list1=(List<City>)request.getAttribute("list1"); %>
<% List<Genre> list2=(List<Genre>)request.getAttribute("list2"); %>


<%-- 児玉くん --%>
<%-- 左上のソートバーのボタン --%>
<script type="text/javascript" src="../js/hamburger.js"></script>
<header>
  <div id="nav-drawer">
      <input id="nav-input" type="checkbox" class="nav-unshown">
      <label id="nav-open" for="nav-input"><span></span></label>
      <label id="nav-close" for="nav-input" class="nav-unshown"></label>
        <div id="nav-content">
          <div id="space"></div>
          <div id="areaselect-range">
            <p class="p_size">　　エリア選択　　　<label id="area-open" for="area-input"><span></span></label>
            </p>
              <div id="area-drawer">
                <input id="area-input" type="checkbox" class="nav-unshown">
                <label id="area-close" for="area-input" class="nav-unshown"></label>
                <div id="area-content">
                  <div id="areaselect-range2">
                  <p class="p_size">　エリア選択</p>
                  </div>
                  <form name=area_form>
                    <div id="area_list">
                   </div>
                    <script>
                     let array_city_id = [<%
                       for(City c: list1){
                         out.print("\""+c.getCity_Id()+"\",");
                       }
                       %>];
                     let array_city_name1 = [<%
                       for(City c: list1){
                         out.print("\""+c.getCity_Name()+"\",");
                       }
                       %>];
                       console.log(array_city_name1);

                       for(let id in array_city_id){
                         $('#area_list').append('<input type="checkbox" class="area" name="area_name"><label class="city_kind area1">' + array_city_name1[id] +'</label><br>');
                       }
                    </script>
                  </form>
                   <div class="button-position">
                    <input type="button" class="decision-buttom" value="決定" onclick="changeCheckbox('area-input');">
                   </div>
                </div>
              </div>

            </div>

            <div id="genreselect-range">
              <p class="p_size">　　ジャンル選択　　<label id="genre-open" for="genre-input"><span></span></label>
             </p>
             <div id="genre-drawer">
                <input id="genre-input" type="checkbox" class="nav-unshown">
                <label id="genre-close" for="genre-input" class="nav-unshown" ></label>
                <div id="genre-content">
                  <div id="genreselect-range2">
                  <p class="p_size">　ジャンル選択</p>
                  </div>
                  <form name="genre_form">
                    <div id="genre_list">
                   </div>
                    <script>
                     let array_genre_id = [<%
                       for(Genre g: list2){
                         out.print("\""+g.getGenre_Id()+"\",");
                       }
                       %>];
                     let array_genre_name = [<%
                       for(Genre g: list2){
                         out.print("\""+g.getGenre_Name()+"\",");
                       }
                       %>];
                       for(let id in array_genre_id){
                         $('#genre_list').append('<input type="checkbox" class="genre" name="genre_name"><label class="genre_kind genre1">' + array_genre_name[id] + '</label><br>');
                       }
                    </script>
                  </form>
                   <div class="button-position">
                    <input type="button" class="decision-buttom" value="決定" onclick="changeCheckbox('genre-input');" />
                   </div>
                </div>
             </div>
            </div>



      <%-- <div class="switch">
        <p>位置情報</p>
          <label class="switch__label">
            <form name="location_form">
    　　　　    <input type="checkbox" id="location" name="location_name" class="switch__input"/>
            </form>
  　　　　    <span class="switch__content"></span>
  　　　　    <span class="switch__circle"></span>
  　　　　 </label>
       </div> --%>


      <form action="http://<%= ipadress%>:8080/book/sightseeing_swipe/Sort.action">
        <div id="actions">
          <input type="submit" id="sendtojava" value="検索" onclick=send();>
        </div>
      </form>

     </div>
    </div>
     <%-- 原田くん --%>
     <%-- 観光地の表示 --%>

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

    // IPアドレスをjavascriptに変換
     let ipadress = '<%= ipadress%>';
     </script>

     <%-- スワイプ機能関連のjavascriptファイルを読み込み --%>
     <script type="text/javascript" src="../js/swipe_drag.js"></script>

     <%-- 観光地名の表示 --%>
     <div id="sightseeing_place_container"><div id="sightseeing_place"></div></div>
     <%-- 市名の表示 --%>
      <div id="city_name"></div>

</header>

<%-- 観光地の写真を表示 --%>
<div id="picture"></div>

<%@include file="../html/gamenhuta.html" %>

<%@include file="../html/footer.html" %>
