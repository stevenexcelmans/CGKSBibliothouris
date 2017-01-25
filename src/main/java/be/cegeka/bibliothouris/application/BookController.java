package be.cegeka.bibliothouris.application;


import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Inject
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Book> getBooks(){return bookService.getAllBooks();}

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    void addBook(
            @RequestParam(value = "title", required = true) String title,
            @RequestParam(value = "ISBN", required = true) long isbn,
            @RequestParam(value = "first name", required = true) String firstName,
            @RequestParam(value = "last name", required = true) String lastName){
        bookService.addBook(isbn, title, firstName, lastName);
    }

    //@RequestMapping(method = RequestMethod.GET)
    @RequestMapping(value = "/getShortDetails", method = RequestMethod.GET)
    public @ResponseBody
    String getBookDetails(
            @RequestParam(value = "ISBN", required = true) long ISBN){
        return bookService.returnBookInfo(ISBN);
    }

}
