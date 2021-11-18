package com.assignment.studentdetails.repository;

import org.springframework.data.repository.CrudRepository;

import com.assignment.studentdetails.entity.Department;

/**
 * The Interface DepartmentRepository.
 */
public interface DepartmentRepository extends CrudRepository<Department,String> {

}
