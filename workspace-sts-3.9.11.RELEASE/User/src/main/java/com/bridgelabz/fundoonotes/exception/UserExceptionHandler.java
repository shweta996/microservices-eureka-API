package com.bridgelabz.fundoonotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.fundoonotes.response.Response;

@ControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handleException(Exception exception) {
		Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), null);
		return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserException.class)
	public ResponseEntity<Response> handleUserException(RuntimeException runTimeException) {
		Response response = new Response(HttpStatus.BAD_REQUEST.value(), runTimeException.getMessage(), null);
		return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	}
	/*
	 * @ExceptionHandler(NoteException.class) public ResponseEntity<Response>
	 * handleNoteException(RuntimeException runTimeException) { Response response =
	 * new Response(HttpStatus.BAD_REQUEST.value(), runTimeException.getMessage(),
	 * null); return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	 * }
	 * 
	 * @ExceptionHandler(LabelException.class) public ResponseEntity<Response>
	 * handleLabelException(RuntimeException runTimeException) { Response response =
	 * new Response(HttpStatus.BAD_REQUEST.value(), runTimeException.getMessage(),
	 * null); return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	 * }
	 */
	 
}
