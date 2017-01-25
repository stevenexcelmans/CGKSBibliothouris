package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {

    private Author author;

    @Before
    public void setup(){
        author = new Author("Dan", "Brown");
    }

    @Test
    public void toString_returnsString () throws Exception {
        String expected = "Dan Brown";
        Assertions.assertThat(author.toString()).isEqualTo(expected);
    }


}