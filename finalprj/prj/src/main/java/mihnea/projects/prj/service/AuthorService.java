package mihnea.projects.prj.service;

import ch.qos.logback.core.joran.action.ActionUtil;
import mihnea.projects.prj.dto.AuthorDTO;
import mihnea.projects.prj.model.Author;
import mihnea.projects.prj.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthorService {


    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Long GetCount() {
        return authorRepository.count();
    }

    public void DeleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public Set<Author> GetAllAuthors() {
       return (Set<Author>) authorRepository.findAll();
    }

    public AuthorDTO GetAuthorById(Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();
            AuthorDTO dto = new AuthorDTO(author);
            return dto;
        } else {
            return new AuthorDTO();
        }
    }

    public void AddAuthor( Author dto) {
        Author author = new Author();
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());
        author.SetBooks(new HashSet<>());
        authorRepository.save(author);
    }

    public void EditAuthor(Long id, Author author) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            Author authorEdited = optionalAuthor.get();
            authorEdited.setFirstName(author.getFirstName());
            authorEdited.setLastName(author.getLastName());
            authorEdited.SetBooks(author.getBooks());
            authorRepository.save(authorEdited);
        }
    }

    public AuthorDTO GetAuthorByFirstName(String name) {
        Optional<Author> optionalAuthor = authorRepository.findByFirstName(name);
        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();
            AuthorDTO dto = new AuthorDTO(author);
            return dto;
        } else {
            return new AuthorDTO();
        }
    }

    public AuthorDTO GetAuthorByLastName(String name) {
        Optional<Author> optionalAuthor = authorRepository.findByLastName(name);
        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();
            AuthorDTO dto = new AuthorDTO(author);
            return dto;
        } else {
            return new AuthorDTO();
        }
    }


}
