<%@page encording ="UTF-8" %><!--jspにjspをincludeし、左のコードを書かなければ文字化けする-->
<!--<!DOCTYPE html>
 <html>
  <head>
    <title>humburger</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="hamburger.css">
  　<script src="hamburger.js"></script>
  </head>
  <body>-->
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
                 <input type="checkbox" class="area" name="" value="">
                 <label for="oitashi">大分市</label>
                </div>
                <div>
                 <input type="checkbox" class="area" name="" value="">
                 <label for="beppushi">別府市</label>
                </div>
                <div>
                 <input type="checkbox" class="area" name="" value="">
                 <label for="yufushi">由布市</label>
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
                 <label for="hotel">ホテル・旅館</label>
                </div>
                <div>
                 <input type="checkbox" class="genre" name="genre_name" value="">
                 <label for="onsen">温泉</label>
                </div>
                <div>
                 <input type="checkbox" class="genre" name="genre_name" value="">
                 <label for="zyouseki">城跡</label>
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

     <form>
       <div>
        <input type="buttom" id="sendtojava" value="検索" onclick="send();"/>
       </div>
     </form>

    </div>
   </div>
  </header>
 <!--</body>
    </html>-->
