package newregist;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import tool.Action;
import javax.servlet.http.*;
import dao.RegistuserDAO;
import java.util.Random;

public class MailSendAction extends  Action{

      public String execute(
        HttpServletRequest request, HttpServletResponse response
      ) throws Exception {

        //ユーザーから入力されたメールアドレスをemail変数に格納する
        String email=request.getParameter("email");
        //新規登録用のdaoをインスタンス化する
        RegistuserDAO dao=new RegistuserDAO();
        //
    		boolean mailflag = dao.searchmail(email);

        if(!mailflag){
            HttpSession session1=request.getSession();
            // 暗証番号生成
            char[] chars = "abcdefghijklmnopqrstuvwxyzABSDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
            Random r = new Random(System.currentTimeMillis());
            char[] pin = new char[6];
            for (int i = 0;  i < 6;  i++) {
                pin[i] = chars[r.nextInt(chars.length)];
            }
            // セッションの時間指定
            session1.setMaxInactiveInterval(60*30);
            session1.setAttribute("email",email);
            session1.setAttribute("pin",String.valueOf(pin));

            Properties props = new Properties();
              // メール送信のプロパティ設定
            props.put("mail.smtp.host", "smtp.mail.yahoo.co.jp");
            props.put("mail.smtp.port", "587");//25番ポートブロックをかいくぐるため
            props.put("mail.smtp.auth", "true");
            props.put("mail.transport.protocol", "smtp");//送信のために必要なプロトコル
            props.put("mail.smtp.ssl.trust", "*");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.connectiontimeout", "10000");
            props.put("mail.smtp.timeout", "10000");

            // セッションを作成する
            Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected
                        PasswordAuthentication
                        getPasswordAuthentication() {
                        return new
                            PasswordAuthentication("liverpool35takayoshi", "chelsea10!");
                    }
                });

            // メールの送信先はYahooメール。送信元もYahooメール
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(
                "liverpool35takayoshi@yahoo.co.jp", "takaaa"));
            message.setReplyTo(new Address[]{//返信の際にどこへ飛ばすか説明
                new InternetAddress("liverpool35takayoshi@yahoo.co.jp")});
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));
            message.setSubject("暗証番号");
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(String.valueOf(pin));

            // メールのメタ情報を作成
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            message.setHeader(
                "Content-Transfer-Encoding", "base64");

            // メールを送信する
            message.setContent(multipart);
              Transport.send(message);
            return "newregistpin.jsp";

      }
        return "newregistmail-error.jsp";
    }
}
