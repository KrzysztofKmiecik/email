package com.journaldev.mail.receive;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;



public class ReadTest {
    static String protocol = "pop3";
 /*   static String host = "pop.gmail.com";
    static String user = "mojetesty7777@gmail.com";
    static String password = "mp3cdsmp3cds";*/
 static String host = "10.235.244.25";
    static String user = "krzysztof.kmiecik@aptiv.com";
    static String password = "1qaz@WSX#EDC$";

    static String port = "995";
    static String url = null;
    static String root = null;
    static String pattern = "%";
    static boolean recursive = false;
    static boolean verbose = false;
    static boolean debug = true;

    public static void main(String[] args) {
        // Get a Properties object
        Properties props = System.getProperties();

        // Let's check out what's in default Properties
        System.out.println(props.toString());

        //Before opening session, set port number and ssl authentication
        props.put("mail.pop3.port", "995");
        props.put("mail.pop3.ssl.enable", "true");

        //properties are added correctly?
        System.out.println(props.toString());

        // Get a Session object
        Session session = Session.getInstance(props, null);

        // let's see what's going on by setting debug as true
        session.setDebug(debug);
        // Get a Store object
        Store store = null;
        Folder rf = null;


        try {
            if (url != null) {
                URLName urln = new URLName(url);
                store = session.getStore(urln);
                store.connect();
            } else {
                if (protocol != null) {
                    store = session.getStore(protocol);
                }
                else {
                    store = session.getStore();
                }
                // Connect
                if (host != null || user != null || password != null) {
                    store.connect(host, user, password);
                }
                else {
                    store.connect();
                }
            }
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}