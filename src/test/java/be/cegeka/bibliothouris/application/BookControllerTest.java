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

    /*
    @RequestMapping(value = "/getShortDetails", method = RequestMethod.GET)
    public @ResponseBody
    String getBookDetails(
            @RequestParam(value = "ISBN", required = true) String ISBN){
        return bookService.returnBookInfo(ISBN);
    }
     */

    @Test
    public void getBookDetails_returnsBookDetails(){
        String expected = "Harry Potter (12345)";
        Assertions.assertThat(expected).isEqualTo(book.getShortDetails());
    }

    @Test
    public void searchBook_returnsPartialIsbn(){
        String expected = "123";
        Assertions.assertThat(expected).isEqualTo(bookService.searchBook);
    }

    /*
    @RequestMapping(value = "/searchBook", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> searchBook(String partialIsbn){
                return bookService.searchBook(partialIsbn);
    }
     */


}