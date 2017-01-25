package be.cegeka.bibliothouris.domain.books;

import javax.inject.Named;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

import static javax.print.attribute.standard.MediaSizeName.A;

@Named
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public String getShortDetails(String isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                return book.getShortDetails();
            }
        }
        return null;
    }

    public List<Book> searchBookISBN(String partialISBN) {
        partialISBN = partialISBN.replaceAll("\\*", "[0-9]*-?[0-9]*");
        List<Book> booksWithPartialIsbn = new ArrayList<>();
        for (Book book : books) {
            if (book.getIsbn().matches(partialISBN)) {
                booksWithPartialIsbn.add(book);
            }
        }
        return booksWithPartialIsbn;
    }

    public List<Book> searchBookPartialTitle(String partialTitle) {
        partialTitle = partialTitle.replaceAll("\\*", "[^0-9]");
        List<Book> booksWithPartialTitle = new ArrayList<>();
        for (Book book : books) {
            if (book.getIsbn().matches(partialTitle)) {
                booksWithPartialTitle.add(book);
            }
        }
        return booksWithPartialTitle;
    }
}