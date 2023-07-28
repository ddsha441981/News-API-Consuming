package com.cwc.newsapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cwc.newsapi.model.NewsCategoryResponse;
import com.cwc.newsapi.model.NewsResponse;
import com.cwc.newsapi.service.NewsService;

import jakarta.websocket.server.PathParam;

@RestController
//@CrossOrigin
//@RequestMapping("/news/ui")
public class NewsControllerUI {
	
	@Autowired
	private NewsService newsService;

	@GetMapping("/home")
	public String homePage() {
		return "index";
	}


	@RequestMapping(value = "/category/{category}",
			method = RequestMethod.GET,
			consumes = MediaType.ALL_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<NewsCategoryResponse> newsLoadingByCategory(@PathVariable("category") String category) {
		System.out.println("Method calling............." + category);
		List<NewsCategoryResponse> searchEverythingNews = this.newsService.loadNewsByCategory(category);
		System.out.println(searchEverythingNews.toString());
		return searchEverythingNews;
	}

	@RequestMapping(value = "/popularity", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<NewsResponse> popularNews(@PathParam("query") String query,
			@PathParam("from") String from, @PathParam("to") String to, @PathParam("sortBy") String sortBy) {
		List<NewsResponse> searchEverythingNews = this.newsService.loadEverythingPopularity(query, from, to, sortBy);
		return searchEverythingNews;
	}

	@RequestMapping(value = "/country/{country}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<NewsResponse> countryWiseNews(@PathVariable("country") String country) {
		List<NewsResponse> searchEverythingNews = this.newsService.loadNewsContryWise(country);
		return searchEverythingNews;
	}
	
	@RequestMapping(value = "/headline/{query}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<NewsResponse> searchTopHeadLinesNews(@PathVariable("query") String query){
		List<NewsResponse> searchEverythingNews = this.newsService.searchTopHeadLines(query);
		return searchEverythingNews;
	}
	
	
	@RequestMapping(value = "/sources", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<NewsCategoryResponse> sourcesNews(){
		List<NewsCategoryResponse> searchEverythingNews = this.newsService.sourcesNews();
		return searchEverythingNews;
	}
	
	@RequestMapping(value = "/sources/{country}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<NewsCategoryResponse> countrySourcesNews(@PathVariable("country") String country){
		List<NewsCategoryResponse> searchEverythingNews = this.newsService.countrySourcesNews(country);
		return searchEverythingNews;
	}
	
	

}
