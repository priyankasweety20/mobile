package com.onesoft.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class MyConfiguration extends WebSecurityConfigurerAdapter {// Authentication//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		auth.inMemoryAuthentication().withUser("Priya").password("$2a$12$2874gYPWZ5V4tjAxX0FdsO2FwAU6L03AvH9XYoMnpZVLtVRhPNTFG").roles("Student");
//	}
////	@Bean
////	public PasswordEncoder pass() {
////		return NoOpPasswordEncoder.getInstance();
////	}
//	@Bean
//	public PasswordEncoder getPass() {
//		return new BCryptPasswordEncoder(12);
//	}

//	********************************************************
//	Authorization
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Priya")
				.password("$2a$12$2874gYPWZ5V4tjAxX0FdsO2FwAU6L03AvH9XYoMnpZVLtVRhPNTFG").roles("Student").and()
				.withUser("Kumar").password("$2a$12$65JFrX5St1VCzRUbYAmXhOlGum3Qgo381HnUOxsR3dEzxljAJxfh.")
				.roles("Trainer").and().withUser("Karthi")
				.password("$2a$12$aedx/dB3Vq/PZYaP8Xc3dOei/bIgb/0/90JeOL99GiQBn78mZWjrC").roles("Manager");
	}

	@Bean
	public PasswordEncoder getPass() {
		return new BCryptPasswordEncoder(12);
	}

//	*********************************************
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/getManager").hasRole("Manager");
		http.authorizeRequests().antMatchers("/getTrainer").hasAnyRole("Trainer","Manager");
		http.authorizeRequests().antMatchers("/getStudent").permitAll().and().formLogin();
	}
}
