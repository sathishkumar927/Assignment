package com.assignment.studentdetails.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.assignment.studentdetails.entity.Course;
import com.assignment.studentdetails.entity.Student;
import com.assignment.studentdetails.exception.CourseNotFoundException;
import com.assignment.studentdetails.exception.NoDataFoundException;
import com.assignment.studentdetails.repository.CourseRepository;
import com.assignment.studentdetails.repository.StudentRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentEducationDetailsDaoImpl.
 */
@Repository
public class StudentEducationDetailsDaoImpl implements StudentEducationDetailsDao {
	
	
	  /** The student repository. */
  	@Autowired
	    StudentRepository studentRepository;
	    
    	/** The course repository. */
    	@Autowired
	    CourseRepository courseRepository;
	   
	    /** The entity manager. */
    	@PersistenceContext
	    private EntityManager entityManager;


	
	/**
	 * Gets the course list by student id.
	 *
	 * @param studentId the student id
	 * @return the course list by student id
	 */
	@Override
	public List<Course> getCourseListByStudentId(Integer studentId) {
		List<Course> courseList =	(List<Course>) entityManager.createQuery(studentCourseQuery).setParameter(1, studentId).getResultList();
		if(CollectionUtils.isEmpty(courseList)) {
			throw new NoDataFoundException();
		}
		return courseList;
	}

	/**
	 * Gets the student list by instructor id.
	 *
	 * @param instructor the instructor
	 * @return the student list by instructor id
	 */
	@Override
	public List<Student> getStudentListByInstructorId(Integer instructor) {
		List<Student> studentList = (List<Student>) entityManager.createQuery(studentInstructorQuery).setParameter(1, instructor).getResultList();
		if(CollectionUtils.isEmpty(studentList)) {
			throw new NoDataFoundException();
		}
        return studentList;
	}

	/**
	 * Gets the total duration for courses bystudent id.
	 *
	 * @param studentId the student id
	 * @return the total duration for courses bystudent id
	 */
	@Override
	public Integer getTotalDurationForCoursesBystudentId(Integer studentId) {
		List<Course> courseList =	(List<Course>) entityManager.createQuery(studentCourseQuery).setParameter(1, studentId).getResultList();
		if(CollectionUtils.isEmpty(courseList)) {
			throw new NoDataFoundException();
		}
		return courseList.stream().map(Course::getDuration).collect(Collectors.summingInt(Integer::intValue));
	}
	
	
	
}
