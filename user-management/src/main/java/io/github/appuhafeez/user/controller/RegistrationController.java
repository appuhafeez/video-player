package io.github.appuhafeez.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/register")
public class RegistrationController {

	@PostMapping("/new")
	public void registerUser(@RequestParam("avatar") MultipartFile avatar, @RequestParam("email") String email,
			@RequestParam("name") String name, @RequestParam("password") String password) {
		
	}
	
}
