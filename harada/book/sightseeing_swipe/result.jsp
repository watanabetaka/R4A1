<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%--
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="s" items="${list}">
  ${s.sightseeing_name}:${s.city_id}:${s.picture_path}<br>
</c:forEach> --%>
<%@page import="bean.SightSeeing, java.util.List" %>

<% List<SightSeeing> list=(List<SightSeeing>)request.getAttribute("list"); %>


<%-- <% for(SightSeeing s : list){ %>
  <%= s.getSightSeeing_Name() %>　:  <%= s.getCity_Id() %> : <img src="<%= s.getPicture_Path() %>"></img> <br>
<% } %> --%>

<%-- javaの配列をjavascriptの配列に入れる --%>
<script>
let array_sightseeing_name = [<%
                              for(SightSeeing s: list){
                                out.print("\""+s.getSightSeeing_Name()+"\",");
                              }
                              %>];
let array_picture_path = [<%
                          for(SightSeeing s: list){
                            out.print("\""+s.getPicture_Path()+"\",");
                          }
                          %>];
</script>

<script type="text/javascript" src="../js/swipe.js"></script>

<%@include file="../gamenhuta.html" %>

<%@include file="../footer.html" %>
