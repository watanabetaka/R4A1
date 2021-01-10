<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>
<%@page import="bean.Coupon, java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- jqueryをインポート --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<header>クーポン</header>
<h5>使用可能クーポン</h5>

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

</script>
<div class="coupon" id="coupon">

  <%-- 原田 --%>
  <%-- この位置の HTML は、JSファイルにて制御しているため、
  この位置の HTML を書き換えたい場合は、JSファイルの
  53行目から56行目、
  112行目、197行目、201行目、203行目、
  206行目から209行目
  を参照してください(append()を参照してください)
  ※急いで書いたので、インデント等が、やや見づらいかもしれません --%>


  <%-- さかもとエリア（念のため、残しておきます） --%>
  <%-- <c:forEach var="list" items="${list}">
  <img src="../image/${list.picture_path}"/><!--データベースからの画像挿入-->
  <div class="kanname"><!--データベースから情報取得、名前、値段、終了時間-->
    <p class="name"><c:out value="${list.sightseeing_name}"/></p>
    <p class="name"><c:out value="${list.coupon_name}"/></p>
    <p class="name"><c:out value="${list.get_coupon_etime}"/></p><!--例時間-->
  </div>
  <input type="button" id="${list.get_coupon_id}" class="btn open" value="発行" style="width: 20%; padding: 5%";> <!--発行ボタン-->
  <br clear="all"> <!--floatの解除-->
  <p class="kasen">&nbsp;</p> <!--下線-->
  </c:forEach> --%>
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

<%@include file="../html/gamenhuta.html" %>
<%@include file="../html/footer.html" %>
