package com.example.mailsender.mailsender;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MailController {
	
	@Autowired
	private EmailManager mailclient;
	
	
	@Value("${triggerEndpoint}")
    private String hitPoint;
	
	@Value("${deviceID}")
    private String deviceID;
	
	
	
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
		mailData.setTo(email);
		mailData.setSubject(msg.toString());
		System.out.println("sending mal");
		mailclient.sendMail(mailData);

}
@PostMapping("/sendmailtwilio")
public ResponseEntity<String> requestmailtwil(@RequestParam String email,String otpRequest) {
    try {
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        return ResponseEntity.ok("OTP sent successfully.");
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Failed to send OTP: " + e.getMessage());
    }
}


@PostMapping("/sendsms")
public ResponseEntity<String> requestmailtwil(@RequestBody BO otpBO) {
	
    try {
    	
    	
    	
    	StringBuilder urlBuilder=new StringBuilder();
    	urlBuilder.append(hitPoint);
    	urlBuilder.append(deviceID);
    	urlBuilder.append("generateOtp?");
urlBuilder.append("message=");
urlBuilder.append(otpBO.getMessageBody());
urlBuilder.append("&");
urlBuilder.append("msisdn=");
urlBuilder.append(otpBO.getMsisdn());
urlBuilder.append("&");
urlBuilder.append("otpBO=");
urlBuilder.append(otpBO.getOtp());

    	 RestTemplate restTemplate = new RestTemplate();
    	 System.out.println(urlBuilder.toString());
    	 ResponseEntity<String> responseEntity = restTemplate.getForEntity(urlBuilder.toString(), String.class);

    	
    	
    	
    	
    	
    	
    	
    	
        return ResponseEntity.ok("OTP sent successfully.");
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Failed to send OTP: " + e.getMessage());
    }
}

	

}
