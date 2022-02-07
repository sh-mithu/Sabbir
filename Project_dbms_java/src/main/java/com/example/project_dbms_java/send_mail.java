package com.example.project_dbms_java;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class send_mail
{
    public static void sendmail(String text,String code) {

        //String to = "innocent.noreply@gmail.com"; // to address. It can be any like gmail, yahoo etc.
        String from = "innocent.noreply@gmail.com"; // from address. As this is using Gmail SMTP your from address should be gmail
        String password = "Noreply@123";// password for from gmail address that you have used in above line.

        Properties prop = new Properties();
        prop.setProperty("mail.smtp.host", "smtp.gmail.com");
        prop.setProperty("mail.smtp.port", "465");
        prop.setProperty("mail.smtp.auth", "true");
        prop.setProperty("mail.smtp.socketFactory.port", "465");
        prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(text));
            message.setSubject("Test Mail From Gmail Accocunt");
            message.setText("Dear user,\nYour passsword reset code "+code+"\n\nThank You\nFrom Team: 10^12");

            Transport.send(message);

            System.out.println("Mail Sent...");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

/*

final String to = text;
        final String from = "mail.no_repy@yahoo.com";

        String host = "smtp.mail.yahoo.com";
        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port","465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "Mail@8520");
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Reset Code");
            message.setText("Dear user,\n Your passsword reset code "+code+"\n\nThank You \nTeam 10^12");

            Transport.send(message);

            System.out.println("Mail Sent...");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

*/
