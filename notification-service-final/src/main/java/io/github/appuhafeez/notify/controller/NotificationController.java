package io.github.appuhafeez.notify.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.appuhafeez.notify.service.NotificationService;

@RestController
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping("/sendemail")
	public String sendEmail(@RequestBody String email) {
		List<String> emails = new ArrayList<String>();
		emails.add(email);
		boolean fl = notificationService.sendEmail(emails, "Testing email", "Heading hehe");
		return "success "+fl;
	}
	
}
