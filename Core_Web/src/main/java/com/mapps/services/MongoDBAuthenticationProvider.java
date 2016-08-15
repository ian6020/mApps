package com.mapps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mapps.dao.base.UserDAO;
import com.mapps.exception.ServiceException;
import com.mapps.utilities.Code;
import com.mapps.utilities.MCrypt;
import com.mapps.utilities.Status;

@Service
public class MongoDBAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private UserDAO userRepo;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
	}

	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken auth)
			throws AuthenticationException {
		UserDetails loginUser;
		
		try {
			com.mapps.models.base.User client = userRepo.findByUsername(username);
			logger.debug(client.toString());
			
			if(!MCrypt.check((String) auth.getCredentials(), client.getPassword()))
				throw new ServiceException(Status.AUTH_FAIL, Code.INVALID);
			
			loginUser = new User(client.getUsername(), client.getPassword(), client.getRole());
		} catch (Exception repositoryProblem) {
			throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
		}
	
		return loginUser;
	}

}
