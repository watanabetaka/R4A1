<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/cpoperation_header.html" %>

<!-- ヘッダー部分 -->
<header>
  <div id="back">
    <a href="http://localhost:8080/book/cpoperation/cpoperation.jsp" id ="back_button">＜</a>
  </div>
<div id="mypage_title">
企業情報入力　　
</div>
</header>

<div class=fade>

<div class=cpinfo>
<p>企業情報の登録には審査が必要となります。<br>
  企業情報入力後に送信ボタンを押して<br>ください。<br>
  ＊は必須入力項目です。</p>

<form name="Form1" method="POST" enctype="multipart/form-data" action="Cpinfo.action" onsubmit="return formCheck()">

<br>
<div class=cpinfo_form>
<p id="cpname-null" style="display: none; color: red;"> 企業名を入力して下さい</p>
<div class=cpinfo_column>企業名*</div>
<input type="cpname" id = "cpname" name="cpname">
</div>

<div class=cpinfo_form>
<p id="sightname-null" style="display: none; color: red;"> 観光地名を入力して下さい</p>
<div class=cpinfo_column>観光地名*</div>
<input type="sightname" id="sightname" name="sightname">
</div>

<div class=cpinfo_form>
<p id="file-null" style="display: none; color: red;"> fileを選択してください</p>
<div class=cpinfo_column>写真</div>
<input type="file" name="file" id="file" accept="*"><br>
<canvas id="canvas" width="0" height="0"></canvas>
<br>
</div>

<div class=cpinfo_form>
<div class=cpinfo_column>市町村選択*</div>
<select class=city_select name="city_id">
  <option value="1" selected="selected">大分市</option>
  <option value=""="2">別府市</option>
  <option value="3">由布市</option>
  <option value="4">宇佐市</option>
  <option value="5">中津市</option>
  <option value="6">日田市</option>
  <option value="7">佐伯市</option>
  <option value="8">臼杵市</option>
  <option value="9">津久見市</option>
  <option value="10">竹田市</option>
  <option value="11">豊後高田市</option>
  <option value="12">豊後大野市</option>
  <option value="13">杵築市</option>
  <option value="14">国東市</option>
</select>
</div>

<div class=cpinfo_form>
<div class=cpinfo_column>ジャンル選択</div>
<select class=genre_select name="genre_id">
  <option value="1" selected="selected">ホテル・旅館</option>
  <option value="2">温泉</option>
  <option value="3">城跡</option>
  <option value="4">自然名所</option>
  <option value="5">カフェ・スイーツ</option>
  <option value="6">お酒・バー</option>
  <option value="7">レジャー</option>
</select>
</div>

<div class=cpinfo_form>
<p id="postal_code-null" style="display: none; color: red;"> 郵便番号を入力してください</p>
<p id="postal_code-wrong" style="display: none; color: red;"> 数字で入力してください</p>
<div class=cpinfo_column>郵便番号*</div>
<div class=attention>注意：ハイフンは使用せず、７桁の半角数字で入力すること。</div>
<input type="postal_code" name="postal_code" id="postal_code"maxlength="7"  placeholder="8900033">
</div>

<div class=cpinfo_form>
<p id="address-null" style="display: none; color: red;"> 住所を入力してください</p>
<div class=cpinfo_column>住所*</div>
<textarea name="address" id="address"rows="5" cols="50"></textarea>
</div>

<div class=cpinfo_form>
<p id="tel-null" style="display: none; color: red;"> 電話番号を入力してください</p>
<p id="tel-wrong" style="display: none; color: red;"> 電話番号を正しく入力してください</p>
<div class=cpinfo_column>電話番号*</div>
  <p>以下の例どちらかで入力してください。<br>
  例1:080-0000-0000<br>
  例2:08000000000<br></p>
<input type="tel" name="tel" id="tel" maxlength="14" placeholder="00-0000-0000">
  </div>

<div class=cpinfo_form>
<p id="business_hour-null" style="display: none; color: red;"> 営業時間を入力してください</p>
<div class=cpinfo_column>営業時間</div>
<p>入力例<br>
  ・＜平日＞11:00-20:00<br>
  ・＜土日祝＞10:00-22:00
</p>
<textarea name="business_hour" id="business_hour" rows="5" cols="50"></textarea>
</div>

<div class=cpinfo_form>
<p id="station-null" style="display: none; color: red;"> 駅を入力してください</p>
<div class=cpinfo_column>最寄り駅*</div>
<p>入力例<br>
  ・由布院駅より徒歩19分<br>
  ・別府駅より徒歩40分<br>
   （複数駅入力可能）<br>
             *複数駅入力する場合は・で区切ってください。</p>
<textarea name="station" id="station" rows="10" cols="50"></textarea>
</div>

<div class=cpinfo_form>
<div class=cpinfo_column>企業分類選択*</div>
<p><中小企業の基準><br>
  資本金の額又は出資の総額が5千万円以下の<br>会社<br>又は常時使用する従業員の数が100人以下の<br>会社及び個人</p>
<select class=rank_select name="rank">
  <option value="中小企業">中小企業</option>
  <option value="大企業">大企業</option>
</select>
</div>

<div class=cpinfo_form>
<div class=cpinfo_column>予約URL</div>
<div class=bookurl_txt>例：https://www.jalan.net/kankou/spt_44364ab2030004879/</div>
<input type="bookurl" id="bookurl" name="bookurl">
</div>

<div class=cpinfo_submit>
<input type="submit" name = "send" value="送信"  />
</div>

</form>

</div>

</div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/imageresize.js"></script>
<script src="../js/select_box.js"></script>
<script src="../js/send.js"></script>
<%@include file="../html/footer.html" %>
