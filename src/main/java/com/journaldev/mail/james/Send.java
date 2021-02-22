package com.journaldev.mail.james;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Send {

    public static void main(String[] args) throws Exception {
        String host  = "localhost";
       // String sender="jack@mycomp.com";
        String sender="user02@localhost";
      //  String receiver="john@localhost";
      //  String receiver="user01@james.local";
        String receiver="mail@eoltserverprod.local";
        String subject="Greetings2222223333";


        Properties p=new Properties();
        p.put("mail.smtp.host",host);
        Session ses= Session.getInstance(p,null);
        Message msg = new MimeMessage(ses);

        msg.setFrom(new InternetAddress(sender));
        msg.setRecipient(Message.RecipientType.TO,new InternetAddress(receiver));
        msg.setSubject(subject);
        msg.setText("Aptiv is OK");
        Transport.send(msg);

    }

}
