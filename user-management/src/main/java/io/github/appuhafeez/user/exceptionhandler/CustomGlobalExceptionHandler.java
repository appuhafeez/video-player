package io.github.appuhafeez.user.exceptionhandler;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.github.appuhafeez.user.bo.CustomErrorResponse;
import io.github.appuhafeez.user.customexception.BadRequestException;
import io.github.appuhafeez.user.customexception.ExpectationFailedException;
import io.github.appuhafeez.user.customexception.InternalErrorException;
import io.github.appuhafeez.user.customexception.NotFoundException;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<CustomErrorResponse> springHandleBadRequest(Exception ex, WebRequest request) {
		
		CustomErrorResponse errorResponse = new CustomErrorResponse();
		errorResponse.setErrorMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleNotFound(Exception ex, WebRequest request) {
		
		CustomErrorResponse errorResponse = new CustomErrorResponse();
		errorResponse.setErrorMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ExpectationFailedException.class)
	public ResponseEntity<CustomErrorResponse> springHandleExpectationFailed(Exception ex, WebRequest request) {
		
		CustomErrorResponse errorResponse = new CustomErrorResponse();
		errorResponse.setErrorMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.EXPECTATION_FAILED.value());
		errorResponse.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(InternalErrorException.class)
	public ResponseEntity<CustomErrorResponse> springHandleInternalError(Exception ex, WebRequest request) {
		
		CustomErrorResponse errorResponse = new CustomErrorResponse();
		errorResponse.setErrorMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
