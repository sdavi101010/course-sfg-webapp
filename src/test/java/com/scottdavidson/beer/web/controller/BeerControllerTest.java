package com.scottdavidson.beer.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scottdavidson.beer.web.dto.Beer;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void getBeerById() throws Exception {
		mockMvc.perform(get("/api/v1/beers/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	void saveNewBeer() throws Exception {
		Beer beer = Beer.builder().id(UUID.randomUUID()).build();
		String beerDtoJson = objectMapper.writeValueAsString(beer);

		mockMvc.perform(post("/api/v1/beers").contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
				.andExpect(status().isCreated());

	}
	
	@Test 
	void updateBeerById() throws Exception {
		Beer beer = Beer.builder().build();
		String beerDtoJson = objectMapper.writeValueAsString(beer);
		
		mockMvc.perform(put("/api/v1/beers/"  + UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
		.andExpect(status().isNoContent());

	}

	@Test 
	void deleteBeerById() throws Exception {
		
		mockMvc.perform(delete("/api/v1/beers/"  + UUID.randomUUID().toString())).andExpect(status().isNoContent());

	}

}
