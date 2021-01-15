package mihnea.projects.prj.service;

import mihnea.projects.prj.dto.AuthorDTO;
import mihnea.projects.prj.dto.BookDTO;
import mihnea.projects.prj.model.Author;
import mihnea.projects.prj.model.Book;
import mihnea.projects.prj.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Long GetCount() {
        return bookRepository.count();
    }

    public void DeleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Set<Book> GetAllBooks() {
        return (Set<Book>) bookRepository.findAll();
    }

    public BookDTO GetBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            BookDTO dto = new BookDTO(book);
            return dto;
        } else {
            return new BookDTO();
        }
    }

    /*public BookDTO GetBookByTitle(String title) {
        Optional<Book> optionalBook = bookRepository.FindByTitle(title);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            BookDTO dto = new BookDTO(book);
            return dto;
        } else {
            return new BookDTO();
        }
    }*/

    public void AddBook(Book dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setAuthors(new HashSet<>());
        bookRepository.save(book);
    }

    public void EditBook(Long id, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book bookEdited = optionalBook.get();
            bookEdited.setTitle(book.getTitle());
            bookEdited.setIsbn(book.getIsbn());
            bookEdited.setAuthors(book.getAuthors());
        }
    }
}
