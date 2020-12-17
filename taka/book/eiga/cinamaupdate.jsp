<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<h1 class = "title>映画予約ページ</h1>

<p>映画を選択してください。</p>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import ="eiga.Cinamadata" %>
<%@ page import= "bean.Cinama" %>
<% Cinamadata d = new Cinamadata(); 
  List<Cinama> list = d.data(); %>


<form action= "cinamaupdate" method="post">
<% for(Cinama c : list){ 
	if(c.getMoviecount()==0){ 
		continue;
	 } %>
<input type = "radio" name = "payment" value="<%= c.getMovieid() %>">
	<%out.println(c.getMoviename());%>
<br>
<img src= "<%out.println(c.getMovieimage());%>" alt="[写真]" width="1200" height="1000" >
<br>
	<% } %>
<
<input type = "submit"  value="予約">
</form>
<%@include file="../footer.html" %>
