package com.shiva.app.controller;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String>{

	public Hospital findByName(String name);

	public Optional<Hospital> findById(String id);
	public void deleteByname(String name);
	public Hospital save(Hospital hospital);
	
}
