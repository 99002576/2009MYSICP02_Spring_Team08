package com.bankapp.exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		List<String> details = Arrays.asList("Wrong method name","Not Supported");
		APIErrors errors = new APIErrors(message, timeStamp,status, details);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		List<String> details = Arrays.asList("Wrong media type","Irrelevant");
		APIErrors errors = new APIErrors(message,timeStamp,status, details);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		List<String> details = Arrays.asList("Missing Path variable","No Variable");
		APIErrors errors = new APIErrors(message,timeStamp,status, details);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		List<String> details = Arrays.asList("No Request Param","Missing param");
		APIErrors errors = new APIErrors(message,timeStamp,status, details);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		List<String> details = Arrays.asList("mismatch of data types","Wrong Type");
		APIErrors errors = new APIErrors(message,timeStamp,status, details);
		return ResponseEntity.status(status).body(errors);
	}

	public GlobalExceptionHandler() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
