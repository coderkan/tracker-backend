package com.example.eko.ekoapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.eko.ekoapi.model.User;
import com.example.eko.ekoapi.repository.UserRepository;

@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter{

	@Autowired
	UserRepository userRepository;
	
	  @Override
	  public void init(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService());
	  }

	  @Bean
	  UserDetailsService userDetailsService() {
	    return new UserDetailsService() {

	      @Override
	      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByName(username);
	        if(user != null) {
	        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), true, true, true, true,
	                AuthorityUtils.createAuthorityList("USER"));
	        } else {
	          throw new UsernameNotFoundException("could not find the user '"
	                  + username + "'");
	        }
	      }
	      
	    };
	  }
	  
	  @Bean
	  public PasswordEncoder encoder() {
		  return new BCryptPasswordEncoder(11);
	  }
}
