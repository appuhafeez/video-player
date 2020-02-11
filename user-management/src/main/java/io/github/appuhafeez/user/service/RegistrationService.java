package io.github.appuhafeez.user.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface RegistrationService {
	
	public void reigsterUser(MultipartFile avatar, String email, String password, String userName, String firstName, String lastName) throws FileNotFoundException;
}
