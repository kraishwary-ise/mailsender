package com.example.mailsender.mailsender;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
	
	@Autowired
	private EmailManager mailclient;
	
	
    @PostMapping("/sendmail")
    public ResponseEntity<String> requestmail(@RequestParam String email,String otpRequest) {
        try {
        	mailClient(email,otpRequest);
                      
            return ResponseEntity.ok("OTP sent successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to send OTP: " + e.getMessage());
        }
    }
	

public void mailClient(String email, String otpRequest) throws MessagingException {
		
		EmailData mailData=new EmailData();
		mailData.setEmail(email);
		mailData.setBody("Your otp is  :"+otpRequest);
		mailData.setFrom("kraishwary16@gmail.com");
		StringBuilder msg=new StringBuilder();
		msg.append("Sign-up Success\nUserName:");
		msg.append(email);
		mailData.setSubject(msg.toString());
		System.out.println("sending mal");
		mailclient.sendMail(mailData);

}
	

}
