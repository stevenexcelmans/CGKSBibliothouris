package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Author;
import be.cegeka.bibliothouris.domain.books.Book;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookControllerTest {

    private Book book;

    @Before
    public void setup(){
        Author author = new Author("J.K.", "Rowling");
        book = new Book("12345", "Harry Potter", author);
    }

    @Test
    public void getBookDetails_returnsBookDetails(){
        String expected = "Harry Potter (12345)";
        Assertions.assertThat(expected).isEqualTo(book.getShortDetails());
    }


}