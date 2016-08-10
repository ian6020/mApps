package com.mapps.dao.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapps.exception.ApplicationException;
import com.mapps.exception.ServiceException;
import com.mapps.models.base.Organization;
import com.mapps.repositories.base.OrganizationRepository;
import com.mapps.utilities.Code;
import com.mapps.utilities.Status;

@Service
public class OrganizationDAO extends BaseDAO {

	@Autowired
	private OrganizationRepository repo;
	
	@Override
	public List<?> findAll() {
		return repo.findAll();
	}
	
	@Override
	public Object save(Object entity, String description) {
		if(entity instanceof Organization) {
			Organization object = repo.save((Organization) entity);
			if(description != null) 
				createHistory(object.getId(), object.getUpdateBy(), description);
			return object;
		}
		else throw new ServiceException(Status.FAILED, Code.INVALID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<?> save(Iterable<?> entities, String description) {
		Iterable<?> object = repo.save((Iterable<? extends Organization>) entities);
		for( Organization one : (List<Organization>) object)
			createHistory(one.getId(), one.getUpdateBy(), description);
		return object;
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public void delete(Object entity) {
		repo.delete((Organization) entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Iterable<?> entities) {
		repo.delete((Iterable<? extends Organization>)entities);

	}

	@Override
	public void deleteAll() {
		repo.deleteAll();

	}

	public Object findOne(String id) {
		return (Organization) repo.findOne(id);
	}

	public boolean exists(String id) {
		return repo.exists(id);
	}

	public void delete(String id) {
		repo.delete(id);
	}
	
	public Organization findByName(String name) {
		return repo.findByName(name);
	}
	
	public List<Organization> findByNameLike(String name) {
		return repo.findByNameContainingIgnoreCase(name);
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
