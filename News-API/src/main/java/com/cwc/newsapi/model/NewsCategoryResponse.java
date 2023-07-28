package com.cwc.newsapi.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class NewsCategoryResponse {

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("sources")
	private ArrayList<NewsCategoryRequest> sources;
}
