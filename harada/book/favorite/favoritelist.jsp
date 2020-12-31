<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<%@page import="bean.Favorite, java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<header>
  <%-- 左上のソートバーのボタン --%>
  <script type="text/javascript" src="../js/hamburger.js"></script>
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
      <form action="Favoritesort.action">
        <div id="actions">
          <%-- 検索ボタンを押したらjavascriptファイルを呼び出す処理 --%>
          <input type="submit" id="sendtojava" value="検索" onclick=send();>
        </div>
      </form>

     </div>
    </div>
    <div id="favorite_title">お気に入り一覧</div>
</header>

  <% List<Favorite> list =(List<Favorite>)request.getAttribute("list"); %>

<table>
<br>
<tr>

<c:if test="${empty list}">
  <p>まだ観光地を登録していません!</p>
</c:if>

<% for(Favorite f: list){ %>

<form action="Detail.action">
  <input type="hidden" name="sightseeing_id" value="<%= f.getSightseeing_Id() %>">
    <button type="submit">
      <img src="../image/<%= f.getPicture_Path() %>"/><br>
　　   <c:out value="<%= f.getSightseeing_Name() %>"/><br>
    </button>
</form>

<% } %>

</tr>
</table>


<%@include file="../html/gamenhuta.html" %>

<%@include file="../html/footer.html" %>
