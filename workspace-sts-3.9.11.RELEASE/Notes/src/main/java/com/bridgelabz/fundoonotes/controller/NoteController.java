package com.bridgelabz.fundoonotes.controller;

import java.io.IOException;

import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.model.Label;
import com.bridgelabz.fundoonotes.model.Note;
import com.bridgelabz.fundoonotes.response.Response;
//import com.bridgelabz.fundoonotes.service.ElasticSearch;
import com.bridgelabz.fundoonotes.service.NoteService;
//import com.bridgelabz.fundoonotes.service.S3Bucket;


@RestController
@RequestMapping("/noteservice")
@CrossOrigin(allowedHeaders = "*", origins = "*",exposedHeaders = {"token"})
public class NoteController {

	@Autowired
	private NoteService noteService;

	/*
	 * @Autowired private ElasticSearch elasticService;
	 * 
	 * @Autowired private S3Bucket amazonService;
	 */
	@PostMapping("/createnote")
	public ResponseEntity<Response> createNote(@RequestBody NoteDto noteDto, @RequestHeader String token)
	{
		String message = noteService.createNotes(noteDto, token);
		Response response = new Response(200, message, null);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	
	@GetMapping("/getallnotes")
	public List<Note> getAllNotes(@RequestHeader String token) {
		List<Note> notes = noteService.getAllNotes(token);
		return notes;
	}

	
}
