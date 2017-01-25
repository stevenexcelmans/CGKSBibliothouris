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

    public List<Book> searchBook(String partial){
        partial = partial.replaceAll("\\*", "[0-9]*-?[0-9]*");
        List<Book> booksWithPartialIsbn = new ArrayList<>();
        for(Book book : books){
            if (book.getIsbn().matches(partial)){
                booksWithPartialIsbn.add(book);
            }
        }
        return booksWithPartialIsbn;
    }

}