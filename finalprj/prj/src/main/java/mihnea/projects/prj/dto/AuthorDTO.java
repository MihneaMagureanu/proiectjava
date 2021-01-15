package mihnea.projects.prj.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.sun.istack.NotNull;
import mihnea.projects.prj.model.Author;
import mihnea.projects.prj.model.Book;

import java.util.HashSet;
import java.util.Optional;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AuthorDTO {

    @NotNull
    //@Size(max=100)
    String firstName;
    String lastName;
    //HashSet<Book> books;

    public AuthorDTO() {
    }

    public AuthorDTO(Author author) {
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        /*author.getBooks().forEach(book -> {
            this.books.add(book);
        });*/
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
