package com.learnings.microservices.searchservice.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnings.microservices.searchservice.request.SearchRequest;

@Service
public class SearchServiceImpl implements SearchService {


	@Override
	public List<Map<String, Object>>  searchFromMockData(SearchRequest searchRequest) {
		
		System.out.println("searchRequest: " + searchRequest);
		Predicate<Map<String, Object>> searchByMoviePredicate = show -> show.get("movie").toString().toLowerCase().contains(searchRequest.getMovie().toLowerCase());
		Predicate<Map<String, Object>> searchByCityPredicate = show -> show.get("city").toString().toLowerCase().contains(searchRequest.getCity().toLowerCase());
		Predicate<Map<String, Object>> searchPredicate = searchByMoviePredicate.and(searchByCityPredicate);

		if(!searchRequest.getBookingDate().isBlank()) {
			Predicate<Map<String, Object>> searchByBookingDatePredicate = show -> (show.get("bookingDate").toString()).equalsIgnoreCase(searchRequest.getBookingDate());
			searchPredicate.and(searchByBookingDatePredicate);
		}
		System.out.println("searchPredicate: " + searchPredicate);
		List<Map<String, Object>> shows = getDataFromJson();
		
		List<Map<String, Object>> results = shows.stream().filter(searchPredicate).collect(Collectors.toList());

		return results;

	}

	private List<Map<String, Object>> getDataFromJson() {
		List<Map<String, Object>> shows = null;
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Map<String, Object>>> typeReference = new TypeReference<List<Map<String, Object>>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/data/shows.json");
		try {
			shows = mapper.readValue(inputStream, typeReference);
			
			System.out.println(shows);
		} catch (IOException e){
			System.out.println("Unable to parse shows: " + e.getMessage());
		}
		return shows;
	}


	@Override
	public List<Map<String, Object>> searchFromElasticSearch(SearchRequest searchRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
