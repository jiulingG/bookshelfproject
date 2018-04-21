package com.example;

import java.util.Map;

public interface RepositoryInterface {
    void addBook(Book book);

    Map<Integer, Book> getBooks();
}
