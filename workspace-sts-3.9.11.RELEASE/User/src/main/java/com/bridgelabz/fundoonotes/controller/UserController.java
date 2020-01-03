package com.bridgelabz.fundoonotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bridgelabz.fundoonotes.dto.UserDto;
import com.bridgelabz.fundoonotes.dto.loginDto;
import com.bridgelabz.fundoonotes.response.Response;
import com.bridgelabz.fundoonotes.service.UserService;

import java.util.Arrays;

import javax.servlet.http.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = "*", origins = "*",exposedHeaders = {"token"})
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/register")
	public ResponseEntity<Response> registerUser(@RequestBody UserDto userdto, HttpServletRequest request) {
		StringBuffer headerUrl = request.getRequestURL();
		String message = userService.Register(userdto, headerUrl);
		Response response = new Response(200, message, null);
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

	@GetMapping("/verification/{token}")
	public ResponseEntity<Response> emailValidate(@PathVariable String token) {

		String message = userService.validateUser(token);
		Response response = new Response(200, message, null);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody loginDto logindto, HttpServletResponse servletResponse) {
		String token = userService.Login(logindto);
		servletResponse.setHeader("Authorization", token);
		
		 String url = "http://localhost:8082/noteservice/getallnotes";
		 HttpHeaders headers = new HttpHeaders();
		 headers.set("token",token);
		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 HttpEntity<String> entity = new HttpEntity<String>(headers);
		 System.out.println("header-->" + headers); // Note noteId =
		 // restTemplate.getForObject(url, Note.class);
		 ResponseEntity<Object[]> notes = restTemplate.exchange(url,HttpMethod.GET ,entity,Object[].class);
		 System.out.println(notes.getBody());
		 System.out.println(token);
		
		Response response = new Response(200, "logged in successfully", token);
		return new ResponseEntity<>(notes.getBody(), HttpStatus.OK);
	}

	@GetMapping("/forget")
	public ResponseEntity<Response> forgetPassword(@RequestParam String email, HttpServletRequest request) {
		StringBuffer resetUrl = request.getRequestURL();
		String message = userService.forgotPassword(email, resetUrl);
		Response response = new Response(200, message, null);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PutMapping("/reset")
	public ResponseEntity<Response> resetPassword(@RequestParam String password, @RequestHeader String token) {
		String message = userService.resetPassword(password, token);
		Response response = new Response(200, message, null);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public String test() {
		return "Hello";
	}

}
