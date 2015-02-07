package edu.rit.hello.models;

/**
 * Represents a user of the application
 * 
 * @author sito
 */
public class User {
	
	private String firstName;
	private String lastName;
	private String occupation;
	
	/**
	 * Constructor for User
	 */
	public User(String fName, String lName, String occupation) {
		this.firstName = fName;
		this.lastName = lName;
		this.occupation = occupation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
}
