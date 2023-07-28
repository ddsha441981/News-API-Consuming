package com.cwc.newsapi.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NewsResponse {

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("totalResults")
	private int totalResults;
	
	@JsonProperty("articles")
	private ArrayList<NewsRequest> articles;

}
