package com.assignment.studentdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.studentdetails.entity.Course;
import com.assignment.studentdetails.entity.Department;
import com.assignment.studentdetails.entity.Instructor;
import com.assignment.studentdetails.entity.Student;
import com.assignment.studentdetails.entity.StudentCourse;
import com.assignment.studentdetails.service.StudentCourseService;
import com.assignment.studentdetails.service.StudentDetailsService;

import io.swagger.annotations.Api;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentDetailsController.
 */
@Api(value = "StudentDetailsController", description = "REST Apis related to Student Entity!!!!")
@RestController
@RequestMapping("/api/v1/student")
public class StudentDetailsController {
	
	/** The student details service. */
	@Autowired
	StudentDetailsService studentDetailsService;
	
	/** The student course service. */
	@Autowired
	StudentCourseService studentCourseService;
	
	
	/**
	 * Adds the student details.
	 *
	 * @param student the student
	 * @return the student
	 */
	@PostMapping("/addStudentDetails")
	public Student addStudentDetails(@RequestBody Student student) {
		return studentDetailsService.addStudentDetails(student);
	}
	
	/**
	 * Gets the student detail by id.
	 *
	 * @param studentId the student id
	 * @return the student detail by id
	 */
	@GetMapping("/getStudentDetail/{studentId}")
	public Student getStudentDetailById(@PathVariable Integer studentId) {
		return studentDetailsService.getStudentDetailById(studentId);
	}
	
	/**
	 * Gets the all student details.
	 *
	 * @return the all student details
	 */
	@GetMapping("/getAllStudentDetails")
	public List<Student> getAllStudentDetails() {
		return studentDetailsService.getAllStudentDetails();
	}
	
	/**
	 * Modify student details.
	 *
	 * @param student the student
	 * @return the student
	 */
	@PutMapping("/modifyStudentDetails")
	public Student modifyStudentDetails(@RequestBody Student student) {
		
		return studentDetailsService.modifyStudentDetails(student); 	
	}
	
	/**
	 * Removes the student detail.
	 *
	 * @param student the student
	 */
	@DeleteMapping("/removeStudentDetail")
	public void removeStudentDetail(@RequestBody Student student) {
		
		studentDetailsService.removeStudentDetail(student);
	}
	
	/**
	 * Removes the all student detail.
	 *
	 * @param students the students
	 */
	@DeleteMapping("/removeAllStudentDetail")
	public void removeAllStudentDetail(@RequestBody List<Student> students) {
		
		studentDetailsService.removeAllStudentDetail(students);
	}
	
	/**
	 * Enroll course.
	 *
	 * @param studentId the student id
	 * @param courseId the course id
	 * @return the student course
	 */
	@PostMapping("/enrollCourse/{studentId}/{courseId}")
	public StudentCourse enrollCourse(@PathVariable Integer studentId,@PathVariable Integer courseId ) {
		return studentCourseService.enrollStudentInCourse(studentId, courseId);
	}
	
	/**
	 * Removes the student in course.
	 *
	 * @param studentId the student id
	 * @param courseId the course id
	 */
	@DeleteMapping("/removeStudentInCourse/{studentId}/{courseId}")
	public void removeStudentInCourse(@PathVariable Integer studentId,@PathVariable Integer courseId ) {
		studentCourseService.removeStudentInCourse(studentId, courseId);
	}
	

}
