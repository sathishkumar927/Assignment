package com.assignment.studentdetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.studentdetails.entity.Course;
import com.assignment.studentdetails.entity.Student;
import com.assignment.studentdetails.entity.StudentCourse;
import com.assignment.studentdetails.entity.StudentCourseKey;
import com.assignment.studentdetails.exception.CourseNotFoundException;
import com.assignment.studentdetails.exception.NoDataFoundException;
import com.assignment.studentdetails.exception.StudentNotfoundException;
import com.assignment.studentdetails.repository.CourseRepository;
import com.assignment.studentdetails.repository.StudentCourseRepository;
import com.assignment.studentdetails.repository.StudentRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentCourseService.
 */
@Service
public class StudentCourseService {
	
	/** The student repository. */
	@Autowired
	StudentRepository studentRepository;
	
	/** The course repository. */
	@Autowired
	CourseRepository courseRepository;
	
	/** The student course repository. */
	@Autowired
	StudentCourseRepository studentCourseRepository;
	
	/**
	 * Enroll student in course.
	 *
	 * @param studentId the student id
	 * @param courseId the course id
	 * @return the student course
	 */
	public StudentCourse enrollStudentInCourse (Integer studentId,Integer courseId) {
		
		Student existingStudent = studentRepository.findById(studentId).orElseThrow(()->new StudentNotfoundException(studentId));
		Course existingCourse = courseRepository.findById(courseId).orElseThrow(()->new CourseNotFoundException(courseId));
		
		StudentCourseKey studentCourseKey = new StudentCourseKey(existingCourse, existingStudent);
		 StudentCourse studentCourse = new StudentCourse();
	        studentCourse.setId(studentCourseKey);
	       return  studentCourseRepository.save(studentCourse);
		
	}
	
	/**
	 * Removes the student in course.
	 *
	 * @param studentId the student id
	 * @param courseId the course id
	 */
	public void	removeStudentInCourse (Integer studentId,Integer courseId) {
		
		Student existingStudent = studentRepository.findById(studentId).orElseThrow(()->new StudentNotfoundException(studentId));
		Course existingCourse = courseRepository.findById(courseId).orElseThrow(()->new CourseNotFoundException(courseId));
		
		StudentCourseKey studentCourseKey = new StudentCourseKey(existingCourse, existingStudent);
		StudentCourse studentCourse = studentCourseRepository.findById(studentCourseKey).orElseThrow(()->new NoDataFoundException());
		 
	     studentCourseRepository.deleteById(studentCourseKey);
		
	}
}
