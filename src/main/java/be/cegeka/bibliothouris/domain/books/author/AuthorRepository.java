package be.cegeka.bibliothouris.domain.books.author;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named
public class AuthorRepository {

    private List<Author> authorList = new ArrayList<>();

    public List<Author> getAllAuthors() {
        return authorList;
    }

    public Author addAuthor(String firstName, String lastName) {
        Author author = new Author(firstName, lastName);
        authorList.add(author);
        return author;
    }

    public Author getAuthor(String firstName, String lastName) {
        Optional<Author> result = authorList.stream()
                .filter(a -> (a.getFirstName().equals(firstName) && a.getLastName().equals(lastName)))
                .findFirst();

        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
