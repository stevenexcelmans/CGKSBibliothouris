package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.books.author.Author;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class BookServiceTest {


    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void addBook_ShouldCallBookRepository(){
        bookService.addBook("978-454894-48","The Bible","Jezus", "Himself");

        Mockito.verify(bookRepository).addBook(new Book("978-454894-48","The Bible",new Author("Jezus","Himself")));
    }
}
