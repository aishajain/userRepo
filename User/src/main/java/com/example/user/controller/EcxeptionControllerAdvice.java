package com.example.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EcxeptionControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody String exceptionHandlerMethod(Exception e) {
		return e.getMessage();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody List<String> handleMethodArgumentNotValid(MethodArgumentNotValidException mave)
	{
		List<String> errors = new ArrayList<>();
		BindingResult bindingResult = mave.getBindingResult();
		if (bindingResult != null && bindingResult.hasErrors())
		{
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError fieldError : fieldErrors)
			{
				errors.add( fieldError.getField() + " : " + fieldError.getDefaultMessage());
			}
		}
		return errors;
	}
}
