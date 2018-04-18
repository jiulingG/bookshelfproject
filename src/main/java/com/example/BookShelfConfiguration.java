package com.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.dropwizard.Configuration;

@JsonDeserialize
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookShelfConfiguration extends Configuration {
    private BookShelf bookShelf;

    @JsonCreator
    public BookShelfConfiguration(@JsonProperty("bookshelf") BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    @JsonProperty
    public BookShelf getBookShelf() {
        return bookShelf;
    }

}
