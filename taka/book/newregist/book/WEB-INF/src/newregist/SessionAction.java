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

public class SessionAction extends  Action{

      public String execute(
        HttpServletRequest request, HttpServletResponse response
      ) throws Exception {

        String open =request.getParameter("open");


    }
}
