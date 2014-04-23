package hu.jvrs.leo.helper.mail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
	//	beware of the proxy!
	public static void send(String to, String content, Boolean ssl) {		
		Properties props = new Properties();

		try {
			InputStream mailparams = SendMail.class.getClassLoader().getResourceAsStream("mail.properties");
			props.load(mailparams);
			if (ssl){
				InputStream sslparams = SendMail.class.getClassLoader().getResourceAsStream("mail.ssl.properties");
				props.load(sslparams);
			}
			else {
				InputStream tlsparams = SendMail.class.getClassLoader().getResourceAsStream("mail.tls.properties");
				props.load(tlsparams);
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		final String username = props.getProperty("username") + "@gmail.com";
		final String password = props.getProperty("password");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		session.setDebug(true);
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject("zzz");
			message.setText(content);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
