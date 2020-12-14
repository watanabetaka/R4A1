package mail;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailtest {

//エンコード指定
    private static final String ENCODE = "ISO-2022-JP";


    public static void main(final String[] args) {

        //メール送付
        new SendMailtest().send();

    }

//ここからメール送付に必要なSMTP,SSL認証などの設定

    public void send() {
        final Properties {e.printStackTrace();} = new Properties();

        // SMTPサーバーの設定。ここではgooglemailのsmtpサーバーを設定。
        props.setProperty("mail.smtp.host", "smtp.gmail.com");

        // SSL用にポート番号を変更。
        props.setProperty("mail.smtp.port", "465");

        // タイムアウト設定
        props.setProperty("mail.smtp.connectiontimeout", "60000");
        props.setProperty("mail.smtp.timeout", "60000");

        // 認証
        props.setProperty("mail.smtp.auth", "true");

        // SSLを使用するとこはこの設定が必要。
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", "465");

       //propsに設定した情報を使用して、sessionの作成
        final Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("自分のメールドレス", "アカウントのパスワード");
            }
        });



        // ここからメッセージ内容の設定。上記で作成したsessionを引数に渡す。
        final MimeMessage message = new MimeMessage(session);

        try {
            final Address addrFrom = new InternetAddress(
                    "liverpool10coutino@gmail.com", "taka", ENCODE);
            message.setFrom(addrFrom);

            final Address addrTo = new InternetAddress("r4a1sotsuken@gmail.com",
                    "かちゅみさん", ENCODE);
            message.addRecipient(Message.RecipientType.TO, addrTo);

            // メールのSubject
            message.setSubject("ありがとうメッセージ受信しました！", ENCODE);

            // メール本文。
            message.setText("こんにちは。", ENCODE);


            // その他の付加情報。
            message.addHeader("X-Mailer", "blancoMail 0.1");
            message.setSentDate(new Date());
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // メール送信。
        try {
            Transport.send(message);
        } catch (AuthenticationFailedException e) {
            // 認証失敗
                 e.printStackTrace();
        } catch (MessagingException e) {
            // smtpサーバへの接続失敗
           e.printStackTrace();

        }
    }
}
