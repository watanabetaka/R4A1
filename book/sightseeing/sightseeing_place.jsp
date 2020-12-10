<%-- 観光地表示画面 --%>

<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<header>
  <div id="nav-drawer">
    <input id="nav-input" type="checkbox" class="nav-unshown">
    <label id="nav-open" for="nav-input"><span></span></label>
    <label id="nav-close" for="nav-input" class="nav-unshown"></label>
    <div id="nav-content">

       <div id="area-drawer">
          <input id="area-input" type="checkbox" class="nav-unshown">
          <label id="area-open" for="area-input"></label>
          <label class="nav-unshown" id="nav-close" for="area-input"></label>
          <div id="nav-content">
          </div>
        </div>

       <div id="genre-drawer">
          <input id="genre-input" type="checkbox" class="nav-unshown">
          <label id="genre-open" for="genre-input"></label>
          <label class="nav-unshown" id="nav-close" for="genre-input"></label>
          <div id="nav-content">
          </div>
        </div>

     </div>
  </div>
  <div id="sightseeing_place">うみたまご</div>
</header>
<%-- 左上のソートバーのボタン --%>
<%-- 観光地の表示 --%>
<div id="picture"><img src="../image/seaeggs.jpg"></div>
<%-- 観光地の写真を表示 --%>

<%-- 以下、観光地詳細画面（渡邊） --%>

<%@include file="../footer.html" %>
