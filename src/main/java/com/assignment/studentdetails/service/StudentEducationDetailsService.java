package com.assignment.studentdetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.studentdetails.dao.StudentEducationDetailsDao;
import com.assignment.studentdetails.entity.Course;
import com.assignment.studentdetails.entity.Student;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentEducationDetailsService.
 */
@Service
public class StudentEducationDetailsService {
	
	/** The university DAO. */
	@Autowired
    StudentEducationDetailsDao universityDAO;

	/**
	 * Gets the course list by student id.
	 *
	 * @param studentId the student id
	 * @return the course list by student id
	 */
	public List<Course> getCourseListByStudentId(Integer studentId) {
		return universityDAO.getCourseListByStudentId(studentId);
	}

	/**
	 * Gets the student list by instructor id.
	 *
	 * @param instructorId the instructor id
	 * @return the student list by instructor id
	 */
	public List<Student> getStudentListByInstructorId(Integer instructorId) {
		return universityDAO.getStudentListByInstructorId(instructorId);
	}

	/**
	 * Gets the total duration for courses bystudent id.
	 *
	 * @param studentId the student id
	 * @return the total duration for courses bystudent id
	 */
	public Integer getTotalDurationForCoursesBystudentId(Integer studentId) {
		return universityDAO.getTotalDurationForCoursesBystudentId(studentId);
	}
}
