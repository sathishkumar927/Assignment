package com.assignment.studentdetails.entity;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentCourse.
 */
@Entity
@Table(name = "student_course")
public class StudentCourse {
    
    /** The id. */
    @EmbeddedId
    private StudentCourseKey id;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public StudentCourseKey getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(StudentCourseKey id) {
        this.id = id;
    }
}
