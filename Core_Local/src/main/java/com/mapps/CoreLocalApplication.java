package com.mapps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;

import com.mapps.dao.base.UserDAO;
import com.mapps.models.base.User;
import com.mapps.utilities.MCrypt;

@SpringBootApplication
public class CoreLocalApplication extends WebSecurityConfigurerAdapter
	implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(CoreLocalApplication.class);
	
	@Autowired
	UserDAO userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CoreLocalApplication.class, args);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
		.and().authorizeRequests().anyRequest().authenticated();
	}
	
	@Bean
	public HeaderHttpSessionStrategy sessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}

	@Override
	public void run(String... args) throws Exception {
		User admin = userRepo.findByUsername("admin");
		if(admin == null) 
			admin = (User) userRepo.save(
					new User("admin", null, "ADMIN", "ROOT", "admin@mApps.com"),
					"Adding Admin user for the first time");
		else logger.info("Found ADMIN user");
		
		logger.debug(admin.toString());
		
		boolean matched = MCrypt.check("password", admin.getPassword());
		logger.info("Password matched: " + matched);
		
	}
}
