package com.assignment.studentdetails.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.studentdetails.entity.StudentCourse;
import com.assignment.studentdetails.entity.StudentCourseKey;

/**
 * The Interface StudentCourseRepository.
 */
@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, StudentCourseKey>{

}
