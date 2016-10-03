package br.com.controle.aluguel.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class BusinessException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private int errorCode;
	private List<String> errors;
	
	public BusinessException(int errorCode, String... messages) {
		super(messages[0]);
		
		errors = new ArrayList<>();
		for (String m : messages)
			errors.add(m);
		this.errorCode = errorCode;
	}
	
	public BusinessException(String... messages) {
		this(HttpStatus.BAD_REQUEST.value(), messages);
	}
	
	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}