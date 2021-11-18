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
import com.assignment.studentdetails.entity.Student;
import com.assignment.studentdetails.entity.StudentCourse;
import com.assignment.studentdetails.service.CourseDetailsService;
import com.assignment.studentdetails.service.StudentDetailsService;


// TODO: Auto-generated Javadoc
/**
 * The Class CourseDetailsController.
 */
@RestController
@RequestMapping("/api/v1/course")
public class CourseDetailsController {
	
	/** The course details service. */
	@Autowired
	CourseDetailsService courseDetailsService;
	
	/**
	 * Adds the course details.
	 *
	 * @param course the course
	 * @return the course
	 */
	@PostMapping("/addCourseDetails")
	public Course addCourseDetails(@RequestBody Course course) {
		return courseDetailsService.addCourseDetails(course);
	}
	
	/**
	 * Gets the course detail by id.
	 *
	 * @param courseId the course id
	 * @return the course detail by id
	 */
	@GetMapping("/getCourseDetail/{courseId}")
	public Course getCourseDetailById(@PathVariable Integer courseId) {
		return courseDetailsService.getCourseDetailById(courseId);
	}
	
	/**
	 * Gets the all course details.
	 *
	 * @return the all course details
	 */
	@GetMapping("/getAllCourseDetails")
	public List<Course> getAllCourseDetails() {
		return courseDetailsService.getAllCourseDetails();
	}
	
	/**
	 * Modify course details.
	 *
	 * @param course the course
	 * @return the course
	 */
	@PutMapping("/modifyCourseDetails")
	public Course modifyCourseDetails(@RequestBody Course course) {
		
		return courseDetailsService.modifyCourseDetails(course); 	
	}
	
	/**
	 * Removes the course detail.
	 *
	 * @param course the course
	 */
	@DeleteMapping("/removeCourseDetail")
	public void removeCourseDetail(@RequestBody Course course) {
		
		courseDetailsService.removeCourseDetail(course);
	}
	
	/**
	 * Removes the all course detail.
	 *
	 * @param courses the courses
	 */
	@DeleteMapping("/removeAllCourseDetail")
	public void removeAllCourseDetail(@RequestBody List<Course> courses) {
		courseDetailsService.removeAllCourseDetail(courses);
	}
	
	
}
