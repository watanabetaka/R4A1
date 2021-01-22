<%@page contentType="text/html; charset=UTF-8" %>
<%-- <%@include file="../html/header.html" %> --%>
<%@page import="bean.Sightseeing_Place, java.util.List" %>
<%@include file="../html/cpoperation_header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>

<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<header>
  <div id="back">
    <a href="http://<%= ipadress%>:8080/book/cpoperation/cpoperation.jsp" id ="back_button">＜</a>
  </div>
<div id="mypage_title">
クーポン申請　　
</div>
</header>

<div class=fade>

<div class=caution>
  クーポン申請は、1ユーザにつき1つまで<br>
  です。<br>
  ご注意ください。
</div>

<%-- 観光地名の選択とクーポン情報の入力をサーブレットに転送する処理  --%>
<%-- ユーザーがクーポン申請できる観光地をプルダウンにて表示 --%>
<div class=application_check>

  <%-- ユーザーがクーポン申請中の場合のメッセージを取得 --%>
  <% String message = String.valueOf(request.getAttribute("message")); %>

  <%-- JAVAの値を javascript に変換 --%>
  <script>
    let message="<%= message %>";
  </script>

  <%-- ユーザーがクーポン申請できる観光地を取得 --%>
  <% List<Sightseeing_Place> list =(List<Sightseeing_Place>)request.getAttribute("list"); %>

  <%-- JAVAの値を javascript に変換 --%>
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
  </script>

  <div id="view"></div>

</div>

</div>

<script type="text/javascript" src="../js/application_check.js"></script>


<%@include file="../html/footer.html" %>
