package mihnea.projects.prj.dto;

import mihnea.projects.prj.model.Book;
import mihnea.projects.prj.model.Publisher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PublisherDTO {
    private String name;
    private String addressLine1;
    private String city;
    private String state;
    private String zip;
    private List<String> books;

    public PublisherDTO() {
    }

    public PublisherDTO(Publisher publisher) {
        this.name = publisher.getName();
        this.addressLine1 = publisher.getAddressLine1();
        this.city = publisher.getCity();
        this.state = publisher.getState();
        this.zip = publisher.getZip();
        //this.books = publisher.getBooks();
        this.books = getAllBooks(publisher.getBooks());
    }

    public List<String> getAllBooks(Set<Book> books) {
        List<String> titles = new ArrayList<>();
        int lng = books.size();
        for (Book b : books) {
            titles.add(b.getTitle());
            if (titles.size()==lng) {
                return titles;
            }
        }
        return titles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}
