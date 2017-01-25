package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Author;
import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookRepository;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.Assert.*;

public class BookControllerTest {

    private Book book;
    private BookService bookService;
    private BookRepository bookRepository;

    @Before
    public void setup(){
        Author author = new Author("J.K.", "Rowling");
        book = new Book("12345", "Harry Potter", author);
        bookService = new BookService();
        bookService.addBook("12345", "Harry Potter", "J.K.", "Rowling");
    }

    @Test
    public void getBookDetails_returnsBookDetails(){
        String expected = "Harry Potter (12345)";
        Assertions.assertThat(expected).isEqualTo(book.getShortDetails());
    }

    @Test
    public void searchBook_returnsPartialIsbn(){
        Assertions.assertThat(bookService.searchBook("123*").size()).isEqualTo(1);
    }

}