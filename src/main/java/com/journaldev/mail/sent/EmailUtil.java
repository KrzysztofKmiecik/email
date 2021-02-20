package com.journaldev.mail.sent;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

    /**
     * Utility method to send simple HTML email
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     */
    public static void sendEmail(Session session, String toEmail, String subject, String body){
        try
        {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

        //    msg.setFrom(new InternetAddress("krzysztof.kmiecik@aptiv.com", "NoReply-JD"));
            msg.setFrom(new InternetAddress("eoltserverprod@eoltserverprod.com", "NoReply-JD"));

         //   msg.setReplyTo(InternetAddress.parse("krzysztof.kmiecik@aptiv.com", false));
            msg.setReplyTo(InternetAddress.parse("eoltserverprod@eoltserverprod.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Main {

        public static void main(String[] args) {


            System.out.println("SimpleEmail Start");

           // String smtpHostServer = "smtp.aptiv.com";
            String smtpHostServer = "james.local";
          //  String emailID = "krzysztof.kmiecik@aptiv.com";
            String emailID = "user01@james.local";

            Properties props = System.getProperties();

            props.put("mail.smtp.host", smtpHostServer);

            Session session = Session.getInstance(props, null);

            sendEmail(session, emailID,"Aptiv is OK", "Aptiv is OK");


        }

    }
}
