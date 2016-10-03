package br.com.controle.aluguel.exception;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
	private int status;
	private List<String> errors;
	
	public ErrorResponse() {
		this.errors = new ArrayList<>();
	}
	
	
	public ErrorResponse(int status, List<String> errors) {
		super();
		this.status = status;
		this.errors = errors;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}