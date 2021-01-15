package mihnea.projects.prj.controller;

import mihnea.projects.prj.dto.AuthorDTO;
import mihnea.projects.prj.dto.BookDTO;
import mihnea.projects.prj.model.Author;
import mihnea.projects.prj.model.Book;
import mihnea.projects.prj.service.AuthorService;
import mihnea.projects.prj.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/count")
    public Long GetCount() {
        return bookService.GetCount();
    }

    @GetMapping(value = "/routing")
    public String CheckRoute() {
        return "Working";
    }

    @GetMapping(value = "/delete/{id}")
    public void DeleteBook(@PathVariable(value = "id") Long id) {
        bookService.DeleteBook(id);
    }

    @GetMapping(value = "/getAll")
    public Set<Book> GetAllBooks() {
        return bookService.GetAllBooks();
    }

    @GetMapping(value = "/{id}")
    public BookDTO GetBookById(@PathVariable(value = "id") Long id) {
        return bookService.GetBookById(id);
    }

    /*@GetMapping(value = "/title/{title}")
    public BookDTO GetBookByTitle(@PathVariable(value = "title") String title) {
        return bookService.GetBookByTitle(title);
    }*/

    @PostMapping(value = "/create")
    public void AddBook(@RequestBody Book dto) {
        bookService.AddBook(dto);
    }

    @PutMapping(value = "/edit/{id}")
    public void EditBook(@PathVariable(value="id") Long id, @RequestBody Book dto) {
        bookService.EditBook(id,dto);
    }
}
