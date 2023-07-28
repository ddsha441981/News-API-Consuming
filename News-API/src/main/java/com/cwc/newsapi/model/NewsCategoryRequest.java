package com.cwc.newsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NewsCategoryRequest {

	@JsonProperty("id")
	private  String id;
	@JsonProperty("name")
	private  String name;
	@JsonProperty("description")
	private  String description;
	@JsonProperty("url")
	private  String url;
	@JsonProperty("category")
	private  String category;
	@JsonProperty("language")
	private  String language;
	@JsonProperty("country")
	private  String country;
}
