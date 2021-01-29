<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/cpoperation_header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>


<header>
<div id="mypage_title">
 　　
</div>
</header>

<script>
document.getElementsByTagName("title")[0].innerHTML="企業情報入力";
</script>

<div class=fade>

<div class=cpinfo>
<div class=cpexamination>現在企業情報が適切なものか審査中です。<br>
結果はメールでお伝えします。<br>
okボタンを押して企業トップ画面に<br>お戻りください。
</div>

<div class=cpinfo_button><input type="button" onclick="location.href='http://<%= ipadress%>:8080/book/cpoperation/cpoperation.jsp'" value="ok"></p>
</div>
</div>

<%@include file="../html/footer.html" %>
