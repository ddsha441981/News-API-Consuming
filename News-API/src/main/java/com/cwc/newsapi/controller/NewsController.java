package com.cwc.newsapi.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cwc.newsapi.model.NewsCategoryResponse;
import com.cwc.newsapi.model.NewsResponse;
import com.cwc.newsapi.service.NewsService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/news")
@CrossOrigin(origins = "*")//http://127.0.0.1:5500
public class NewsController {

	private static Logger log = LoggerFactory.getLogger(NewsController.class);

	@Autowired
	private NewsService newsService;

	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<NewsResponse>> searchNewsByKeyword(@PathVariable("keyword") String keyword) {
		List<NewsResponse> searchEverythingNews = this.newsService.searchEverythingNews(keyword);
		return new ResponseEntity<List<NewsResponse>>(searchEverythingNews, HttpStatus.OK);
	}

	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<NewsCategoryResponse>> newsLoadingByCategory(@PathVariable("category") String category) {
		List<NewsCategoryResponse> searchEverythingNews = this.newsService.loadNewsByCategory(category);
		return new ResponseEntity<List<NewsCategoryResponse>>(searchEverythingNews, HttpStatus.OK);
	}

	@GetMapping("/popularity")
	public ResponseEntity<List<NewsResponse>> popularNews(@PathParam("query") String query,
			@PathParam("from") String from, @PathParam("to") String to, @PathParam("sortBy") String sortBy) {
		System.out.println(query);
		List<NewsResponse> searchEverythingNews = this.newsService.loadEverythingPopularity(query, from, to, sortBy);
		return new ResponseEntity<List<NewsResponse>>(searchEverythingNews, HttpStatus.OK);
	}

	@GetMapping("/country/{country}")
	public ResponseEntity<List<NewsResponse>> countryWiseNews(@PathVariable("country") String country) {
		List<NewsResponse> searchEverythingNews = this.newsService.loadNewsContryWise(country);
		return new ResponseEntity<List<NewsResponse>>(searchEverythingNews, HttpStatus.OK);
	}

	@GetMapping("/headline/{query}")
	public ResponseEntity<List<NewsResponse>> searchTopHeadLinesNews(@PathVariable("query") String query) {
		List<NewsResponse> searchEverythingNews = this.newsService.searchTopHeadLines(query);
		return new ResponseEntity<List<NewsResponse>>(searchEverythingNews, HttpStatus.OK);
	}

	@GetMapping("/sources")
	public ResponseEntity<List<NewsCategoryResponse>> sourcesNews() {
		List<NewsCategoryResponse> searchEverythingNews = this.newsService.sourcesNews();
		return new ResponseEntity<List<NewsCategoryResponse>>(searchEverythingNews, HttpStatus.OK);
	}

	@GetMapping("/sources/{country}")
	public ResponseEntity<List<NewsCategoryResponse>> countrySourcesNews(@PathVariable("country") String country) {
		List<NewsCategoryResponse> searchEverythingNews = this.newsService.countrySourcesNews(country);
		return new ResponseEntity<List<NewsCategoryResponse>>(searchEverythingNews, HttpStatus.OK);
	}

	@RequestMapping(value = "/testAsynch/{keyword}", method = RequestMethod.GET)
	public String testAsynch(@PathVariable("keyword") String keyword) throws InterruptedException, ExecutionException {

		log.info("testAsynch Start");

		CompletableFuture<List<NewsResponse>> searchEverythingNews = this.newsService.asyncSearchEverythingNews(keyword);
		String newsCate = "Sports";
		CompletableFuture<List<NewsCategoryResponse>> loadNewsByCategory = this.newsService.asyncLoadNewsByCategory(newsCate);
		String countrySource = "in";
		CompletableFuture<List<NewsCategoryResponse>> asyncCountrySourcesNews = this.newsService.asyncCountrySourcesNews(countrySource);
		// Wait until they are all done
		CompletableFuture.allOf(searchEverythingNews,loadNewsByCategory,asyncCountrySourcesNews).join();
		
//		CompletableFuture<CompletableFuture<List<NewsResponse>>> completedFuture = 

		
		log.info("News Data --> " + searchEverythingNews.get());
		log.info("News Category Data --> " + loadNewsByCategory.get());
		log.info("News Country wise Data --> " + asyncCountrySourcesNews.get());
		
//		
		return "data fetched successfully";
	}

}
