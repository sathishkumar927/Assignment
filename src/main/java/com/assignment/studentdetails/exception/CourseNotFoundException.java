package com.assignment.studentdetails.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class CourseNotFoundException.
 */
public class CourseNotFoundException extends RuntimeException{
	
	/**
	 * Instantiates a new course not found exception.
	 *
	 * @param id the id
	 */
	public CourseNotFoundException(Integer id) {
		 super(String.format("Course with Id %d not found", id));
	}
}
