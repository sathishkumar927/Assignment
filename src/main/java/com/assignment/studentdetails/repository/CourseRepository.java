package com.assignment.studentdetails.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assignment.studentdetails.entity.Course;

// TODO: Auto-generated Javadoc
/**
 * The Interface CourseRepository.
 */
public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	List<Course> findByName(String name);
}
