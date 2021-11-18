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

import com.assignment.studentdetails.entity.Department;
import com.assignment.studentdetails.entity.Instructor;
import com.assignment.studentdetails.service.InstructorDetailsService;

// TODO: Auto-generated Javadoc
/**
 * The Class InstructorDetailsController.
 */
@RestController
@RequestMapping("api/v1/instructor")
public class InstructorDetailsController {
	
	/** The instructor details service. */
	@Autowired
	InstructorDetailsService instructorDetailsService;
	
	/**
	 * Adds the instructor details.
	 *
	 * @param instructor the instructor
	 * @return the instructor
	 */
	@PostMapping("/addInstructorDetails")
	public Instructor addInstructorDetails(@RequestBody Instructor instructor) {
		return instructorDetailsService.addInstructorDetails(instructor);
	}
	
	
	/**
	 * Gets the instructor detail.
	 *
	 * @param instructorId the instructor id
	 * @return the instructor detail
	 */
	@GetMapping("/getInstructorDetail/{instructorId}")
	public Instructor getInstructorDetail(@PathVariable Integer instructorId) {
		return instructorDetailsService.getInstructorDetail(instructorId);
	}
	
	/**
	 * Gets the all instructor details.
	 *
	 * @return the all instructor details
	 */
	@GetMapping("/getAllInstructorDetails")
	public List<Instructor> getAllInstructorDetails() {
		return instructorDetailsService.getAllInstructorDetails();
	}
	
	/**
	 * Modify instructor details.
	 *
	 * @param instructor the instructor
	 * @return the instructor
	 */
	@PutMapping("/modifyInstructorDetails")
	public Instructor modifyInstructorDetails(@RequestBody Instructor instructor) {
		
		return instructorDetailsService.modifyInstructorDetails(instructor); 	
	}
	
	/**
	 * Removes the instructor detail.
	 *
	 * @param instructorId the instructor id
	 */
	@DeleteMapping("/removeInstructorDetail/{instructorID}")
	public void removeInstructorDetail(@PathVariable Integer instructorId) {
		
		instructorDetailsService.removeDepartmentDetail(instructorId);
	}
	

}
