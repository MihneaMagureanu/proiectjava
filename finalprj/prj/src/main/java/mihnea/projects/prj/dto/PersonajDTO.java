package mihnea.projects.prj.dto;

import mihnea.projects.prj.model.Book;
import mihnea.projects.prj.model.Personaj;

public class PersonajDTO {
    String name;
    String book;

    public PersonajDTO() {
    }

    public PersonajDTO(Personaj personaj) {
        this.name = personaj.getName();
        this.book = personaj.getBook().getTitle();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
