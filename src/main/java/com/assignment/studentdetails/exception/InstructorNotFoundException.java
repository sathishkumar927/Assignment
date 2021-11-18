package com.assignment.studentdetails.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class InstructorNotFoundException.
 */
public class InstructorNotFoundException extends RuntimeException{
	
	/**
	 * Instantiates a new instructor not found exception.
	 *
	 * @param id the id
	 */
	public InstructorNotFoundException(Integer id) {
		 super(String.format("Instructor with Id %d not found", id));
	}
}
