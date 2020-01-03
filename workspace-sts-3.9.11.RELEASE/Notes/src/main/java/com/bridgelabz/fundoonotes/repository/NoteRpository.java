package com.bridgelabz.fundoonotes.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.model.Note;
@Repository
public interface NoteRpository extends MongoRepository<Note,String>  {
	Optional<Note> findByNoteId(String noteId);
	//Optional<Note> findByUserId(String userId);
	List<Note> findByuserId(String userId);
	
}
