<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%--
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="s" items="${list}">
  ${s.sightseeing_name}:${s.city_id}:${s.picture_path}<br>
</c:forEach> --%>
<%-- <%@page import="bean.SightSeeing, java.util.List" %> --%>

<%-- <% List<SightSeeing> list=(List<SightSeeing>)request.getAttribute("list"); %> --%>


<%-- <% for(SightSeeing s : list){ %>
  <%= s.getSightSeeing_Name() %>　:  <%= s.getCity_Id() %> : <img src="<%= s.getPicture_Path() %>"></img> <br>
<% } %> --%>

<%-- javaの配列をjavascriptの配列に入れる --%>
<%-- <script>

</script> --%>
<%-- <%@ page import = "javax.servlet.http.Cookie"%>
<%@ page import = "javax.servlet.http.*"%>

<%

//ログインか新規会員登録からメニュー画面へ遷移したばあい
if(session.getAttribute("user") != null){
        String session_id = (String)session.getAttribute("user");
        int user_id = Integer.parseInt(session_id);
        out.println(user_id);  //ここにセッションのユーザIDが入ってます
   //ログインか新規会員登録以外からメニュー画面へ遷移した場合
}else{
  Cookie[] cookies=request.getCookies();
  out.print(cookies);


  // if (cookies!=null) {
     int user_id;
     for (Cookie cookie : cookies) {
        String name=cookie.getName();
        // if(name.equals("user")){
          String value=cookie.getValue();
          user_id = Integer.parseInt(value);//ここにセッションのユーザIDが入ってます
          out.println(user_id);
        // }
      }
   // } else {
   //   out.println("クッキーは存在しません");
   // }
}

%> --%>

<%-- <script type="text/javascript" src="../js/swipe.js"></script> --%>

<%-- <%@include file="../gamenhuta.html" %> --%>

<%@include file="../footer.html" %>
