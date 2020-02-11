package io.github.appuhafeez.user.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.catalina.session.FileStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.github.appuhafeez.user.entity.AccountUser;
import io.github.appuhafeez.user.entity.AuthoriteId;
import io.github.appuhafeez.user.entity.Authorities;
import io.github.appuhafeez.user.entity.Users;
import io.github.appuhafeez.user.repository.AuthoritiesRepo;
import io.github.appuhafeez.user.repository.RegistrationRepo;

@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	RegistrationRepo registrationRepo;
	
	@Autowired
	AuthoritiesRepo authoritiesRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public void reigsterUser(MultipartFile avatar,String email,String password,String userName, String firstName, String lastName) throws FileNotFoundException {
		
		Users tempUser = new Users();
		
		Authorities tempAuthorities = new Authorities();

		tempUser.setPassword("{bcrypt}".concat(passwordEncoder.encode(password)));
		tempUser.setUserName(userName);
		
		//Users registerdUser = registrationRepo.save(tempUser);
		
		AccountUser accountUser = new AccountUser();
		accountUser.setEmail(email);
		accountUser.setFirstName(firstName);
		accountUser.setLastName(lastName);
		
		try {
			accountUser.setData(avatar.getBytes());
			accountUser.setContentType(avatar.getContentType());
			accountUser.setFileName(avatar.getName());
		} catch (IOException e) {
			throw new FileNotFoundException("Could not store file " + avatar + ". Please try again!");
		}
		tempUser.setUser(accountUser);
		Users registerdUser = registrationRepo.save(tempUser);
		
		AuthoriteId tempAuthoriteId = new AuthoriteId(registerdUser.getUserName(),"ROLE_USER");
		tempAuthorities.setAuthoriteId(tempAuthoriteId);
		
		authoritiesRepo.save(tempAuthorities);
	}

}