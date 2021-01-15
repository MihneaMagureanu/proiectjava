package mihnea.projects.prj.dto;

public class ReviewOutDTO {

    public String Title;
    public String Text;
    public int Grade;
    public long Book_id;

    public ReviewOutDTO() {

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

    public long getBook_id() {
        return Book_id;
    }

    public void setBook_id(long book_id) {
        Book_id = book_id;
    }
}
