package com.assignment.studentdetails.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.studentdetails.entity.Department;
import com.assignment.studentdetails.entity.Instructor;
import com.assignment.studentdetails.exception.DepartmentNotFoundException;
import com.assignment.studentdetails.exception.InstructorNotFoundException;
import com.assignment.studentdetails.repository.DepartmentRepository;
import com.assignment.studentdetails.repository.InstructorRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class InstructorDetailsService.
 */
@Service
public class InstructorDetailsService {
	
		/** The instructor repository. */
		@Autowired
	    InstructorRepository instructorRepository;

	    /** The department repository. */
    	@Autowired
	    DepartmentRepository departmentRepository;

	/**
	 * Adds the instructor details.
	 *
	 * @param instructor the instructor
	 * @return the instructor
	 */
	public Instructor addInstructorDetails(Instructor instructor) {
			
		Department existingDepartment = departmentRepository.findById(instructor.getDepartment().getName()).orElseThrow(()->new DepartmentNotFoundException(instructor.getDepartment().getName()));
		instructor.setDepartment(existingDepartment);
		
		return instructorRepository.save(instructor);

	}

	/**
	 * Gets the instructor detail.
	 *
	 * @param instructorId the instructor id
	 * @return the instructor detail
	 */
	public Instructor getInstructorDetail(Integer instructorId) {
		Instructor existingInstructor = instructorRepository.findById(instructorId).orElseThrow(()->new InstructorNotFoundException(instructorId));
		return existingInstructor;
	}

	/**
	 * Gets the all instructor details.
	 *
	 * @return the all instructor details
	 */
	public List<Instructor> getAllInstructorDetails() {
		List<Instructor> instructorList  = new ArrayList<>();
		instructorRepository.findAll().forEach(instructorList::add);
		
		return instructorList;
	}

	/**
	 * Modify instructor details.
	 *
	 * @param instructor the instructor
	 * @return the instructor
	 */
	public Instructor modifyInstructorDetails(Instructor instructor) {
		Integer instructorId = instructor.getId();
		Instructor existingInstructor = instructorRepository.findById(instructorId).orElseThrow(()->new InstructorNotFoundException(instructorId));
		BeanUtils.copyProperties(instructor, existingInstructor);
		Department existingDepartment = departmentRepository.findById(instructor.getDepartment().getName()).orElseThrow(()->new DepartmentNotFoundException(instructor.getDepartment().getName()));
		existingInstructor.setDepartment(existingDepartment);
		
		return instructorRepository.save(existingInstructor);
	}

	/**
	 * Removes the department detail.
	 *
	 * @param instructorId the instructor id
	 */
	public void removeDepartmentDetail(Integer instructorId) {
		
		Instructor existingInstructor = instructorRepository.findById(instructorId).orElseThrow(()->new InstructorNotFoundException(instructorId));
		instructorRepository.deleteById(instructorId);
		
	}
	
}
