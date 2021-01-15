package mihnea.projects.prj.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Title;
    private String Text;
    private int Grade;

    @ManyToOne
    private Book book;

    public Review() {
    }

    public Review(String title, String text, int grade, Book book) {
        Title = title;
        Text = text;
        Grade = grade;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
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

        Review review = (Review) o;

        if (Grade != review.Grade) return false;
        if (!id.equals(review.id)) return false;
        if (!Objects.equals(Title, review.Title)) return false;
        if (!Objects.equals(Text, review.Text)) return false;
        return Objects.equals(book, review.book);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", Text='" + Text + '\'' +
                ", Grade=" + Grade +
                ", book=" + book +
                '}';
    }
}
