package com.bridgelabz.fundoonotes.utility;

public interface TokenGenerator {
	
	String generateToken(String id);
	
	String verifyToken(String token);
	

}
