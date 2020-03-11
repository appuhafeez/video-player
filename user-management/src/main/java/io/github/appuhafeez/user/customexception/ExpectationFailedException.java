package io.github.appuhafeez.user.customexception;

public class ExpectationFailedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExpectationFailedException(Exception e) {
		super(e.getMessage());
	}
}
