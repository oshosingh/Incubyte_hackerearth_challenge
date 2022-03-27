package com.example.backend.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.model.WordModel;

public interface WordsRepository extends JpaRepository<WordModel, Integer>{

	WordModel findByWordId(Long wordId);
	
	@Query("update WordModel w set w.word =:newWord where w.wordId=:wordId")
	@Modifying
	@Transactional
	void updateWord(Long wordId, String newWord);

	@Query("delete from WordModel w where w.wordId=:wordId")
	@Modifying
	@Transactional
	void deleteByWordId(Long wordId);

}
