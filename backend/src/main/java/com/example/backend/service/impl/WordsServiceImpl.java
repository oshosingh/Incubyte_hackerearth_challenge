package com.example.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backend.model.WordModel;
import com.example.backend.repository.WordsRepository;
import com.example.backend.service.WordsService;

@Service
public class WordsServiceImpl implements WordsService{
	
	@Autowired
	private WordsRepository wordsRepository;

	@Override
	public ResponseEntity<Object> addWord(String word) {
		WordModel newWord = new WordModel();
		newWord.setWordId(wordsRepository.count()+1);
		newWord.setWord(word);
		
		wordsRepository.saveAndFlush(newWord);
		return ResponseEntity.ok().body("Word added");
	}

	@Override
	public ResponseEntity<Object> getWords() {
		return ResponseEntity.ok().body(wordsRepository.findAll());
	}

	@Override
	public ResponseEntity<Object> updateWord(Long wordId, String newWord) {
		WordModel currentWordInDb = wordsRepository.findByWordId(wordId);
		if(currentWordInDb == null) {
			return ResponseEntity.badRequest().body("Invalid word id");
		}
		wordsRepository.updateWord(wordId, newWord);
		return ResponseEntity.ok().body("Record Updated");
	}
}
