package stuff;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String gender;
	private String address;
	private String city;
	private String phone;
	private String email;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Person() {

	}

	public Person(String firstName, String lastName, String gender, String address, String city, String phone,
			String email, String id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.email = email;
		this.phone = phone;
		this.id = id;
	}

	
	/**
	 * Getters and setters
	 */
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
