package com.assignment.studentdetails.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.studentdetails.entity.Course;
import com.assignment.studentdetails.entity.Student;
import com.assignment.studentdetails.exception.StudentNotfoundException;

public class StudentEducationDetailsDaoTest extends StudentdetailsApplicationTests {
	 @Autowired
	    StudentEducationDetailsDao studentEducationDetailsDao;

	    @Test
	    public void shouldFindCourseDetailForStudent() throws Exception {
	        List<Course> courseList = studentEducationDetailsDao.getCourseListByStudentId(1);
	        Assert.assertNotNull(courseList);
	    }

	    @Test
	    public void shouldFindStudentDetailByInstructorId() throws Exception {
	        List<Student> studentList = studentEducationDetailsDao.getStudentListByInstructorId(3);
	        Assert.assertNotNull(studentList);
	        Assert.assertEquals(2, studentList.size());
	    }

	    @Test
	    public void shouldValidateCourseDuration() throws Exception {
	        Integer duration = studentEducationDetailsDao.getTotalDurationForCoursesBystudentId(1);
	        Assert.assertEquals(12, duration.longValue());
	    }

	    @Test(expected = StudentNotfoundException.class)
	    public void shouldThrowErrorForInvalidStudent() throws Exception {
	        studentEducationDetailsDao.getCourseListByStudentId(0);

	    }

}
