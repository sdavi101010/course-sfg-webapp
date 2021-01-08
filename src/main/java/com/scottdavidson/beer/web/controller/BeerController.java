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

import com.scottdavidson.beer.web.dto.Beer;

@RestController
@RequestMapping("/api/v1/beers")
public class BeerController {

	@GetMapping("/{id}")
	public ResponseEntity<Beer> getBeerById(@PathVariable("id") UUID id) {

		return ResponseEntity.ok().body(Beer.builder().build());
	}

	@SuppressWarnings("rawtypes")
	@PostMapping()
	public ResponseEntity saveNewBeer(@RequestBody Beer beer) {

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(beer.getId().toString()).toUri();

		return ResponseEntity.created(location).build();
	}

	@SuppressWarnings("rawtypes")
	@PutMapping("/{id}")
	public ResponseEntity updateBeerById(@PathVariable("id") UUID id, @RequestBody Beer beer) {

		return ResponseEntity.noContent().build();
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity deleteBeerById(@PathVariable("id") UUID id) {

		return ResponseEntity.noContent().build();
	}

}
