<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../html/header.html" %>

<%-- <% out.println(getAttribute("user"));%> --%>
<%
out.println(session.getAttribute("user"));
%>


<%@include file="../html/footer.html" %>
