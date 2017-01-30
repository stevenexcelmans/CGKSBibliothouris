package be.cegeka.bibliothouris.domain.lendABook;
import java.time.LocalDate;

/**
 * Created by jensde on 27/01/2017.
 */
public class LendABook {

    private LocalDate dueDate;
    private String bookISBN;
    private String memberINSZ;

    public LendABook(String bookISBN, String memberINSZ) {
        this.bookISBN = bookISBN;
        this.memberINSZ = memberINSZ;
        this.dueDate = LocalDate.now().plusWeeks(3);
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public String getMemberINSZ() {
        return memberINSZ;
    }
}
