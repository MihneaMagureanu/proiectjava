package mihnea.projects.prj.repository;

import mihnea.projects.prj.dto.PersonajDTO;
import mihnea.projects.prj.model.Personaj;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface PersonajRepository extends CrudRepository<Personaj,Long> {

    //public List<Personaj> FindByBookId(Long book_id);
}
