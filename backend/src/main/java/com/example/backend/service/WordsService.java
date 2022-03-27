package com.example.backend.service;

import org.springframework.http.ResponseEntity;

public interface WordsService {
	ResponseEntity<Object> addWord(String word);
	ResponseEntity<Object> getWords();
	ResponseEntity<Object> updateWord(Long wordId, String newWord);
}
