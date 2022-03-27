package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.service.impl.WordsServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WordsController {
	
	@Autowired
	private WordsServiceImpl wordsService;
	
	// Save A New Word
	@PostMapping("/api/add/word")
	ResponseEntity<Object> addWord(@RequestParam String word){
		return wordsService.addWord(word);
	}
	
	// Get All Words in DB
	@GetMapping("/api/get/words")
	ResponseEntity<Object> getAllWords(){
		return wordsService.getWords();
	}
	
	// Update an existing word
	@PutMapping("/api/update/word")
	ResponseEntity<Object> updateWord(@RequestParam Long wordId, @RequestParam String newWord){
		return wordsService.updateWord(wordId, newWord);
	}
}
