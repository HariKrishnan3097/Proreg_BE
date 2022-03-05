package org.learn.jax.Proreg.model;

public class Person {

	private String firstName;
	private String lastName;
	private String birthdayDate;
	private String gender;
	private String address;
	private String email;
	private String regDate;
	private String personId;

	public Person() {

	}

	public Person(String firstName, String lastName, String birthdayDate, String gender, String address, String email,
			String regDate ,String personId ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdayDate = birthdayDate;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.regDate = regDate;
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

	public String getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(String birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

}
