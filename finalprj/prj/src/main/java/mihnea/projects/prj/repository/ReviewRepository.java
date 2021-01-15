package mihnea.projects.prj.repository;

import mihnea.projects.prj.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review,Long> {
}
