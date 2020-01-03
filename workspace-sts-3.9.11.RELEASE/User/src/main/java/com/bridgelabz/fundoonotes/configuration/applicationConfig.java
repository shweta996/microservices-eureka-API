package com.bridgelabz.fundoonotes.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class applicationConfig 
{
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
		
	}

	@Bean
	public ModelMapper getMapper()
	{
		return new ModelMapper();
	}
	
	@Bean
	  public RestTemplate restTemplate(RestTemplateBuilder builder) {
	      return builder.build();
	  }
     
}
 
