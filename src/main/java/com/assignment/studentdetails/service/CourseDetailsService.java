package com.assignment.studentdetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.assignment.studentdetails.entity.Course;
import com.assignment.studentdetails.entity.Department;
import com.assignment.studentdetails.entity.Instructor;
import com.assignment.studentdetails.entity.Student;
import com.assignment.studentdetails.exception.CourseNotFoundException;
import com.assignment.studentdetails.exception.DepartmentNotFoundException;
import com.assignment.studentdetails.exception.InstructorNotFoundException;
import com.assignment.studentdetails.exception.NoDataFoundException;
import com.assignment.studentdetails.repository.CourseRepository;
import com.assignment.studentdetails.repository.DepartmentRepository;
import com.assignment.studentdetails.repository.InstructorRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class CourseDetailsService.
 */
@Service
public class CourseDetailsService {
	
	/** The course repository. */
	@Autowired
	CourseRepository courseRepository;
	
	/** The department repository. */
	@Autowired
	DepartmentRepository departmentRepository;
	
	/** The instructor repository. */
	@Autowired
	InstructorRepository instructorRepository;
	
	/**
	 * Adds the course details.
	 *
	 * @param course the course
	 * @return the course
	 */
	public Course addCourseDetails(Course course) {
		
		Department existingDepartment = departmentRepository.findById(course.getDepartment().getName()).orElseThrow(()->new DepartmentNotFoundException(course.getDepartment().getName()));
		Instructor existingInstructor = instructorRepository.findById(course.getInstructor().getId()).orElseThrow(()->new InstructorNotFoundException(course.getInstructor().getId()));
		
		course.setDepartment(existingDepartment);
		course.setInstructor(existingInstructor);
		if(Objects.nonNull(existingInstructor) && Objects.nonNull(existingDepartment)) {
			courseRepository.save(course);
		}
		return course;
	}


	/**
	 * Gets the course detail by id.
	 *
	 * @param courseId the course id
	 * @return the course detail by id
	 */
	public Course getCourseDetailById(Integer courseId) {
		Course existingCourse = courseRepository.findById(courseId).orElseThrow(()->new CourseNotFoundException(courseId));
		return existingCourse;
	}


	/**
	 * Gets the all course details.
	 *
	 * @return the all course details
	 */
	public List<Course> getAllCourseDetails() {
		List<Course> courseDetails = new ArrayList<>();
		courseRepository.findAll().forEach(courseDetails::add);
		return courseDetails;
	}


	/**
	 * Modify course details.
	 *
	 * @param course the course
	 * @return the course
	 */
	public Course modifyCourseDetails(Course course) {
		Course existingCourse = courseRepository.findById(course.getId()).orElseThrow(()->new CourseNotFoundException(course.getId()));
		BeanUtils.copyProperties(course, existingCourse);
		return addCourseDetails(existingCourse);
	}




	/**
	 * Removes the course detail.
	 *
	 * @param course the course
	 */
	public void removeCourseDetail(Course course) {
		Course existingCourse = courseRepository.findById(course.getId()).orElseThrow(()->new CourseNotFoundException(course.getId()));
		courseRepository.deleteById(course.getId());
	}


	/**
	 * Removes the all course detail.
	 *
	 * @param courses the courses
	 */
	public void removeAllCourseDetail(List<Course> courses) {
		List<Integer> idList = courses.stream().map(Course::getId).collect(Collectors.toList());
		List<Course> courseList = new ArrayList<Course>();
		courseRepository.findAll().forEach(courseList::add);
		List<Integer> existingIdList = courseList.stream().map(Course::getId).collect(Collectors.toList());
		if(CollectionUtils.isEmpty(courseList)) {
			throw new NoDataFoundException();
		} else {
			if(CollectionUtils.containsAny(idList, existingIdList)) {
				courseRepository.deleteAll(courses);
			} else {
				throw new NoDataFoundException();
			}
		}
		
	}


}


