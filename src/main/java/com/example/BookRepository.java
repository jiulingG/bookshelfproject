package com.example;

import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class BookRepository implements RepositoryInterface {
    private final Map<Integer, Book> books;

    public BookRepository() {
        this.books = new HashMap<>();
    }

    @Override
    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Book is exist");
        }
        books.put(book.getIsbn(), book);
    }

    @Override
    public Map<Integer, Book> getBooks() {
        return books;
    }

}
