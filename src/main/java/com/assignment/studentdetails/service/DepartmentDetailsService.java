package com.assignment.studentdetails.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.studentdetails.entity.Course;
import com.assignment.studentdetails.entity.Department;
import com.assignment.studentdetails.exception.DepartmentNotFoundException;
import com.assignment.studentdetails.repository.DepartmentRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentDetailsService.
 */
@Service
public class DepartmentDetailsService {
	
	/** The department repository. */
	@Autowired
	DepartmentRepository departmentRepository;
	
	
	/**
	 * Adds the department details.
	 *
	 * @param department the department
	 * @return the department
	 */
	public Department addDepartmentDetails(Department department) {
		return departmentRepository.save(department);
	}


	/**
	 * Gets the department detail.
	 *
	 * @param deptName the dept name
	 * @return the department detail
	 */
	public Department getDepartmentDetail(String deptName) {
		Department existingDepartment = departmentRepository.findById(deptName).orElseThrow(()->new DepartmentNotFoundException(deptName));
		return existingDepartment;
	}


	/**
	 * Gets the all department details.
	 *
	 * @return the all department details
	 */
	public List<Department> getAllDepartmentDetails() {
		List<Department> departmentList = new ArrayList<Department>();
		departmentRepository.findAll().forEach(departmentList::add);
		return departmentList;
	}


	/**
	 * Modify department details.
	 *
	 * @param department the department
	 * @return the department
	 */
	public Department modifyDepartmentDetails(Department department) {
		Department existingDepartment = departmentRepository.findById(department.getName()).orElseThrow(()->new DepartmentNotFoundException(department.getName()));
		BeanUtils.copyProperties(department, existingDepartment);
		
		return departmentRepository.save(existingDepartment);
	}


	/**
	 * Removes the department detail.
	 *
	 * @param name the name
	 */
	public void removeDepartmentDetail(String name) {
		Department department = departmentRepository.findById(name).orElseThrow(()->new DepartmentNotFoundException(name));
		departmentRepository.deleteById(name);
	}
}

