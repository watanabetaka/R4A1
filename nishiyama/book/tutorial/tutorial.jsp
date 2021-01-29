<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../ipadress/ipadress.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>チュートリアル</title>
    <link rel="stylesheet" href="../css/fade.css">
    <link rel="stylesheet" href="../css/tutorial.css">
  </head>
  <body>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="../js/tutorial.js"></script>

  <div class=tutorial>
  <img src="../image/41.png" id="tutorial_img">
  </div>
  <div id="tutorial_txt"></div>

<div onclick="countdown();" id ="back_button">＜</div>
<div onclick="countup();" id ="move_button">＞</div>

<%@include file="../html/footer.html" %>
