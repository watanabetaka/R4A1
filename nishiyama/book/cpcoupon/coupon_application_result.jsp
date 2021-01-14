<%@page contentType="text/html; charset=UTF-8" %>
<%-- <%@include file="../html/header.html" %> --%>
<%@page import="bean.Application_Coupon, java.util.List" %>

<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<%-- 原田 --%>
<% int line = ((Integer)request.getAttribute("line")).intValue(); %>

<div id="application_view">
  <%-- 送信ができたか表示する --%>
</div>

<script>
  // JAVA を javascript に変換
  let line = <%= line %>

  // 正常にデータベースに登録できたかの条件文
  if(line > 0){
    // 正常にデータベースに登録できた際のメッセージ
    $('#application_view').append('<div id="application_result">クーポン情報を送信しました<br>審査結果はメールでお知らせ致します。</div>');
  }else{
    // 正常にデータベースに登録できなかった際のメッセージ
    $('#application_view').append('<div id="application_result">クーポン情報が送信できませんでした。<br>管理者にお問合せください。</div>');
  }
  // OKをクリックしたら、企業画面に戻る
  $('#application_view').append('<form action=""><input type="submit" value="OK"></form>');

</script>

<%@include file="../html/footer.html" %>
