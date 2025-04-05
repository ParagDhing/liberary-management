package com.microservice.liberary_management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.liberary_management.model.Liberary;

@Repository
public interface LiberaryRepository extends MongoRepository<Liberary, Long> {

	List<Liberary> findByIssuerId(int issuerId);
	
	Optional<Liberary> findTopByOrderByRecordIdDesc();
}
