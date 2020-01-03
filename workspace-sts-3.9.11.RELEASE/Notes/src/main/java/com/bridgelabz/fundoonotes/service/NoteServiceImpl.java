package com.bridgelabz.fundoonotes.service;

import java.time.LocalDateTime;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
//import org.omg.CORBA.OMGVMCID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.amazonaws.jmespath.OpNotEquals;
import com.bridgelabz.fundoonotes.dto.NoteDto;
//import com.bridgelabz.fundoonotes.exception.LabelException;
import com.bridgelabz.fundoonotes.exception.NoteException;
//import com.bridgelabz.fundoonotes.exception.UserException;
import com.bridgelabz.fundoonotes.model.Label;
import com.bridgelabz.fundoonotes.model.Note;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.repository.LabelRepository;
import com.bridgelabz.fundoonotes.repository.NoteRpository;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.utility.TokenGenerator;

/**
 * @author:-shweta kale.
 * 
 *
 */

@SuppressWarnings("unused")
@Service("NoteService")
public class NoteServiceImpl implements NoteService {

	@Autowired
	private TokenGenerator tokenGenerator;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private NoteRpository noteRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LabelRepository labelRepository;

	/*
	 * @Autowired private ElasticSearch elasticSearch;
	 */

	/**
	 * description:-new note created into the database.
	 */

	@Override
	public String createNotes(NoteDto noteDto, String token) {
		String id = tokenGenerator.verifyToken(token);
		
			Note note = modelMapper.map(noteDto, Note.class);
			note.setCreationTime(LocalDateTime.now());
			note.setUpdatedTime(LocalDateTime.now());
			note.setUserId(id);
			noteRepository.save(note);
			return "new note created";

		} 

	

	
	/**
	 * @param token
	 * @return all notes from database.
	 */
	public List<Note> getAllNotes(String token) {
		String userId = tokenGenerator.verifyToken(token);
		
			List<Note> noteList = new ArrayList<Note>();
			List<Note> notes = noteRepository.findByuserId(userId);
			for (int i = 0; i < notes.size(); i++) {
				if (notes.get(i).isArchieve() != true && notes.get(i).isTrash() != true) {
					noteList.add(notes.get(i));
				}
			}
			return noteList;
		} 
	}

	
