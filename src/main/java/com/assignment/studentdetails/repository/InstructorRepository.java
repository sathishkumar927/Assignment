package com.assignment.studentdetails.repository;

import org.springframework.data.repository.CrudRepository;

import com.assignment.studentdetails.entity.Instructor;

/**
 * The Interface InstructorRepository.
 */
public interface InstructorRepository extends CrudRepository<Instructor, Integer>{

}
