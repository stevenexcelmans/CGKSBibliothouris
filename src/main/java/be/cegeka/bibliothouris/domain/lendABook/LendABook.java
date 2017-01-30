package be.cegeka.bibliothouris.domain.lendABook;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.members.Member;

import javax.inject.Named;
import java.time.LocalDate;

/**
 * Created by jensde on 27/01/2017.
 */
@Named
public class LendABook {
    private LocalDate dueDate;
    private String bookISBN;
    private String memberINSZ;

    public LendABook(Book book, Member member) {
        this.bookISBN = book.getIsbn();
        this.memberINSZ = member.getINSZ();
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
