package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BookService {

    @Inject
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }
}