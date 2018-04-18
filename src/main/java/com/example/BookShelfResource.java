package com.example;

import com.codahale.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bookshelf")
@Produces(MediaType.APPLICATION_JSON)
public class BookShelfResource {
    private BookShelfConfiguration bookShelfConfiguration;
    private BookShelfService bookShelfService;

    @Inject
    public BookShelfResource(BookShelfConfiguration bookShelfConfiguration,
                             BookShelfService bookShelfService) {
        this.bookShelfConfiguration = bookShelfConfiguration;
        this.bookShelfService = bookShelfService;
    }

    @GET
    @Timed
    public BookShelf getBookShelf() {
        return bookShelfService.getUpdatedBookShelf();
    }

    @GET
    @Timed
    @Path("/booklist")
    public List<Book> getUpdatedBooks() {
        return bookShelfService.getUpdatedBooks();
    }

    @GET
    @Timed
    @Path("/book")
    public List<Book> getBook(@QueryParam("name") String name) {
        List<Book> books = bookShelfService.getBook(name);

        if (books.isEmpty()) {
            throw new NotFoundException();
        }

        return books;
    }

    @GET
    @Timed
    @Path("/book/author/{bookAuthor}")
    public List<Book> getBookbyAuthor(@PathParam("bookAuthor") String bookAuthor) {
        List<Book> books = bookShelfService.getBooksByAuthor(bookAuthor);

        if (books.isEmpty()) {
            throw new NotFoundException();
        }

        return books;
    }
    @GET
    @Timed
    @Path("/book/isbn/{isbn}")
    public Book getBookbyIsbn(@PathParam("isbn") Integer isbn) {
        Book book = bookShelfService.getBookbyIsbn(isbn);

       if(book==null)
        {
            throw new NotFoundException(" book is not found!");
        }

        return book;
    }

    @PUT
    @Timed
    @Path("/book")
    public void putBook(Book book) {
        bookShelfService.putBook(book);
    }

    @POST
    @Timed
    @Path("/book/isbn/{isbn}")
    public void postBookbyisbn(@PathParam("isbn") Integer isbn, Book book)
    {
        try {
            bookShelfService.postBookbyisbn(book);
        }
        catch (IllegalArgumentException e) {
            throw new ForbiddenException("Book is exist");
        }
    }
}
