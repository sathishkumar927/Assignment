package com.assignment.studentdetails.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentNotFoundException.
 */
public class DepartmentNotFoundException extends RuntimeException {
	
	/**
	 * Instantiates a new department not found exception.
	 *
	 * @param deptName the dept name
	 */
	public DepartmentNotFoundException(String deptName) {
		 super(String.format("Department with Name %d not found",deptName));
	}
}
