package mihnea.projects.prj.dto;

import mihnea.projects.prj.model.Author;
import mihnea.projects.prj.model.Book;
import mihnea.projects.prj.model.Personaj;
import mihnea.projects.prj.model.Publisher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookDTO {
    public String title;
    public String isbn;
    public List<String> personaje;


    public BookDTO() {
    }

    public BookDTO(Book book) {
        title = book.getTitle();
        this.isbn = book.getIsbn();
        this.personaje = getAllPersonaje(book.getPersonaje());

    }

    public List<String> getAllPersonaje(Set<Personaj> personaje) {
        List<String> names = new ArrayList<>();
        for (Personaj p : personaje) {
            names.add(p.getName());
            if (names.size()==personaje.size()) {
                return names;
            }
        }
        return names;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
