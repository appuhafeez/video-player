package io.github.appuhafeez.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import io.github.appuhafeez.user.customexception.BadRequestException;
import io.github.appuhafeez.user.customexception.NotFoundException;
import io.github.appuhafeez.user.entity.Users;
import io.github.appuhafeez.user.repository.RegistrationRepo;

@Service
public class UpdateServiceImpl implements UpdateService {

	@Autowired
	RegistrationRepo registrationRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void updateEmail(int userId, String email) {
		Optional<Users> user =registrationRepo.findById(userId);
		if(!user.isPresent()) {
			throw new NotFoundException(userId);
		}
		Users tempUser = user.get();
		tempUser.getUser().setEmail(email);
		registrationRepo.save(tempUser);
	}

	@Override
	public void updatePassword(int userId, String oldPassword, String newPassword, String confirmPassword) throws Exception {

		Optional<Users> user =registrationRepo.findById(userId);
		if(!user.isPresent()) {
			throw new NotFoundException(userId);
		}
		Users tempUser = user.get();
		if(!passwordEncoder.matches(oldPassword, tempUser.getPassword().substring(8))) {
			throw new BadRequestException("Password doesn't matches with oldPassword");
		}else if(newPassword.isEmpty() || confirmPassword.isEmpty()) {
			throw new BadRequestException("Password shouldn't be empty");
		}else if(!newPassword.equals(confirmPassword)) {
			throw new BadRequestException("Please enter newPassword and confirmPassword same");
		}else {
			tempUser.setPassword("{bcrypt}".concat(passwordEncoder.encode(newPassword)));
			registrationRepo.save(tempUser);
		}
	}

}
