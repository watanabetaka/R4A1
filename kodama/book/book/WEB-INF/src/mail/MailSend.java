package mail;

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

public class MailSend {

    public static void main(String[] args){
        System.out.print("start: main\r\n");

        try {
            // メール送信のプロパティ設定
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.mail.yahoo.co.jp");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.transport.protocol", "smtp");
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
            message.setReplyTo(new Address[]{
                new InternetAddress("liverpool35takayoshi@yahoo.co.jp")});
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("liverpool35takayoshi@yahoo.co.jp"));
            message.setSubject("完了");
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("テストメール。");

            // メールのメタ情報を作成
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            message.setHeader(
                "Content-Transfer-Encoding", "base64");

            // メールを送信する
            message.setContent(multipart);
            Transport.send(message);

        } catch (Exception e) {
            System.out.print("例外が発生！\r\n");
            e.printStackTrace();
        } finally {
        }
        System.out.print("end: main\r\n");
    }
}
