<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<%@page import="bean.Coupon, java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<header>クーポン</header>
<h5>使用可能クーポン</h5>

<% List<Coupon> list =(List<Coupon>)request.getAttribute("list"); %>

<div class="coupon">
  <c:forEach var="list" items="${list}">
  <img src="../image/${list.picture_path}"/><!--データベースからの画像挿入-->
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

<div id="mask" class="hidden"></div> <!--モーダルウィンドウ背景-->
<section id="modal" class="hidden">　<!--モーダルウィンドウ本体-->
<p class="name">発行するとクーポンは<br>消えてしまいます。<br>発行しますか？</p>
<div id="close">
  <input type="button" class="YES modalbtn" value="YES" style="width: 40%; padding: 10%";>
  <input type="button" class="NO modalbtn" value="NO" style="width: 40%; padding: 10%";>
</div>
</section>
<script src="../js/coupon.js"></script>

<%@include file="../html/footer.html" %>
