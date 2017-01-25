package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by xanv on 25/01/2017.
 */
public class BookRepositoryTest {
    private BookRepository br;
    @Before
    public void setUp(){
        br = new BookRepository();
        br.addBook(new Book("123456", "The Da Vinci Code", new Author("Dan", "Brown")));
    }

    @Test
    public void getDetailsBook(){
        Author author = new Author ("J.K.", "Rowling");
        Book book = new Book("123", "Harry Potter", author);
        br.addBook(book);
        br.getShortDetails("123");


        String expected = "Harry Potter (123)";
        Assertions.assertThat(br.getShortDetails("123")).isEqualTo(expected);
    }

    @Test
    public void searchBookWithWildcards_ShouldReturnOneBook(){
        String wildcartString = "123*6";

        Assertions.assertThat(br.searchBook(wildcartString).size()).isEqualTo(1);
    }

}
