package com.cwc.newsapi.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NewsRequest {
	
	@JsonProperty("source") 
    private NewsSource newsSource;
	
    @JsonProperty("author")  
    private String author;
    
    @JsonProperty("title") 
    private String title;
   
    @JsonProperty("description") 
    private String description;
    
    @JsonProperty("url") 
    private String url;

    @JsonProperty("urlToImage") 
    private String urlToImage;
    
    @JsonProperty("publishedAt") 
    private Date publishedAt;
    
    @JsonProperty("content") 
    private String content;
}

