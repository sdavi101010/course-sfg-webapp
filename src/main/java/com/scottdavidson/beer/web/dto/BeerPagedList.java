package com.scottdavidson.beer.web.dto;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class BeerPagedList extends PageImpl<Beer> {

	private static final long serialVersionUID = -2426511425658696298L;

	public BeerPagedList(List<Beer> content, Pageable pageable, long total) {
		super(content, pageable, total);
		// TODO Auto-generated constructor stub
	}

	public BeerPagedList(List<Beer> content) {
		super(content);
		// TODO Auto-generated constructor stub
	}

}
