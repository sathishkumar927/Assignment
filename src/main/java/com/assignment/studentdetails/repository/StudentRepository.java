package com.assignment.studentdetails.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.studentdetails.entity.Student;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentRepository.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	/**
	 * Find by first name.
	 *
	 * @param name the name
	 * @return the list
	 */
	List<Student> findByFirstName(String name);
}
