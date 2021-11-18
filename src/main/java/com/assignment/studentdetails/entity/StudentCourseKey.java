package com.assignment.studentdetails.entity;

import javax.persistence.*;
import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentCourseKey.
 */
@Embeddable
public class StudentCourseKey implements Serializable {
    
    /** The course. */
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
    /** The student. */
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    /**
     * Gets the course.
     *
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Sets the course.
     *
     * @param course the new course
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * Gets the student.
     *
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "StudentCourse{" +
                "course=" + course +
                ", student=" + student +
                '}';
    }

    /**
     * Sets the student.
     *
     * @param student the new student
     */
    public void setStudent(Student student) {
        this.student = student;
    }
    
    /**
     * Instantiates a new student course key.
     */
    public StudentCourseKey(){

    }
    
    /**
     * Instantiates a new student course key.
     *
     * @param course the course
     * @param student the student
     */
    public StudentCourseKey(Course course, Student student) {
        this.course = course;
        this.student = student;
    }
    
}