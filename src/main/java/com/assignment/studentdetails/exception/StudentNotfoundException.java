package com.assignment.studentdetails.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentNotfoundException.
 */
public class StudentNotfoundException  extends RuntimeException{
	
	/**
	 * Instantiates a new student notfound exception.
	 *
	 * @param id the id
	 */
	public StudentNotfoundException(Integer id) {
		 super(String.format("Student with Id %d not found", id));
	}
}
