package com.assignment.studentdetails.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class ControllerAdvisor.
 */
@ControllerAdvice
public class ControllerAdvisor  extends ResponseEntityExceptionHandler {
	 
		/**
		 * Handle student not found exception.
		 *
		 * @param ex the ex
		 * @param request the request
		 * @return the response entity
		 */
		@ExceptionHandler(StudentNotfoundException.class)
	    public ResponseEntity<Object> handleStudentNotFoundException(
	    		StudentNotfoundException ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "Student not found");

	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }
		
		
		/**
		 * Handle nodata found exception.
		 *
		 * @param ex the ex
		 * @param request the request
		 * @return the response entity
		 */
		@ExceptionHandler(NoDataFoundException.class)
	    public ResponseEntity<Object> handleNodataFoundException(
	    		NoDataFoundException ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "No Students found");

	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }
		
		
		 /**
 		 * Handle method argument not valid.
 		 *
 		 * @param ex the ex
 		 * @param headers the headers
 		 * @param status the status
 		 * @param request the request
 		 * @return the response entity
 		 */
 		@Override
		    protected ResponseEntity<Object> handleMethodArgumentNotValid(
		        MethodArgumentNotValidException ex, HttpHeaders headers, 
		        HttpStatus status, WebRequest request) {

		        Map<String, Object> body = new LinkedHashMap<>();
		        body.put("timestamp", LocalDate.now());
		        body.put("status", status.value());

		        List<String> errors = ex.getBindingResult()
		                .getFieldErrors()
		                .stream()
		                .map(x -> x.getDefaultMessage())
		                .collect(Collectors.toList());

		        body.put("errors", errors);

		        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
		    }
		 
		 	/**
	 		 * Handle.
	 		 *
	 		 * @param ex the ex
	 		 * @param request the request
	 		 * @param response the response
	 		 * @return the response entity
	 		 */
	 		@ExceptionHandler(Exception.class)
		    public ResponseEntity<Object> handle(Exception ex, 
		                HttpServletRequest request, HttpServletResponse response) {
			 
			 Map<String, Object> body = new LinkedHashMap<>();
		        body.put("timestamp", LocalDate.now());
		        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		        body.put("errors", ex.getMessage());
		        
		        return new ResponseEntity<>(body,HttpStatus.INTERNAL_SERVER_ERROR);
		    }

}
