package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.ForgotDto;
import com.bridgelabz.fundoonotes.dto.UserDto;
import com.bridgelabz.fundoonotes.dto.loginDto;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.response.Response;

@SuppressWarnings("unused")
public interface UserService {

	String Register(UserDto userdto, StringBuffer requestUrl);

	String Login(loginDto logindto);

	String validateUser(String token);

	String forgotPassword(String email, StringBuffer requestUrl);

	String resetPassword(String password, String token);

}
