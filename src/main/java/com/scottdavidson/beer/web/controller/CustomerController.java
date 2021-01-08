package com.scottdavidson.beer.web.controller;

import java.net.URI;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.scottdavidson.beer.web.dto.Customer;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") UUID id) {

		return ResponseEntity.ok().body(Customer.builder().build());
	}

	@SuppressWarnings("rawtypes")
	@PostMapping()
	public ResponseEntity saveNewCustomer(@RequestBody Customer customer) {

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(customer.getId().toString()).toUri();

		return ResponseEntity.created(location).build();
	}

	@SuppressWarnings("rawtypes")
	@PutMapping("/{id}")
	public ResponseEntity updateCustomerById(@PathVariable("id") UUID id, @RequestBody Customer customer) {

		return ResponseEntity.noContent().build();
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity deleteCustomerById(@PathVariable("id") UUID id) {

		return ResponseEntity.noContent().build();
	}

}
