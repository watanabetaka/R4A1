<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>

<%-- お気に入りから観光地を削除した後の画面 --%>

<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<%-- 原田 --%>
<%-- ヘッダー --%>
<header>
  <%-- 末松が作成した、お気に入り一覧画面へ戻るボタン --%>
  <div id="back">
    <a href="favoritelist">＜</a>
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
<a href="http://<%@include file="../ipadress/ipadress.jsp" %>:8080/book/favorite/favoritelist">お気に入り一覧へ戻る</a>

<%@include file="../html/gamenhuta.html" %>

<%@include file="../html/footer.html" %>
