package com.learnings.microservices.searchservice.service;

import java.util.List;
import java.util.Map;

import com.learnings.microservices.searchservice.request.SearchRequest;

public interface SearchService {


	List<Map<String, Object>> searchFromMockData(SearchRequest searchRequest);
	List<Map<String, Object>> searchFromElasticSearch(SearchRequest searchRequest);

}
