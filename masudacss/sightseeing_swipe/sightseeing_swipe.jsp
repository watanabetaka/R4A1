<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

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
    <div id="sightseeing_place">うみたまご</div>
    <%-- 市名の表示 --%>
    <div id="city_name">別府市</div>
</header>
<%-- 観光地の写真を表示 --%>
<div id="picture"><img src="../image/seaeggs.jpg"></div>

<%@include file="../gamenhuta.html" %>

<%@include file="../footer.html" %>
