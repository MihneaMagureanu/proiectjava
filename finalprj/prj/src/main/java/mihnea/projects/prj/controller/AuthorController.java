package mihnea.projects.prj.controller;

import mihnea.projects.prj.dto.AuthorDTO;
import mihnea.projects.prj.model.Author;
import mihnea.projects.prj.repository.AuthorRepository;
import mihnea.projects.prj.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }



    @GetMapping(value = "/count")
    public Long GetCount() {
        return authorService.GetCount();
    }

    @GetMapping(value = "/routing")
    public String CheckRoute() {
        return "Working";
    }

    @GetMapping(value = "/delete/{id}")
    public void DeleteAuthor(@PathVariable(value = "id") Long id) {
        authorService.DeleteAuthor(id);
    }

    @GetMapping(value = "/getAll")
    public Set<Author> GetAllAuthors() {
        return authorService.GetAllAuthors();
    }

    @GetMapping(value = "/{id}")
    public AuthorDTO GetAuthorById(@PathVariable(value = "id") Long id) {
        return authorService.GetAuthorById(id);
    }

    @PostMapping(value = "/create")
    public void AddAuthor(@RequestBody Author dto) {
        authorService.AddAuthor(dto);
    }

    @PutMapping(value = "/edit/{id}")
    public void EditAuthor(@PathVariable(value="id") Long id, @RequestBody Author dto) {
        authorService.EditAuthor(id,dto);
    }

    @GetMapping(value = "/firstname/{name}")
    public AuthorDTO GetAuthorByFirstName(@PathVariable(value = "name") String name) {
        return authorService.GetAuthorByFirstName(name);
    }

    @GetMapping(value = "/lastname/{name}")
    public AuthorDTO GetAuthorByLastName(@PathVariable(value = "name") String name) {
        return authorService.GetAuthorByLastName(name);
    }
}
