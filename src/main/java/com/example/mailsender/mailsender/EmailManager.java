package com.example.mailsender.mailsender;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class EmailManager {
	
	   private static final Logger LOG = LoggerFactory.getLogger(EmailManager.class);

	
	@Autowired
    private JavaMailSender javaMailSender;
	
	   public void sendMail(final EmailData email) throws MessagingException {
	        final JavaMailSenderImpl mailSender = (JavaMailSenderImpl) this.javaMailSender;
	        final Properties javaMailProperties = mailSender.getJavaMailProperties();

	       System.out.println("Java mail properties " + javaMailProperties);
	        final MimeMessage mimeMessage = mailSender.createMimeMessage();
	        final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);

	        mimeMessageHelper.setFrom(new InternetAddress(email.getFrom()));
	        mimeMessageHelper.setTo(new InternetAddress(email.getTo()));
	        mimeMessageHelper.setSubject(email.getSubject());
	        mimeMessageHelper.setText(email.getBody(), true);
	        mailSender.send(mimeMessage);
	        System.out.println("Mail sent to " + email.getTo());
	    }


}
