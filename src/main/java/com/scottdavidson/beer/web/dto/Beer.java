package com.scottdavidson.beer.web.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Beer {
	
	private UUID id;
	private Integer version; 
	private OffsetDateTime createdDate;
	private OffsetDateTime lastModifiedDate;
	private String name;
	private BeerStyle beerStyle;
	private BigDecimal price;
	private Long upc;
	private Integer quantityOnHand;

}
