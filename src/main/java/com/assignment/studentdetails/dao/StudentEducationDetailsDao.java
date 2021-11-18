package com.assignment.studentdetails.dao;

import java.util.List;

import com.assignment.studentdetails.entity.Course;
import com.assignment.studentdetails.entity.Student;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentEducationDetailsDao.
 */
public interface StudentEducationDetailsDao {
	
	/** The student course query. */
	String studentCourseQuery = "Select course from StudentCourse scourse,Course course " +
            " where scourse.id.student.id=?1 and scourse.id.course.id=course.id";
     
     /** The student instructor query. */
     String studentInstructorQuery = "Select student from StudentCourse scourse,Course course, Student student " +
            " where course.instructor.id=?1 and  scourse.id.course.id=course.id and scourse.id.student.id=student.id";
	
	/**
	 * Gets the course list by student id.
	 *
	 * @param studentId the student id
	 * @return the course list by student id
	 */
	public List<Course> getCourseListByStudentId(Integer studentId);	
	
	/**
	 * Gets the student list by instructor id.
	 *
	 * @param instructor the instructor
	 * @return the student list by instructor id
	 */
	public List<Student> getStudentListByInstructorId(Integer instructor);
	
	/**
	 * Gets the total duration for courses bystudent id.
	 *
	 * @param studentId the student id
	 * @return the total duration for courses bystudent id
	 */
	public Integer getTotalDurationForCoursesBystudentId(Integer studentId);

}
