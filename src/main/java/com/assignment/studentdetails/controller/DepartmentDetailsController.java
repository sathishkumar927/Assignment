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
import com.assignment.studentdetails.entity.Department;
import com.assignment.studentdetails.service.DepartmentDetailsService;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentDetailsController.
 */
@RestController
@RequestMapping("api/v1/department")
public class DepartmentDetailsController {
	
	
	/** The department details service. */
	@Autowired
	
	DepartmentDetailsService departmentDetailsService;
	
	/**
	 * Adds the department details.
	 *
	 * @param department the department
	 * @return the department
	 */
	@PostMapping("/addDepartmentDetails")
	public Department addDepartmentDetails(@RequestBody Department department) {
		return departmentDetailsService.addDepartmentDetails(department);
	}
	
	/**
	 * Gets the department detail.
	 *
	 * @param deptName the dept name
	 * @return the department detail
	 */
	@GetMapping("/getDepartmentDetail/{deptName}")
	public Department getDepartmentDetail(@PathVariable String deptName) {
		return departmentDetailsService.getDepartmentDetail(deptName);
	}
	
	/**
	 * Gets the all department details.
	 *
	 * @return the all department details
	 */
	@GetMapping("/getAllDepartMentDetails")
	public List<Department> getAllDepartmentDetails() {
		return departmentDetailsService.getAllDepartmentDetails();
	}
	
	/**
	 * Modify course details.
	 *
	 * @param department the department
	 * @return the department
	 */
	@PutMapping("/modifyDepartmentDetails")
	public Department modifyCourseDetails(@RequestBody Department department) {
		
		return departmentDetailsService.modifyDepartmentDetails(department); 	
	}
	
	/**
	 * Removes the course detail.
	 *
	 * @param name the name
	 */
	@DeleteMapping("/removeDepartmentDetail/{name}")
	public void removeCourseDetail(@PathVariable String name) {
		
		departmentDetailsService.removeDepartmentDetail(name);
	}
	
	

}
