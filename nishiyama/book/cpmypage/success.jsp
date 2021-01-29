<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/cpoperation_header.html" %>
<%@include file="../ipadress/ipadress.jsp" %>

<script>
document.getElementsByTagName("title")[0].innerHTML="メールアドレス変更";
</script>

<div class=fade>

<div class=success>
  <div class=success_txt>成功しました！</div>
<br><br><br>
<input type="button" onclick="location.href='http://<%= ipadress%>:8080/book/cpoperation/cpoperation.jsp'" value="OK">
</div>

</div>

<%@include file="../html/footer.html" %>
