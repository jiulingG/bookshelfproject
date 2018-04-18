package com.example;

import com.google.inject.Singleton;
import com.google.inject.spi.Message;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class BookRepository {

    private final Map<Integer, Book> books;

    public BookRepository() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        if(!books.containsKey(book.getIsbn())) {
            books.put(book.getIsbn(), book);
        }
        else if(books.containsKey(book.getIsbn())){
            throw new IllegalArgumentException("The book is exist");

        }
    }


    public Map<Integer, Book> getBooks() {
        return books;
    }
}
