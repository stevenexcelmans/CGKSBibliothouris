package be.cegeka.bibliothouris.application;


import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.ArrayList;
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
            @RequestParam(value = "ISBN", required = true) String isbn,
            @RequestParam(value = "first name", required = true) String firstName,
            @RequestParam(value = "last name", required = true) String lastName){
        bookService.addBook(isbn, title, firstName, lastName);
    }

    @RequestMapping(value = "/getShortDetails", method = RequestMethod.GET)
    public @ResponseBody
    String getBookDetails(
            @RequestParam(value = "ISBN", required = true) String ISBN){
        return bookService.returnBookInfo(ISBN);
    }

    @RequestMapping(value = "/searchBook", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Book>> searchBook(String partialIsbn){
        ResponseEntity<List<Book>> repsponse = new ResponseEntity<List<Book>>(bookService.searchBook(partialIsbn), HttpStatus.OK);
        if (repsponse.getBody().size()==0){
            repsponse = new ResponseEntity<List<Book>>(new ArrayList<Book>(), HttpStatus.NO_CONTENT);
        }
                return repsponse;
    }

}
