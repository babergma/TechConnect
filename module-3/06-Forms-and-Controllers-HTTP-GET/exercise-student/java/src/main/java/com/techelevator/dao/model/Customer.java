package com.techelevator.dao.model;

/**
 * Customer
 */
public class Customer {

	private String firstName;
	private String lastName;
	private String email;
	private boolean activebool;

	public Customer() {
	}

	public Customer(String firstName, String lastName, String email, boolean active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.activebool = active;

	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return activebool;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.activebool = activebool;
	}
}