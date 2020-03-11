package io.github.appuhafeez.user.customexception;

public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException(int id) {
		super("User id not found : "+id);
	}
}
