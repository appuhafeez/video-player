package io.github.appuhafeez.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.appuhafeez.user.entity.Users;
import io.github.appuhafeez.user.repository.RegistrationRepo;

@Service
public class UpdateServiceImpl implements UpdateService {

	@Autowired
	RegistrationRepo registrationRepo;
	
	@Override
	public void updateEmail(int userId, String email) {
		Optional<Users> user =registrationRepo.findById(userId);
		Users tempUser = user.get();
		tempUser.getUser().setEmail(email);
		registrationRepo.save(tempUser);
	}

}
