package com.cwc.newsapi.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cwc.newsapi.model.NewsCategoryResponse;
import com.cwc.newsapi.model.NewsResponse;
import com.cwc.newsapi.service.NewsService;

@Service
@PropertySource("apikey.properties")
public class NewServiceImpl implements NewsService {

	@Value("${api.key}")
	private String API_KEY;
	
	private static Logger log = LoggerFactory.getLogger(NewServiceImpl.class);

	@Autowired
	private WebClient.Builder webClient;

	@Override
	public List<NewsResponse> searchEverythingNews(String keyword) {
		// https://newsapi.org/v2/everything?q=apple&from=2023-07-17&to=2023-07-17&sortBy=popularity&apiKey=<YOUR-API-KEY-HERE>
		// https://newsapi.org/v2/everything?domains=techcrunch.com,thenextweb.com&apiKey=<YOUR-API-KEY-HERE>
		String url = "https://newsapi.org/v2/everything?q=" + keyword + "&apiKey=" + API_KEY;
		List<NewsResponse> list = this.webClient.build().get().uri(url).retrieve().bodyToFlux(NewsResponse.class)
				.collectList().block();

		return list;
	}
	
	@Override
	public List<NewsCategoryResponse> loadNewsByCategory(String category) {
		String url = "https://newsapi.org/v2/top-headlines/sources?category=" + category + "&apiKey=" + API_KEY;
		List<NewsCategoryResponse> list = this.webClient.build().get().uri(url).retrieve()
				.bodyToFlux(NewsCategoryResponse.class).collectList().block();
		return list;
	}

	@Override
	public List<NewsResponse> loadEverythingPopularity(String query, String from, String to, String sortBy) {
		String url = "https://newsapi.org/v2/everything?q="+query+"&from="+from+"&to="+to+"&sortBy="+sortBy+"&apiKey="+API_KEY;
		System.out.println(url);
		List<NewsResponse> list = this.webClient.build().get().uri(url).retrieve()
				.bodyToFlux(NewsResponse.class).collectList().block();
		return list;
	}
	
	@Override
	public List<NewsResponse> loadNewsContryWise(String country) {
		String url = "https://newsapi.org/v2/top-headlines?country="+country+"&apiKey="+API_KEY;
		List<NewsResponse> list = this.webClient.build().get().uri(url).retrieve()
				.bodyToFlux(NewsResponse.class).collectList().block();
		return list;
	}

	@Override
	public List<NewsResponse> searchTopHeadLines(String query) {
		String url = "https://newsapi.org/v2/top-headlines?q="+query+"&apiKey="+API_KEY;
		List<NewsResponse> list = this.webClient.build().get().uri(url).retrieve()
				.bodyToFlux(NewsResponse.class).collectList().block();
		return list;
	}

	@Override
	public List<NewsCategoryResponse> sourcesNews() {
		String url = "https://newsapi.org/v2/top-headlines/sources?apiKey="+API_KEY;
		List<NewsCategoryResponse> list = this.webClient.build().get().uri(url).retrieve()
				.bodyToFlux(NewsCategoryResponse.class).collectList().block();
		return list;
	}

	@Override
	public List<NewsCategoryResponse> countrySourcesNews(String country) {
		String url = "https://newsapi.org/v2/top-headlines/sources?country="+country+"&apiKey="+API_KEY;
		List<NewsCategoryResponse> list = this.webClient.build().get().uri(url).retrieve()
				.bodyToFlux(NewsCategoryResponse.class).collectList().block();
		return list;
	}

	
	@Async
	@Override
	public CompletableFuture<List<NewsResponse>> asyncSearchEverythingNews(String keyword) throws InterruptedException {
		log.info("asyncSearchEverythingNews starts");
		String url = "https://newsapi.org/v2/everything?q=" + keyword + "&apiKey=" + API_KEY;
		List<NewsResponse> list = this.webClient.build().get().uri(url).retrieve().bodyToFlux(NewsResponse.class)
				.collectList().block();
		log.info("News Response, {}", list);
	    Thread.sleep(1000L);  //Intentional delay
	    log.info("news fetch completed");
		return CompletableFuture.completedFuture(list);
	}

	
	  @Async
	  
	  @Override public CompletableFuture<List<NewsCategoryResponse>>asyncLoadNewsByCategory(String category) { 
		  String url =
	  "https://newsapi.org/v2/top-headlines/sources?category=" + category +
	  "&apiKey=" + API_KEY; List<NewsCategoryResponse> list =
	  this.webClient.build().get().uri(url).retrieve()
	  .bodyToFlux(NewsCategoryResponse.class).collectList().block(); return
	  CompletableFuture.completedFuture(list); }
	  
	  @Async
	  
	  @Override public CompletableFuture<List<NewsResponse>>
	  asyncLoadEverythingPopularity(String query, String from, String to, String
	  sortBy) { String url =
	  "https://newsapi.org/v2/everything?q="+query+"&from="+from+"&to="+to+
	  "&sortBy="+sortBy+"&apiKey="+API_KEY; System.out.println(url);
	  List<NewsResponse> list = this.webClient.build().get().uri(url).retrieve()
	  .bodyToFlux(NewsResponse.class).collectList().block(); return
	  CompletableFuture.completedFuture(list); }
	  
	  @Async
	  
	  @Override public CompletableFuture<List<NewsResponse>>
	  asyncLoadNewsContryWise(String country) { String url =
	  "https://newsapi.org/v2/top-headlines?country="+country+"&apiKey="+API_KEY;
	  List<NewsResponse> list = this.webClient.build().get().uri(url).retrieve()
	  .bodyToFlux(NewsResponse.class).collectList().block(); return
	  CompletableFuture.completedFuture(list); }
	  
	  @Async
	  
	  @Override public CompletableFuture<List<NewsResponse>>
	  asyncSearchTopHeadLines(String query) { String url =
	  "https://newsapi.org/v2/top-headlines?q="+query+"&apiKey="+API_KEY;
	  List<NewsResponse> list = this.webClient.build().get().uri(url).retrieve()
	  .bodyToFlux(NewsResponse.class).collectList().block(); return
	  CompletableFuture.completedFuture(list); }
	  
	  @Async
	  
	  @Override public CompletableFuture<List<NewsCategoryResponse>>
	  asyncSourcesNews() { String url =
	  "https://newsapi.org/v2/top-headlines/sources?apiKey="+API_KEY;
	  List<NewsCategoryResponse> list =
	  this.webClient.build().get().uri(url).retrieve()
	  .bodyToFlux(NewsCategoryResponse.class).collectList().block(); return
	  CompletableFuture.completedFuture(list); }
	  
	  @Async
	  
	  @Override public CompletableFuture<List<NewsCategoryResponse>>
	  asyncCountrySourcesNews(String country) { String url =
	  "https://newsapi.org/v2/top-headlines/sources?country="+country+"&apiKey="+
	  API_KEY; List<NewsCategoryResponse> list =
	  this.webClient.build().get().uri(url).retrieve()
	  .bodyToFlux(NewsCategoryResponse.class).collectList().block(); return
	  CompletableFuture.completedFuture(list); }
	 

	

}
