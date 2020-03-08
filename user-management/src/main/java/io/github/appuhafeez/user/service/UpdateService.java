package io.github.appuhafeez.user.service;

public interface UpdateService {

	public void updateEmail(int userId, String email);
	public void updatePassword(int userId, String oldPassword, String newPassword, String confirmPassword) throws Exception;
}
