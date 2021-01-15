package mihnea.projects.prj.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Personaj {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Book book;

    public Personaj() {
    }

    public Personaj(String name, Book book) {
        this.name = name;
        this.book = book;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personaj personaj = (Personaj) o;

        if (!id.equals(personaj.id)) return false;
        if (!Objects.equals(name, personaj.name)) return false;
        return Objects.equals(book, personaj.book);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Personaj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", book=" + book +
                '}';
    }
}
