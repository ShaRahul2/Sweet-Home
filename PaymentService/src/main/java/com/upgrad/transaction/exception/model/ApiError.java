package com.upgrad.transaction.exception.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
public class ApiError {

	private HttpStatus status;
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;
	private List<ApiSubError> subErrors;

	private ApiError() {
		this.timestamp = LocalDateTime.now();
	}

	public ApiError(HttpStatus status) {
		this();
		this.status = status;
	}

	public ApiError(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	public ApiError(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

	private void addSubError(ApiSubError apiSubError) {
		if (Objects.isNull(subErrors)) {
			subErrors = new ArrayList<ApiSubError>();
		}
		subErrors.add(apiSubError);
	}

	private void addValidationError(String object, 
			String field,
			Object rejectedValue,
			String message) {
		addSubError(new ApiValidationError(object, field));
	}

	private void addValidationError(String object, String message) {
		addSubError(new ApiValidationError(object, message));
	}

	private void addValidationError(FieldError filedError) {
		this.addValidationError(
				filedError.getObjectName(), 
				filedError.getField(), 
				filedError.getRejectedValue(), 
				filedError.getDefaultMessage());
	}

	public void addValidationErrors(List<FieldError> fieldErrors) {
		fieldErrors.forEach(this::addValidationError);
	}

	private void addValidationError(ObjectError objectError) {
		this.addValidationError(
				objectError.getObjectName(),
				objectError.getDefaultMessage()
				);
	}

	public void addValidationError(List<ObjectError> globalErrors) {
		globalErrors.forEach(this::addValidationError);
	}

	/**
	 * Utility method for adding error of ConstraintViolation. Usually when a @Validated validation fails.
	 *
	 * @param cv the ConstraintViolation
	 */

	private void addValidationError(ConstraintViolation<?> cv) {
		this.addValidationError(
				cv.getRootBeanClass().getSimpleName(), 
				cv.getPropertyPath().toString(), 
				cv.getInvalidValue(),
				cv.getMessage()); 

	}

	public void addValidationErrors(Set<ConstraintViolation<?>>
	constraintViolations) {
		constraintViolations.forEach(this::addValidationError); 
	}

	public HttpStatus getStatus() { return status; }

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	public List<ApiSubError> getSubErrors() {
		return subErrors;
	}

	public void setSubErrors(List<ApiSubError> subErrors) {
		this.subErrors = subErrors;
	}

}
