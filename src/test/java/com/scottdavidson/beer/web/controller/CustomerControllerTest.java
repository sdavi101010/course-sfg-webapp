package com.scottdavidson.beer.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scottdavidson.beer.web.dto.Customer;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void getCustomerById() throws Exception {
		mockMvc.perform(get("/api/v1/customers/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	void saveNewCustomer() throws Exception {
		Customer customer = Customer.builder().id(UUID.randomUUID()).build();
		String customerDtoJson = objectMapper.writeValueAsString(customer);

		mockMvc.perform(post("/api/v1/customers").contentType(MediaType.APPLICATION_JSON).content(customerDtoJson))
				.andExpect(status().isCreated());

	}
	
	@Test 
	void updateCustomerById() throws Exception {
		Customer customer = Customer.builder().build();
		String customerDtoJson = objectMapper.writeValueAsString(customer);
		
		mockMvc.perform(put("/api/v1/customers/"  + UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON).content(customerDtoJson))
		.andExpect(status().isNoContent());

	}

	@Test 
	void deleteCustomerById() throws Exception {
		
		mockMvc.perform(delete("/api/v1/customers/"  + UUID.randomUUID().toString())).andExpect(status().isNoContent());

	}

}
