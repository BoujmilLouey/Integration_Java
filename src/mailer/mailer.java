/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailer;

import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author yessin
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class mailer {

    public static void sendmail(String recepient) throws MessagingException /*throws Execption*/ {
        System.out.println("Preapering to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.prot", "587");

        String myAccount = "noreply.cyberark@gmail.com";
        String password = "Loulou_b_2100";

     /* Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentification getPasswordAutentication() {
                return new PasswordAuthentification(myAccount, password);
            }

        });

        Message message = prepareMassage(session, myAccount, recepient);
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    
    private static Message prepareMessage(Session session, String myAccount, String recepient) throws AddressException, MessagingException {
        Message message = new MimeMessage(session);
        message.setForm(new InternetAdress(myAccount);
        message setRecipient(Message.recipientType.TO
        ,new InternetAddress(recepient)
        );
    message.setSubject("your place have been reservated");
        message.setText("hey there ,\n your name is on the list ");
        return message;
    }
    

*/
  
    }
}
