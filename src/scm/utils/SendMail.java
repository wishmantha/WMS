package scm.utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import scm.help.settings;

public class SendMail {

    String m_from = settings.fromEmail;
    String m_to = settings.toEmail;
    String password = settings.password;


    public void sendMail(String m_subject, String m_body) {
    System.out.println (m_from+password);
        try {

            m_properties = new Properties();
            m_properties.put("mail.smtp.host", "smtp.gmail.com");
            m_properties.put("mail.smtp.socketFactory.port", "465");
            m_properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            m_properties.put("mail.smtp.auth", "true");
            m_properties.put("mail.smtp.port", "465");


            m_Session = Session.getDefaultInstance(m_properties, new Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(m_from, password); // username and the password
                }
            });

            m_simpleMessage = new MimeMessage(m_Session);

            m_fromAddress = new InternetAddress(m_from);
            m_toAddress = new InternetAddress(m_to);


            m_simpleMessage.setFrom(m_fromAddress);
            m_simpleMessage.setRecipient(RecipientType.TO, m_toAddress);
            m_simpleMessage.setSubject(m_subject);
            m_simpleMessage.setContent(m_body, "text/plain");

            Transport.send(m_simpleMessage);

        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private Session m_Session;
    private Message m_simpleMessage;
    private InternetAddress m_fromAddress;
    private InternetAddress m_toAddress;
    private Properties m_properties;
}
