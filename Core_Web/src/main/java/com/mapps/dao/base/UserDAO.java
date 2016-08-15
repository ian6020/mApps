package com.mapps.dao.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapps.exception.ApplicationException;
import com.mapps.exception.ServiceException;
import com.mapps.models.base.Organization;
import com.mapps.models.base.User;
import com.mapps.repositories.base.UserRepository;
import com.mapps.utilities.Code;
import com.mapps.utilities.Status;

@Service
public class UserDAO extends BaseDAO {

	@Autowired
	private UserRepository repo;
	
	@Override
	public List<?> findAll() {
		return repo.findAll();
	}
	
	@Override
	@Transactional
	public Object save(Object entity, String description) {
		if(entity instanceof User) {
			User object = repo.save((User) entity); 
			createHistory(object.getId(), object.getUpdateBy(), description);
			return object;
		}
		else throw new ServiceException(Status.ERROR, Code.INVALID);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Iterable<?> save(Iterable<?> entities, String description) {
		Iterable<?> object = repo.save((Iterable<? extends User>) entities);
		for( User one : (List<User>) object)
			createHistory(one.getId(), one.getUpdateBy(), description);
		return object;
	}

	public boolean exists(Long id) {
		return repo.exists(id);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Transactional
	public void delete(Long id) {
		repo.delete(id);
	}

	@Override
	@Transactional
	public void delete(Object entity) {
		repo.delete((User) entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void delete(Iterable<?> entities) {
		repo.delete((Iterable<? extends User>)entities);
	}

	@Override
	public void deleteAll() throws ServiceException {
		//throw new ServiceException(Status.OPERATION_ERR, Code.SYSTEM_ERROR);
		repo.deleteAll();
	}
	
	public Page<User> findByFirstname(String firstname, Pageable pageable) {
		return repo.findByFirstnameLike(firstname.toUpperCase(), pageable);
	}
	
	public Page<User> findByLastname(String lastname, Pageable pageable) {
		return repo.findByLastnameLike(lastname.toUpperCase(), pageable);
	}
	
	public Page<User> findByFirstnameAndLastname(String firstname, String lastname, Pageable pageable) {
		return repo.findByFirstnameLikeAndLastnameLike(firstname, lastname, pageable);
	}
	
	public User findByUsername(String username) {
		return repo.findByUsername(username);
	}
	
	public User findByUsernameAndOrganization(String username, Organization org) {
		return repo.findByUsernameAndOrganization(username, org);
	}
	
	@Override
	public Object findOne(Object id) {
		if(id instanceof String)
			return findOne((String) id);
		else throw new ApplicationException(Status.ERROR);
	}

	@Override
	public boolean exists(Object id) {
		if(id instanceof String)
			return exists((String) id);
		else throw new ApplicationException(Status.ERROR);
	}
}
