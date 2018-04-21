package com.example;

import com.google.inject.Inject;

import java.util.List;

public class SecondBookShelfService {
    private final BookShelfService bookShelfService;

    @Inject
    public SecondBookShelfService(BookShelfService bookShelfService) {
        this.bookShelfService = bookShelfService;
    }
    public BookShelfService getBookShelfService() {
        return bookShelfService;
    }

    public List<Book> getUpdatedBooks() {
        return bookShelfService.getUpdatedBooks();

    }
    public BookShelf getUpdatedBookShelf() {
        return bookShelfService.getUpdatedBookShelf();
    }
    public List<Book> getBook(String bookName) {
        return bookShelfService.getBook(bookName);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookShelfService.getBooksByAuthor(author);
    }

    public void putBook(Book book) {
        bookShelfService.putBook(book);
    }

    public void postBookbyisbn(Integer isbn, Book book) {
        bookShelfService.postBookbyisbn(isbn, book);
    }


    public Book getBookbyIsbn(Integer isbn) {

        return bookShelfService.getBookbyIsbn(isbn);

    }
}
