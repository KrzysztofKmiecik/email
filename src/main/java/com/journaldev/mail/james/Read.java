package com.journaldev.mail.james;

import javax.mail.*;
import java.util.Properties;

public class Read {
    public static void main(String[] args) throws Exception {
        String host = "james.local";
        String username = "user01@james.local";
        String password = "1234";


        Properties properties=new Properties();
        properties.put("mail.store.host",host);
        Session session=Session.getDefaultInstance(properties,null);
        Store store=session.getStore("imap");
        store.connect(host,username,password);
        Folder folder=store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);
        Message msg=folder.getMessage(1);
        System.out.println(msg.getFrom()[0]);
        System.out.println(msg.getSubject());
        System.out.println(msg.getContent());
        folder.close(false);
        store.close();

    }


}
