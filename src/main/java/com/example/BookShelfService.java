package com.example;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookShelfService {
    private final BookShelfConfiguration bookShelfConfiguration;
    private final BookRepository bookRepository;

    @Inject
    public BookShelfService(BookShelfConfiguration bookShelfConfiguration,
                            BookRepository bookRepository) {
        this.bookShelfConfiguration = bookShelfConfiguration;
        this.bookRepository = bookRepository;
    }
    public List<Book> getUpdatedBooks(){
        List<Book> updatedbook = Stream.concat(bookShelfConfiguration.getBookShelf().getBooks().stream(),
                bookRepository.getBooks().values().stream())
                .collect(Collectors.toList());
        return updatedbook;

    }
    public BookShelf getUpdatedBookShelf(){
        List<Book> updatedBooks = getUpdatedBooks();
        List<Trophy> updatedTrophies = bookShelfConfiguration.getBookShelf().getTrophies();
        Stereo updatedStereo = bookShelfConfiguration.getBookShelf().getStereo();
        return new BookShelf(updatedBooks, updatedTrophies, updatedStereo);
    }

    public List<Book> getBook(String bookName) {
        return Stream.concat(bookShelfConfiguration.getBookShelf().getBooks().stream(),
                bookRepository.getBooks().values().stream())
                .filter(b -> b.getTitle().equalsIgnoreCase(bookName))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByAuthor(String author) {
        return Stream.concat(bookShelfConfiguration.getBookShelf().getBooks().stream(),
                bookRepository.getBooks().values().stream())
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public void putBook(Book book) {
        bookRepository.addBook(book);
    }
    public void postBookbyisbn( Book book) {
        bookRepository.addBook(book);
    }


    public Book getBookbyIsbn(Integer isbn) {
//        Book book = bookShelfConfiguration.getBookShelf()
//                .getBooks()
//                .stream()
//                .filter(b -> b.getIsbn().equals(isbn))
//                .findFirst()
//                .orElse(null);
//
//        if (book == null) {
//            bookRepository.getBooks()
//                    .get(isbn);
//        }
//
//        return book;

        return Stream.concat(bookShelfConfiguration.getBookShelf().getBooks().stream(),
                bookRepository.getBooks().values().stream())
                .filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
    }
}
