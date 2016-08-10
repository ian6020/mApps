package com.mapps.repositories.base;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mapps.models.base.History;

public interface HistoryRepository extends MongoRepository<History, String> {
	
	Page<History> findByEntityOrderByCreateDtDesc(Long entity, Pageable pageable);
	List<History> findByEntityOrderByCreateDtDesc(Long entity);
}
