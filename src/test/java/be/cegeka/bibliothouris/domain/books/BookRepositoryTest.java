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
        Author author = new Author ("J.K.", "Rowling");
        Book book = new Book("123", "Harry Potter", author);
        br.addBook(new Book("2345", "Perfume", new Author("Patrick", "Suskind")));
        br.addBook(book);
    }

    @Test
    public void getDetailsBook(){

        br.getShortDetails("123");


        String expected = "Harry Potter (123)";
        Assertions.assertThat(br.getShortDetails("123")).isEqualTo(expected);
    }

    @Test
    public void searchBookWithWildcards_ShouldReturnOneBook(){
        String wildCard = "123*6";

        Assertions.assertThat(br.searchBook(wildCard).size()).isEqualTo(1);
    }

    @Test
    public void searchBookWithWildcard_ShouldReturn2(){
        String wildcard = "12*";

        Assertions.assertThat(br.searchBook(wildcard).size()).isEqualTo(2);
    }

}
