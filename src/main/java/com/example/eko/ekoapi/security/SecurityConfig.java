package com.example.eko.ekoapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override 
	protected void configure(HttpSecurity http) throws Exception{
		
		//http.authorizeRequests().an.antMatchers("/demo/**").hasAnyRole("ADMIN","USER").and()
		//.httpBasic().and().logout().logoutUrl("/app-logout").logoutSuccessUrl("/app/login").and().csrf().disable();
		
		/*
		http.authorizeRequests().anyRequest().fullyAuthenticated().and()
		.httpBasic().and().logout().logoutUrl("/app-logout").logoutSuccessUrl("/app/login").and().csrf().disable();
		*/
		
		http
			.formLogin().loginPage("/app/login").permitAll()
			.and()
			.requestMatchers().antMatchers("/session")
			.and()
			.authorizeRequests().anyRequest().authenticated()
			.and()
			.csrf()
			.disable();
		
	}
}
