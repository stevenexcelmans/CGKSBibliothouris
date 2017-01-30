package be.cegeka.bibliothouris.domain.lendABook;

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
        bookRentals.add(lendABook);
    }
}
