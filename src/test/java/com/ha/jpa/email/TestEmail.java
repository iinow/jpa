package com.ha.jpa.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ha.jpa.config.AppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEmail {
	@Autowired
	AppConfiguration app;

	@Test
	public void send() {
		final String user = "xxxxxx@gmail.com";
		final String password = "xxxxxxx";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", app.getEmail().getGmail().getHost());
		prop.put("mail.smtp.port", app.getEmail().getGmail().getPort()); 
		prop.put("mail.smtp.auth", "true"); 
		prop.put("mail.smtp.ssl.enable", "true"); 
		prop.put("mail.smtp.ssl.trust", app.getEmail().getGmail().getHost());
		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(user));

	        //�����ڸ����ּ�
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress("iinow@naver.com")); 

	        // Subject
	        message.setSubject("Test��.."); //���� ������ �Է�

	        // Text
	        message.setText("�����̴�...");    //���� ������ �Է�

	        // send the message
	        Transport.send(message); ////����
	        System.out.println("message sent successfully...");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
