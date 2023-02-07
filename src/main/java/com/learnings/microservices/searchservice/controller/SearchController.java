/**
 * 
 */
package com.learnings.microservices.searchservice.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learnings.microservices.searchservice.request.SearchRequest;
import com.learnings.microservices.searchservice.service.SearchService;

/**
 * @author ankitarora
 *
 */
@RestController
@RequestMapping("/api/v1/search")
public class SearchController {
	
	@Autowired
	SearchService searchService;

	@RequestMapping(method = RequestMethod.POST, value = "/shows")
	public  ResponseEntity<List<Map<String, Object>>> searchShows(@RequestBody SearchRequest searchRequest){
		return new ResponseEntity<List<Map<String, Object>>>(searchService.searchFromMockData(searchRequest), HttpStatus.OK);
		
	}
}
