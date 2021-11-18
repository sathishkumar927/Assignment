package com.assignment.studentdetails.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Department.
 */
@Entity
@Table(name="department")

public class Department implements Serializable {
	
	 /** The name. */
 	@Id
	    @Column(name="Name")
	    private String name;

	    /** The location. */
    	@Column(name = "location",nullable = false)
	    private String location;

	    /**
    	 * Instantiates a new department.
    	 */
    	public Department(){

	    }
	    
    	/**
    	 * Instantiates a new department.
    	 *
    	 * @param name the name
    	 * @param location the location
    	 */
    	public Department(String name, String location) {
	        this.name = name;
	        this.location = location;
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
    	 * Gets the location.
    	 *
    	 * @return the location
    	 */
    	public String getLocation() {
	        return location;
	    }

	    /**
    	 * Sets the location.
    	 *
    	 * @param location the new location
    	 */
    	public void setLocation(String location) {
	        this.location = location;
	    }

	    /**
    	 * To string.
    	 *
    	 * @return the string
    	 */
    	@Override
	    public String toString() {
	        return "Department{" +
	                "name='" + name + '\'' +
	                ", location='" + location + '\'' +
	                '}';
	    }	
}
