package io.github.appuhafeez.user.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.github.appuhafeez.user.service.RegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;
	
	@PostMapping("/new")
	public void registerUser(@RequestParam("avatar") MultipartFile avatar, @RequestParam("email") String email,
			@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("password") String password, @RequestParam("username") String userName) throws IOException {
		
		System.out.println("----test1---");
		registrationService.reigsterUser(avatar , email , password , userName, firstName , lastName);
	}
	
}
