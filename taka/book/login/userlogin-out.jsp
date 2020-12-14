<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%-- <% out.println(getAttribute("user"));%> --%>
<%
out.println(request.getCookies());
%>


<%@include file="../footer.html" %>
