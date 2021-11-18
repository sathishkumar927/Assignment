package com.assignment.studentdetails.entity;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public class User {
	
	
	/** The user. */
	private String user;
    
    /** The pwd. */
    private String pwd;
    
    /** The token. */
    private String token;

    /**
     * Gets the user.
     *
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the user.
     *
     * @param user the new user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Gets the pwd.
     *
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * Sets the pwd.
     *
     * @param pwd the new pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * Gets the token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token.
     *
     * @param token the new token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
