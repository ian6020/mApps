package com.mapps.repositories.base;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mapps.models.base.Organization;

public interface OrganizationRepository extends MongoRepository<Organization, String> {
	
	Organization findByName(String name);
	List<Organization> findByNameContainingIgnoreCase(String name);
	
}
