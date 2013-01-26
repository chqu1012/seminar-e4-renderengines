package de.dc.hska.seminararbeit.rap.model;

public class Person {

	private String name, firstname, email;

	public Person(String name, String firstname, String email) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
