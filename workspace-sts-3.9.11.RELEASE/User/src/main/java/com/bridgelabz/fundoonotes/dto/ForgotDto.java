package com.bridgelabz.fundoonotes.dto;

public class ForgotDto {
	private String password;
	

	public ForgotDto() {

	}

	
	public ForgotDto(String password) {
		
		this.password = password;
		
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "ForgotDto [password=" + password + "]";
	}


	
	

}
