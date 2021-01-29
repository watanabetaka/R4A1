<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/coupon_header.html" %>
<%@page import="bean.Coupon, java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../ipadress/ipadress.jsp" %>

<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<header><div class="coupon_title">クーポン</div></header>
<h5><div id="coupon_header">使用可能クーポン</h5></div>

<div class="fade">
  <% List<Coupon> list =(List<Coupon>)request.getAttribute("list");%>

  <%-- javaの配列をjavascriptの配列に入れる --%>

  <script>
    let array_picture_path = [<%
      for(Coupon s: list){
        out.print("\""+s.getPicture_path()+"\",");
      }
      %>];

    let array_sightseeing_name = [<%
      for(Coupon s: list){
        out.print("\""+s.getSightseeing_name()+"\",");
      }
      %>];

    let array_coupon_name = [<%
      for(Coupon s: list){
        out.print("\""+s.getCoupon_name()+"\",");
      }
      %>];

    let array_get_coupon_etime = [<%
      for(Coupon s: list){
        out.print("\""+s.getGet_coupon_etime()+"\",");
      }
      %>];

    let array_get_coupon_id = [<%
      for(Coupon s: list){
        out.print("\""+s.getGet_coupon_id()+"\",");
      }
        %>];

    let array_coupon_id = [<%
      for(Coupon s: list){
        out.print("\""+s.getCoupon_id()+"\",");
      }
        %>];


    // IPアドレスをjavascriptに変換
     let ipadress = '<%= ipadress%>';

  </script>
  <div class="coupon" id="coupon">

  </div>

  <div id="mask" class="hidden"></div> <!--モーダルウィンドウ背景-->
  <section id="modal" class="hidden">　<!--モーダルウィンドウ本体-->
  <p class="name">発行するとクーポンは<br>30分で消えてしまいます。<br>発行しますか？</p>
  <div id="close">
    <input type="button" id="YES" class="YES modalbtn" value="YES" style="width: 40%; padding: 10%";>
    <input type="button" class="NO modalbtn" value="NO" style="width: 40%; padding: 10%";>
  </div>
  </section>
  <script src="../js/coupon.js"></script>
</div>

<%@include file="../html/gamenhuta.html" %>
<%@include file="../html/footer.html" %>
