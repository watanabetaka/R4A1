<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<%@page import="bean.Sightseeing_Place,bean.Get_Coupon,java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<% List<Get_Coupon> list =(List<Get_Coupon>)request.getAttribute("list");%>
<% out.println(list); %>
  <c:if test="${empty list}">
    <p>クーポンの取得に失敗しました</p>
  </c:if>

  <c:if test="${!empty list}">
    <% for(Get_Coupon c: list){ %>
    <br>レビュー投稿ありがとうございます！<br>
      【<c:out value="<%= c.getSightseeing_Name() %>"/>】で使える<br>
      【<c:out value="<%= c.getCoupon_Name() %>"/>】のクーポンをプレゼント！<br>
    <%}%>
  </c:if>

<a class="page-close" href="http://localhost:8080/book/favorite/favoritelist">お気に入り一覧へ戻る</a>

<%@include file="../html/gamenhuta.html" %>

<%@include file="../html/footer.html" %>
