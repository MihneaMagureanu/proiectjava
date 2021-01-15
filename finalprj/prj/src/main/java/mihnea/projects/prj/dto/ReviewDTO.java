package mihnea.projects.prj.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import mihnea.projects.prj.model.Book;
import mihnea.projects.prj.model.Review;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ReviewDTO {
    String title;
    String text;
    int grade;
    String book;

    public ReviewDTO() {
    }

    public ReviewDTO(Review review) {
        this.book = review.getBook().getTitle();
        this.grade = review.getGrade();
        this.text = review.getText();
        this.title = review.getTitle();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
