package com.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class BookShelfServiceTest {

    @Test
    public void getUpdatedBooks() {
        BookShelfConfiguration bookShelfConfiguration = mock(BookShelfConfiguration.class);
        BookRepository bookRepository = mock(BookRepository.class);
        BookShelf bookShelf = mock(BookShelf.class);
        Map<Integer, Book> books = new HashMap<>();

        List<Book> bookList = Arrays.asList(
                new Book("book3", "bob", "2010-3-22", 14),
                new Book("book4", "Mick", "1990-3-09", 15));

        books.put(12, new Book("book1", "fiona", "2001-2-20", 12));
        books.put(13, new Book("book2", "fiona", "2001-2-20", 13));

        when(bookRepository.getBooks()).thenReturn(books);
        when(bookShelfConfiguration.getBookShelf()).thenReturn(bookShelf);
        when(bookShelf.getBooks()).thenReturn(bookList);

        BookShelfService bookShelfService = new BookShelfService(bookShelfConfiguration, bookRepository);
        List<Book> expected = bookShelfService.getUpdatedBooks();

        assertThat(expected.size()).isEqualTo(4);
        assertThat(expected.get(0).getTitle()).isEqualToIgnoringCase("book3");

    }

    @Test
    public void getUpdatedBookShelf() {
        BookShelfConfiguration bookShelfConfiguration = mock(BookShelfConfiguration.class);
        BookRepository bookRepository = mock(BookRepository.class);
        BookShelf bookShelf = mock(BookShelf.class);
        Map<Integer, Book> books = new HashMap<>();

        List<Book> bookList = Arrays.asList(
                new Book("book3", "bob", "2010-3-22", 14),
                new Book("book4", "Mick", "1990-3-09", 15));

        books.put(12, new Book("book1", "fiona", "2001-2-20", 12));
        books.put(13, new Book("book2", "fiona", "2001-2-20", 13));
        List<Trophy> trophyList = Arrays.asList(
                new Trophy("type1", "win", 1990),
                new Trophy("type2","win",1991)
        );
        Stereo stereoList = new Stereo("black", 1);
        when(bookRepository.getBooks()).thenReturn(books);
        when(bookShelfConfiguration.getBookShelf()).thenReturn(bookShelf);
        when(bookShelf.getBooks()).thenReturn(bookList);
        when(bookShelf.getTrophies()).thenReturn(trophyList);
        when(bookShelf.getStereo()).thenReturn(stereoList);
        BookShelfService bookShelfService = new BookShelfService(bookShelfConfiguration, bookRepository);
        BookShelf expected = bookShelfService.getUpdatedBookShelf();

        assertThat(expected.getBooks().size()).isEqualTo(4);
        assertThat(expected.getStereo().getColour()).isEqualToIgnoringCase("black");

    }

    @Test
    public void getBook() {
        String bookName = "book3";
        BookShelfConfiguration bookShelfConfiguration = mock(BookShelfConfiguration.class);
        BookRepository bookRepository = mock(BookRepository.class);
        BookShelf bookShelf = mock(BookShelf.class);
        Map<Integer, Book> books = new HashMap<>();
        List<Book> bookList = Arrays.asList(
                new Book("book3", "bob", "2010-3-22", 14),
                new Book("book4", "Mick", "1990-3-09", 15));

        books.put(12, new Book("book1", "fiona", "2001-2-20", 12));
        books.put(13, new Book("book2", "fiona", "2001-2-20", 13));
        when(bookRepository.getBooks()).thenReturn(books);
        when(bookShelfConfiguration.getBookShelf()).thenReturn(bookShelf);
        when(bookShelf.getBooks()).thenReturn(bookList);
        BookShelfService bookShelfService = new BookShelfService(bookShelfConfiguration, bookRepository);
        List<Book> expected = bookShelfService.getBook(bookName);

        assertThat(expected.get(0)).extracting("title").contains("book3");
    }

    @Test
    public void getBooksByAuthor() {
        String author = "bob";
        BookShelfConfiguration bookShelfConfiguration = mock(BookShelfConfiguration.class);
        BookRepository bookRepository = mock(BookRepository.class);
        BookShelf bookShelf = mock(BookShelf.class);
        Map<Integer, Book> books = new HashMap<>();
        List<Book> bookList = Arrays.asList(
                new Book("book3", "bob", "2010-3-22", 14),
                new Book("book4", "Mick", "1990-3-09", 15));

        books.put(12, new Book("book1", "fiona", "2001-2-20", 12));
        books.put(13, new Book("book2", "fiona", "2001-2-20", 13));
        when(bookRepository.getBooks()).thenReturn(books);
        when(bookShelfConfiguration.getBookShelf()).thenReturn(bookShelf);
        when(bookShelf.getBooks()).thenReturn(bookList);
        BookShelfService bookShelfService = new BookShelfService(bookShelfConfiguration, bookRepository);
        List<Book> expected = bookShelfService.getBooksByAuthor(author);

        assertThat(expected.get(0)).extracting("author").contains("bob");

    }

    @Test
    public void putBook() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookShelfConfiguration bookShelfConfiguration = mock(BookShelfConfiguration.class);
        BookShelfService bookShelfService = new BookShelfService(bookShelfConfiguration, bookRepository);
        Book book = new Book("book3", "bob", "2010-3-22", 14);
        bookShelfService.putBook(book);
        verify(bookRepository, times(1)).addBook(book);


    }

    @Test
    public void postBookbyisbn() {

    }

    @Test
    public void getBookbyIsbn() {
        Integer isbn = 14;
        BookShelfConfiguration bookShelfConfiguration = mock(BookShelfConfiguration.class);
        BookRepository bookRepository = mock(BookRepository.class);
        BookShelf bookShelf = mock(BookShelf.class);
        Map<Integer, Book> books = new HashMap<>();
        List<Book> bookList = Arrays.asList(
                new Book("book3", "bob", "2010-3-22", 14),
                new Book("book4", "Mick", "1990-3-09", 15));

        books.put(12, new Book("book1", "fiona", "2001-2-20", 12));
        books.put(13, new Book("book2", "fiona", "2001-2-20", 13));
        when(bookRepository.getBooks()).thenReturn(books);
        when(bookShelfConfiguration.getBookShelf()).thenReturn(bookShelf);
        when(bookShelf.getBooks()).thenReturn(bookList);
        BookShelfService bookShelfService = new BookShelfService(bookShelfConfiguration, bookRepository);
        Book expected = bookShelfService.getBookbyIsbn(isbn);

        assertThat(expected.getIsbn()).isEqualTo(14);
    }
}