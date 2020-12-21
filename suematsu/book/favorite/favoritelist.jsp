<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@page import="bean.Favoritebean, java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>お気に入り一覧</head>

<body>

<table>
<br>
<tr>

<% List<Favoritebean> list =(List<Favoritebean>)request.getAttribute("list"); %>
<% if(list.isEmpty()){
    out.print("まだ観光地をお気に入り登録していませんわ！");
}%>

<c:forEach var="list" items="${list}">
　  <a href="sample2.html"><img src="image/${list.picture_path}"/></a><br>
　　<c:out value="${list.sightseeing_name}"/><br>
</c:forEach>

</tr>
</table>


</body>
</html>
