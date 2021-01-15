package mihnea.projects.prj.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;

    @OneToMany
    @JoinColumn(name = "personaj_id")
    private Set<Personaj> personaje = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "book_id")
    private Set<Review> review = new HashSet<>();

    @ManyToOne
    private Publisher publisher;



    @ManyToMany
    @JoinTable(name="author_book",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book() {

    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;

    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Personaj> getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Set<Personaj> personaje) {
        this.personaje = personaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
