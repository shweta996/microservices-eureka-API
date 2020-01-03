package com.bridgelabz.fundoonotes.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.model.Label;

@Repository
public interface LabelRepository extends MongoRepository<Label,String> 
{
	Optional<Label>findByLabelId(String labelId);
	
}
