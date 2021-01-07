<%@page contentType="text/html; charset=Windows-31J" pageEncoding="UTF-8"
  import="java.util.*,javax.mail.*,javax.mail.internet.*"%>
  <%! static final String SMTP_HOST = "127.0.0.1"; %>
<html>
<head>
<title>電子メール送信</title>
</head>
<body>
<%
Properties prop = new Properties();
prop.put("mail.smtp.host", SMTP_HOST);  

prop.put("mail.host", SMTP_HOST);
Session sess = Session.getInstance(prop);
MimeMessage msg = new MimeMessage(sess);
msg.setRecipients(Message.RecipientType.TO,"liverpool10coutino@gmail.com");
msg.setFrom(new InternetAddress("r4a1sotsuken@gmail.com","punisuke","ISO-2022-JP"));
msg.setSubject("JavaMail test","ISO-2022-JP");
msg.setText("Hello World!","ISO-2022-JP");
Transport.send(msg);
%>
メール送信に成功しました。
</body>
</html>
