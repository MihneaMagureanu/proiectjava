package mihnea.projects.prj.repository;

import mihnea.projects.prj.dto.AuthorDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mihnea.projects.prj.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author,Long> {

    public Optional<Author> findByFirstName(String name);

    public Optional<Author> findByLastName(String name);

}
