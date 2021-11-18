package com.assignment.studentdetails.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Instructor.
 */
@Entity
@Table(name="instructors")
public class Instructor implements Serializable{
	
	/** The id. */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="instructor_id")
    private Integer id;

    /** The department. */
    @ManyToOne
    @JoinColumn(name = "name")
    private Department department;

    /** The headed by. */
    @Column(name="HeadedBy",nullable = false)
    private String headedBy;

    /** The first name. */
    @Column(name="FirstName",nullable = false)
    private String firstName;

    /** The last name. */
    @Column(name="LastName",nullable = false)
    private String lastName;

    /** The phone. */
    @Column(name="Phone")
    private String phone;
    
    /**
     * Instantiates a new instructor.
     */
    public Instructor(){

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
     * Gets the headed by.
     *
     * @return the headed by
     */
    public String getHeadedBy() {
        return headedBy;
    }

    /**
     * Sets the headed by.
     *
     * @param headedBy the new headed by
     */
    public void setHeadedBy(String headedBy) {
        this.headedBy = headedBy;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone.
     *
     * @param phone the new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", departmentName='" + department + '\'' +
                ", headedBy='" + headedBy + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }	
	
}
