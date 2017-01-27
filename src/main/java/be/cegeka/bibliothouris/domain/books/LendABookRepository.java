package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jensde on 27/01/2017.
 */
@Named
public class LendABookRepository {
    @Inject
    LendABook lendABook;

    private List<LendABook> bookRentals = new ArrayList<>();

    public void addRentalBook(LendABook lendABook){
        StringBuilder errorMessage = null;
        if(lendABook.getBookISBN() == null){
            errorMessage.append("ISBN doesn't exist. ");
        }
        if(lendABook.getMemberINSZ() == null){
            errorMessage.append("INSZ doesn't exist.");
        }
        else{
            bookRentals.add(lendABook);
        }
    }
}
