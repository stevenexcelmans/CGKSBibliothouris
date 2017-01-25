package be.cegeka.bibliothouris.domain.books;

import javax.inject.Named;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Named
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook (Book book){
        books.add(book);
    }

    public String getShortDetails (String isbn){
        for (Book book : books) {
            if (book.getIsbn() == isbn){
                return book.getShortDetails();
            }
        }
        return null;
    }

    public String partialIsbn(String isbn){
        for(Book book : books){
        }
    }
/*
    public List<Ibsn> searchBook(char ) {
        return books.searchBook(partialIsbn);
    }
*/
}