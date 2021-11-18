package com.assignment.studentdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.studentdetails.entity.Course;
import com.assignment.studentdetails.entity.Student;
import com.assignment.studentdetails.service.StudentEducationDetailsService;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentEducationDetailsController.
 */
@RestController
@RequestMapping("api/v1/educationdetails")
public class StudentEducationDetailsController {
	
	/** The student education details service. */
	@Autowired
	StudentEducationDetailsService studentEducationDetailsService;
	
	/**
	 * Gets the course list by student id.
	 *
	 * @param studentId the student id
	 * @return the course list by student id
	 */
	@GetMapping("/courses/{studentId}")
	public ResponseEntity<List<Course>> getCourseListByStudentId(@PathVariable Integer studentId){
		List<Course> courseList = studentEducationDetailsService.getCourseListByStudentId(studentId);
		return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
	}
	
	/**
	 * Gets the student list by instructor id.
	 *
	 * @param instructorId the instructor id
	 * @return the student list by instructor id
	 */
	@GetMapping("/students/{instructorId}")
	public ResponseEntity<List<Student>> getStudentListByInstructorId(@PathVariable Integer instructorId){
		List<Student> studentList = studentEducationDetailsService.getStudentListByInstructorId(instructorId);
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}
	
	 /**
 	 * Gets the total duration for courses bystudent id.
 	 *
 	 * @param studentId the student id
 	 * @return the total duration for courses bystudent id
 	 */
 	@GetMapping("/courseDuration/{studentId}")
	    public ResponseEntity<Object> getTotalDurationForCoursesBystudentId(@PathVariable Integer studentId) {
		 Integer duration = studentEducationDetailsService.getTotalDurationForCoursesBystudentId(studentId);
		 return new ResponseEntity<Object>(duration, HttpStatus.OK);
	 }	
}
