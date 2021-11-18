package com.assignment.studentdetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.assignment.studentdetails.entity.Course;
import com.assignment.studentdetails.entity.Department;
import com.assignment.studentdetails.entity.Instructor;
import com.assignment.studentdetails.entity.Student;
import com.assignment.studentdetails.entity.StudentCourse;
import com.assignment.studentdetails.exception.NoDataFoundException;
import com.assignment.studentdetails.exception.StudentNotfoundException;
import com.assignment.studentdetails.repository.CourseRepository;
import com.assignment.studentdetails.repository.DepartmentRepository;
import com.assignment.studentdetails.repository.InstructorRepository;
import com.assignment.studentdetails.repository.StudentCourseRepository;
import com.assignment.studentdetails.repository.StudentRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentDetailsService.
 */
@Service
public class StudentDetailsService {
	
	
	/** The student repository. */
	@Autowired
	StudentRepository studentRepository;
	
	/** The course repository. */
	@Autowired
	CourseRepository courseRepository;
	
	/** The department repository. */
	@Autowired
	DepartmentRepository departmentRepository;
	
	/** The instructor repository. */
	@Autowired
	InstructorRepository instructorRepository;
	
	/** The student course repository. */
	@Autowired
	StudentCourseRepository studentCourseRepository;
	
	/**
	 * Adds the student details.
	 *
	 * @param student the student
	 * @return the student
	 */
	public Student addStudentDetails(Student student) {
		
		Student studentResult = studentRepository.save(student);
		
//		student.getCourses().forEach(obj->{
//			departmentRepository.save(obj.getDepartment());
//			if(Objects.nonNull(obj.getDepartment())) {
//				
//				courseRepository.save(obj);
//			}
//			
//			
//			
//		});
		
		
		return studentResult;
	}

	
	
	
	
	
	
	/**
	 * Enroll course.
	 *
	 * @param studentCourse the student course
	 * @return the student course
	 */
	public StudentCourse enrollCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		return studentCourseRepository.save(studentCourse);
	}







	/**
	 * Gets the student detail by id.
	 *
	 * @param studentId the student id
	 * @return the student detail by id
	 */
	public Student getStudentDetailById(Integer studentId) {
		return studentRepository.findById(studentId).orElseThrow(()-> new StudentNotfoundException(studentId));
	}







	/**
	 * Gets the all student details.
	 *
	 * @return the all student details
	 */
	public List<Student> getAllStudentDetails() {
		List<Student> studentsList = new ArrayList<Student>();
				
		studentRepository.findAll().forEach(studentsList::add);
	
		if(CollectionUtils.isEmpty(studentsList)) {
			throw new NoDataFoundException();
		}
		return studentsList;
	}


	/**
	 * Modify student details.
	 *
	 * @param student the student
	 * @return the student
	 */
	public Student modifyStudentDetails(Student student) {
		Student studentDetail = studentRepository.findById(student.getId()).orElseThrow(()-> new StudentNotfoundException(student.getId()));
			BeanUtils.copyProperties(student, studentDetail);
			return studentRepository.save(studentDetail);
	}







	/**
	 * Removes the student detail.
	 *
	 * @param student the student
	 */
	public void removeStudentDetail(Student student) {
		Student studentDetail = studentRepository.findById(student.getId()).orElseThrow(()-> new StudentNotfoundException(student.getId()));
		studentRepository.deleteById(student.getId());
	}







	/**
	 * Removes the all student detail.
	 *
	 * @param students the students
	 */
	public void removeAllStudentDetail(List<Student> students) {
		List<Integer> idList = students.stream().map(Student::getId).collect(Collectors.toList());
		List<Student> studentsList = new ArrayList<Student>();
		studentRepository.findAll().forEach(studentsList::add);
		List<Integer> existingIdList = studentsList.stream().map(Student::getId).collect(Collectors.toList());
		if(CollectionUtils.isEmpty(studentsList)) {
			throw new NoDataFoundException();
		} else {
			if(CollectionUtils.containsAny(idList, existingIdList)) {
				studentRepository.deleteAll(students);
			} else {
				throw new NoDataFoundException();
			}
		}
		
	}
	
}
