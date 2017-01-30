
package be.cegeka.bibliothouris.domain.lendABook;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import be.cegeka.bibliothouris.domain.members.Member;
import be.cegeka.bibliothouris.domain.members.MemberService;

import javax.inject.Inject;


/**
 * Created by davids on 30/01/2017.
 */

public class LendABookService {


    @Inject
    private LendABookRepository lendABookRepository;

    @Inject
    private BookService bookService;

    @Inject
    private MemberService memberService;


   public void addRentalBook(String isbn, String insz) {

        StringBuilder errorMessage = null;
       if(bookService.searchBook(isbn).size() == 0){
           errorMessage.append("ISBN doesn't exist.");
       }
       if(memberService.searchMemberByINSZ(insz).size() == 0){
           errorMessage.append("INSZ doesn't exist.");
       }
        if (errorMessage == null) {
            lendABookRepository.addRentalBook(new LendABook(isbn,insz));
        }
    }

}
