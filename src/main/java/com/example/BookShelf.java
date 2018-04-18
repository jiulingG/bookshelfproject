package com.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonDeserialize
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookShelf {
    private final List<Book> books;
    private final List<Trophy> trophies;
    private final Stereo stereo;


    @JsonCreator
    public BookShelf(@JsonProperty("books") List<Book> books,
                     @JsonProperty("trophies") List<Trophy> trophies,
                     @JsonProperty("stereo") Stereo stereo) {
        this.books = books;
        this.trophies = trophies;
        this.stereo = stereo;
    }

    @JsonProperty("books")
    public List<Book> getBooks() {
        return books;
    }

    @JsonProperty("trophies")
    public List<Trophy> getTrophies() {
        return trophies;
    }

    @JsonProperty("stereo")
    public Stereo getStereo() {
        return stereo;
    }
}
