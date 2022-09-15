package home.home2.boundary;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtilsBoundary {

    protected JavaMailUtilsBoundary(){}

    public static void sendEmail(String recipient, String subject,String msg) throws MessagingException {

        Properties properties = new Properties();

        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String myAccountEmail = "fillthedish@gmail.com";
        String myAccountPassword = "zhaxvvjadjpkjqda";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail,myAccountPassword);
            }

        });


        Message message = prepareMessage(session,myAccountEmail,recipient,subject,msg);

        Transport.send(message);

    }

    private static Message prepareMessage(Session session, String myAccountEmail,String recipient, String subject,String msg) {
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(msg);

            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
