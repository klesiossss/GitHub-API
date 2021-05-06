package br.com.dev.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;


@Builder
public class ExceptionMessage {
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
	public ExceptionMessage(String message, HttpStatus statusCode, List<String> errors) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.errors = errors;
	}
	private String message;
	private HttpStatus statusCode;
	private List<String> errors;

}
