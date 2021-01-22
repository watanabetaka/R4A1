<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/cpoperation_header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>


<header>
  <div id="mypage_title">
企業画面
  </div>
</header>

<div class=fade>
<div class=cpoperation>
<div class=cpoperation_list onclick="location.href='http://<%= ipadress%>:8080/book/cpoperation/Examingflag.action'">
企業情報入力　　　　　　　
<span class=cpoperation_list_arrow>＞</span>
</div>
<div class=cpoperation_list onclick="location.href='http://<%= ipadress%>:8080/book/cpmypage/mypage.jsp'">
メアド・パスワード変更　　
<span class=cpoperation_list_arrow>＞</span>
</div>
<div class=cpoperation_list onclick="location.href='http://<%= ipadress%>:8080/book/cpcoupon/Sightseeingsearch.action'">
クーポン申請　　　　　　　
<span class=cpoperation_list_arrow>＞</span>
</div>

<div class=cpmypage_logout>
<p><input type="button" id = logout onclick ="location.href='http://<%= ipadress%>:8080/book/login/Logout.action'"  value="ログアウト"></p>
</div>
</div>
</div>

<%@include file="../html/footer.html" %>
