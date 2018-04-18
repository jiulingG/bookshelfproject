package com.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private String title;
    private String author;
    private String publishingDate;
    private Integer isbn;
    @JsonCreator
    public Book(@JsonProperty("title")String title,
                @JsonProperty("author")String author,
                @JsonProperty("publishingDate") String publishingDate,
                @JsonProperty("isbn") Integer isbn) {
        this.title = title;
        this.author = author;
        this.publishingDate = publishingDate;
        this.isbn = isbn;
    }
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }
    @JsonProperty("publishingDate")
    public String getPublishingDate() {
        return publishingDate;
    }
    @JsonProperty("isbn")
    public Integer getIsbn() {
        return isbn;
    }
}
