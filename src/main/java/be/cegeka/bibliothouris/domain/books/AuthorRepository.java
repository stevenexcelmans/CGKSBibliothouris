package be.cegeka.bibliothouris.domain.books;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    private List<Author> authorList = new ArrayList<>();

    public List<Author> getAuthor(){
        return authorList;
    }

    public void addAuthor(Author author){
        authorList.add(author);
    }
}
