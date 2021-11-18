package com.assignment.studentdetails.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Course.
 */
@Entity
@Table(name="courses")
public class Course implements Serializable {
	
	/** The id. */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="course_id")
    private Integer id;

    /** The department. */
    @ManyToOne
    @JoinColumn(name = "Name")
    private Department department;

    /** The instructor. */
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    /** The duration. */
    @Column(name = "Duration",nullable = false)
    private Integer duration;

    /** The name. */
    @Column(name = "Course_name",nullable = false)
    private String name;

    /**
     * Instantiates a new course.
     */
    public Course() {

    }


    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Gets the duration.
     *
     * @return the duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Sets the duration.
     *
     * @param duration the new duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", departmentName='" + department + '\'' +
                ", instructorId=" + instructor +
                ", duration=" + duration +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Gets the department.
     *
     * @return the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Sets the department.
     *
     * @param department the new department
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Gets the instructor.
     *
     * @return the instructor
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * Sets the instructor.
     *
     * @param instructor the new instructor
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
  }
