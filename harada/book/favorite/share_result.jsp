<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/couponget.html" %>
<%@page import="bean.Sightseeing_Place,bean.Get_Coupon,java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../ipadress/ipadress.jsp" %>

<header>
  <div id="back">
    <a href="http://<%=ipadress%>:8080/book/favorite/favoritelist" id ="modoru">＜</a>
  </div>
  <div id="login_title">
    クーポン獲得
  </div>
</header>
<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<div class="fade">

  <% List<Get_Coupon> list =(List<Get_Coupon>)request.getAttribute("list");%>
    <c:if test="${empty list}">
      <p>クーポンの取得に失敗しました</p>
    </c:if>

    <c:if test="${!empty list}">
      <% for(Get_Coupon c: list){ %>
  <div id = Ktm>
      <div class = "KTm"> レビュー投稿ありがとうございます！<br>
        【<c:out value="<%= c.getSightseeing_Name() %>"/>】で使える<br>
        【<c:out value="<%= c.getCoupon_Name() %>"/>】のクーポンをプレゼント！</div><br>
      <%}%>
    </c:if>
  <div id="KtM">
  <a class="page-close" href="http://<%=ipadress%>:8080/book/favorite/favoritelist">お気に入り一覧へ戻る</a>
  </div>
  </div>
</div>
<%@include file="../html/gamenhuta.html" %>

<%@include file="../html/footer.html" %>
