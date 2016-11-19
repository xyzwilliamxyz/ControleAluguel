package br.com.controle.aluguel.exception;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@EnableWebMvc
@ControllerAdvice
public class ExceptionHandling {
	
	private Logger logger = Logger.getLogger(ExceptionHandling.class.getName());
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> businessExceptionHandler(CustomException ex) {
		
		ex.printStackTrace();
		
		logger.error(ex.getMessage());
		
		ErrorResponse error = new ErrorResponse();
		error.setStatus(ex.getErrorCode());
		error.setErrors(ex.getErrors());
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> exceptionDefaultValidationHandler(MethodArgumentNotValidException ex) {
		
		ex.printStackTrace();
		logger.error(ex.getMessage());
		
		ErrorResponse error = new ErrorResponse();
		
		List<ObjectError> errorsValidation = ex.getBindingResult().getAllErrors();
		
		for (ObjectError ev : errorsValidation) {
			error.getErrors().add("'" + ((FieldError)ev).getField() + "': " + ev.getDefaultMessage());
		}
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> internalServerErrorExceptionHandler(Exception ex) {
		
		ex.printStackTrace();
		logger.error(ex.getMessage());
		
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setErrors(new ArrayList<>());
		error.getErrors().add("Erro interno!");
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
