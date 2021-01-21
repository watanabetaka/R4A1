<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/favoritelist_header.html" %>
<%@page import="bean.Favorite, java.util.List , java.util.List,bean.City,bean.Genre" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../ipadress/ipadress.jsp" %>

<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<%-- サーブレットより、listを取得 --%>
<% List<Favorite> list =(List<Favorite>)request.getAttribute("list"); %>
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

            <%-- <div class="switch"> --%>
            <p>古い順に並び替え</p>
            <%-- <label class="switch__label"> --%>
            <form name="ascsort_form">
              <input type="checkbox" name="asc_name" id="asc_sort">
            </form>

              <%-- フォームの検索ボタンを押したらSortAction.javaをフォルダ内から探索して遷移する --%>
            <form action="Favoritesort.action">
              <div id="actions">
                <%-- 検索ボタンを押したらjavascriptファイルを呼び出す処理 --%>
                <input type="submit" id="sendtojava" value="検索" onclick=send();>
                </div>
            </form>


            </div>
          </div>
          <div id="favorite_title">お気に入り一覧</div>
          <div id="delete_button"><button type="button" name="delete_button" class="update_button" id="not_delete"><font size=5>削除</font></button></div>
</header>

<script>
  let dummy_sightseeing_id= [<%
    for(Favorite f: list){
      out.print("\""+f.getSightseeing_Id()+"\",");
    }
    %>];

  // array型に変換する
  let array_sightseeing_id=Array.from(dummy_sightseeing_id);

 // IPアドレスをjavascriptに変換
 let ipadress = '<%= ipadress%>';
</script>

<div id ="favoli">

  <c:if test="${empty list}">
    <p>まだ観光地を登録していません!</p>
  </c:if>

  <% for(Favorite f: list){ %>
    <div class ="favocon" id="<%=f.getSightseeing_Id()%>">

      <form action="Detail.action">
        <input type="hidden" name="sightseeing_id" value="<%= f.getSightseeing_Id() %>">

          <button type="submit" class="favoimg">
            <img class="imagelist" src="<%= f.getPicture_Path() %>"><br>
            <c:out value="<%= f.getSightseeing_Name() %>"/>
          </button>
        </form>

      </div>

  <% } %>

</div>

<script type="text/javascript" src="../js/favoritelist.js"></script>

<%@include file="../html/gamenhuta.html" %>

<%@include file="../html/footer.html" %>
