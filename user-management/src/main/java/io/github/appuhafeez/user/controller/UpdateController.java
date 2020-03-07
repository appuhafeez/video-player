package io.github.appuhafeez.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.appuhafeez.user.service.UpdateService;

@RestController
@RequestMapping("/update")
public class UpdateController {

	@Autowired
	UpdateService updateService;
	
	@PutMapping("/email/{userId}")
	public void updateEmail(@PathVariable int userId, String email) {
		updateService.updateEmail(userId,email);
	}
}
