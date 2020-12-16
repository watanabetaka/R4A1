<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<h1>学生氏名変更ページ</h1>
<form action="studentUpdate" method="post">
学籍番号<input type ="text" name="studentid">
氏名<input type ="text" name="name">
<input type ="submit" value="更新">
</form>

<%@include file="../footer.html" %>
