<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../jsp/header.jsp" %>
<%@page import="bean.CouponBean, java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<header>クーポン</header>
<h5>使用可能クーポン</h5>

<% List<CouponBean> list =(List<CouponBean>)request.getAttribute("list"); %>

<div class="coupon">
  <c:forEach var="list" items="${list}">
  <img src="image/${list.picture_path}"/><!--データベースからの画像挿入-->
  <div class="kanname"><!--データベースから情報取得、名前、値段、終了時間-->
    <p class="name"><c:out value="${list.sightseeing_name}"/></p>
    <p class="name"><c:out value="${list.coupon_name}"/></p>
    <p class="name"><c:out value="${list.get_coupon_etime}"/></p><!--例時間-->
  </div>
  <input type="button" class="btn open" value="発行" style="width: 20%; padding: 5%";> <!--発行ボタン-->
  <br clear="all"> <!--floatの解除-->
  <p class="kasen">&nbsp;</p> <!--下線-->
  </c:forEach>
</div>

<%@include file="../jsp/modal.jsp" %>
<%@include file="../jsp/footer.jsp" %>
