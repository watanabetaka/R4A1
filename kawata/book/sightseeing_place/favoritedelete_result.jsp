<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%-- お気に入りから観光地を削除した後の画面 --%>

<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<%-- 原田 --%>
<%-- ヘッダー --%>
<header>
  <%-- 末松が作成した、お気に入り一覧画面へ戻るボタン --%>
  <div id="back">
    <form action="">
      <input type="submit" value="＜">
    </form>
  </div>

  <%-- タイトルの表示 --%>
  <div id="favorite_title">お気に入り</div>
</header>

<%-- サーブレットより、 message の値を取得 --%>
<% String message = String.valueOf(request.getAttribute("message")); %>

<%-- 削除に成功したかのメッセージを表示 --%>
<%= message %>

<%-- お気に入り一覧へ戻るボタン --%>
<form action="">
  <input type = "submit" value="お気に入り一覧へ戻る">
</form>

<%@include file="../gamenhuta.html" %>

<%@include file="../footer.html" %>
