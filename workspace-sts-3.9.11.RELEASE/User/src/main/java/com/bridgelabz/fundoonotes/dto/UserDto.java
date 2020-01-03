package com.bridgelabz.fundoonotes.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserDto {

	
	@NotEmpty(message = "name should be not empty")
	private String name;
	
	
	@NotEmpty(message="email id should be not empty")
	private String email;
	
	
	@NotEmpty(message="password should be not empty")
	private String password;
	
	@NotNull
	@Pattern(regexp="^[6-9]?[0-9]{9}+5")
	private long phone_number;
	private String address;

	public UserDto() {
	}

	public UserDto(String name, String email, String password, long phone_number, String address) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", email=" + email + ", password=" + password + ", phone_number="
				+ phone_number + ", address=" + address + "]";
	}

}
