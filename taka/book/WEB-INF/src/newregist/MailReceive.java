package mail;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Folder;
import javax.mail.Message;

public class MailReceive {

    public static void main(String[] args){
        System.out.print("start: main\r\n");

        try {
            //メール受信のプロパティ設定
            Properties props = new Properties();
            props.put("mail.pop3.host", "pop.mail.yahoo.co.jp");
            props.put("mail.pop3.port", "110");

            // メール受信フォルダをオープン
            Session session = Session.getDefaultInstance(props);
            Store store = session.getStore("pop3");
            store.connect("ID", "PW");
            Folder folderInbox = store.getFolder("INBOX");
            folderInbox.open(Folder.READ_ONLY);

            // メッセージ一覧を取得
            Message[] arrayMessages = folderInbox.getMessages();
            for (int lc = 0; lc < arrayMessages.length; lc++) {

                // メッセージの取得
                Message message = arrayMessages[lc];

                // 件名の取得と表示
                String subject = message.getSubject();
                System.out.print("件名：" + subject + "\r\n");

                // 本文の取得と表示
                String content = message.getContent().toString();
                System.out.print("本文：" + content + "\r\n");

                // 取得の最大件数は１０件
                if (lc >= 10) {
                    break;
                }
                System.out.print("\r\n");
            }
        } catch (Exception e) {
            System.out.print("例外が発生！");
            e.printStackTrace();
        } finally {
        }
        System.out.print("end: main\r\n");
    }
}
