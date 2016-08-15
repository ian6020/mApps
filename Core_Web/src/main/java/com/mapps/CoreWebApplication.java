package com.mapps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.mapps.services.MongoDBAuthenticationProvider;

@SpringBootApplication
public class CoreWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreWebApplication.class, args);
	}
	
	@Configuration
	@EnableGlobalMethodSecurity(securedEnabled = true)
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private MongoDBAuthenticationProvider authenticationProvider;
		
		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.httpBasic()
			.and().authorizeRequests().
				antMatchers("/index.html", "/home.html", "/login.html", "/").
				permitAll().anyRequest().authenticated()
			.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			;
		}
		
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.authenticationProvider(authenticationProvider);
		}
	}

}
