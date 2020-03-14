package io.github.appuhafeez.notify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {


	@Autowired
	private JavaMailSender javaMailSender;

	public boolean sendEmail(List<String> email,String message,String heading) {
		try {
			String[] emails = new String[email.size()];
			email.toArray(emails);
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(emails);

			msg.setSubject(heading);
			msg.setText(message);

			javaMailSender.send(msg);

			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}



}
