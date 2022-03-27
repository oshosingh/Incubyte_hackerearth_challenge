package com.example.backend;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.backend.controller.WordsController;
import com.example.backend.model.WordModel;
import com.example.backend.service.impl.WordsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(WordsController.class)
public class WordsControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private WordsServiceImpl wordsServiceImp;;
	
	private WordModel firstWord = new WordModel(1L, "hello");
	private WordModel secondWord = new WordModel(2L, "world");
	
	@Test
	public void getAllWords() throws Exception{
		List<WordModel> allWords = new ArrayList<>();
		allWords.add(firstWord);
		allWords.add(secondWord);
		
		ResponseEntity<Object> allWordsResp = ResponseEntity.ok().body(allWords);
		
		Mockito.when(wordsServiceImp.getWords()).thenReturn(allWordsResp);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/get/words").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[1].word", is("world")));
	}
	
	@Test
	public void addWord() throws Exception {
		String word = "all";
		ResponseEntity<Object> addWordResp = ResponseEntity.ok().body("Word added");
		Mockito.when(wordsServiceImp.addWord(word)).thenReturn(addWordResp);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/add/word?word="+word);
		
		mockMvc.perform(mockRequest).andExpect(status().isOk());
		
	}
	
	@Test
	public void updateWord() throws Exception {
		String word = "all";
		Long wordId = 1L;
		
		ResponseEntity<Object> addWordResp = ResponseEntity.ok().body("Record Updated");
		Mockito.when(wordsServiceImp.updateWord(wordId, word)).thenReturn(addWordResp);
		
		String updateUrl = "/api/update/word?wordId="+wordId+"&newWord="+word;
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put(updateUrl);
		
		mockMvc.perform(mockRequest).andExpect(status().isOk());
		
	}
	
	@Test
	public void updateWordWithInvalidId() throws Exception {
		String word = "all";
		Long wordId = 5L;  // Invalid wordId
		
		ResponseEntity<Object> addWordResp = ResponseEntity.badRequest().body("Invalid word id");
		Mockito.when(wordsServiceImp.updateWord(wordId, word)).thenReturn(addWordResp);
		
		String updateUrl = "/api/update/word?wordId="+wordId+"&newWord="+word;
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put(updateUrl);
		
		mockMvc.perform(mockRequest).andExpect(status().isBadRequest());
		
	}
}

