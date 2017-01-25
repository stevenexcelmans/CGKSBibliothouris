package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by xanv on 25/01/2017.
 */
public class BookRepositoryTest {
    @Before
    public void setUp(){
    }

    @Test
    public void getDetailsBook(){
        Author author = new Author ("J.K.", "Rowling");
        Book book = new Book("123", "Harry Potter", author);
        BookRepository br = new BookRepository();
        br.addBook(book);
        br.getShortDetails("123");


        String expected = "Harry Potter (123)";
        Assertions.assertThat(br.getShortDetails("123")).isEqualTo(expected);
    }

}
