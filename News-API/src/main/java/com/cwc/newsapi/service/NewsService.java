package com.cwc.newsapi.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.cwc.newsapi.model.NewsCategoryResponse;
import com.cwc.newsapi.model.NewsResponse;

public interface NewsService {

	public List<NewsResponse> searchEverythingNews(String keyword);

	public List<NewsCategoryResponse> loadNewsByCategory(String category);

	public List<NewsResponse> loadEverythingPopularity(String query, String from, String to, String sortBy);

	public List<NewsResponse> loadNewsContryWise(String country);

	public List<NewsResponse> searchTopHeadLines(String query);

	public List<NewsCategoryResponse> sourcesNews();

	public List<NewsCategoryResponse> countrySourcesNews(String country);

	// Async Methods

	public CompletableFuture<List<NewsResponse>> asyncSearchEverythingNews(String keyword)throws InterruptedException;

	
	  public CompletableFuture<List<NewsCategoryResponse>>
	  asyncLoadNewsByCategory(String category);
	  
	  public CompletableFuture<List<NewsResponse>>
	  asyncLoadEverythingPopularity(String query, String from, String to,String
	  sortBy);
	  
	  public CompletableFuture<List<NewsResponse>> asyncLoadNewsContryWise(String
	  country);
	  
	  public CompletableFuture<List<NewsResponse>> asyncSearchTopHeadLines(String
	  query);
	  
	  public CompletableFuture<List<NewsCategoryResponse>> asyncSourcesNews();
	  
	  public CompletableFuture<List<NewsCategoryResponse>>
	  asyncCountrySourcesNews(String country);
	 }
