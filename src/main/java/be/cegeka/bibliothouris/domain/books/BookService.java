package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BookService {

    @Inject
    private BookRepository bookRepository;

    @Inject
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }

    public void addBook(long isbn, String title, String firstName, String lastName) {
        Author author = authorRepository.getAuthor(firstName, lastName);
        if (author == null){
            author = authorRepository.addAuthor(firstName, lastName);
        }

        bookRepository.addBook(new Book(isbn, title, author));
    }
}