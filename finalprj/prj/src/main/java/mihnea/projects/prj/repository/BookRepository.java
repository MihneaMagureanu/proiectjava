package mihnea.projects.prj.repository;

import org.springframework.data.repository.CrudRepository;

import mihnea.projects.prj.model.Book;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book,Long> {

    //public Optional<Book> FindByTitle(String title);
}
