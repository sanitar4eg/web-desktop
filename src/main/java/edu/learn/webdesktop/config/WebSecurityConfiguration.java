package edu.learn.webdesktop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.learn.webdesktop.controller.WelcomeController;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final Logger logger = LoggerFactory
			.getLogger(WelcomeController.class);
	
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;
 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);		//.passwordEncoder(passwordEncoder());
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
    	logger.warn("Subclassed this will potentially override subclass configure(HttpSecurity).");

	    http
	    .authorizeRequests().antMatchers("/","registration").permitAll()
	    .anyRequest()//.antMatchers("/desktop")
		.access("hasRole('USER')").and().formLogin()
		//.loginPage("/login").failureUrl("/login?error")
		.usernameParameter("username")
		.passwordParameter("password")
		.and().logout().logoutSuccessUrl("/")
		.and().csrf();
		//.and().exceptionHandling().accessDeniedPage("/403");
	}
 
	/*
	 * 8bit BCrypt algorithm.
	 */
/*	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}*/
 
}
