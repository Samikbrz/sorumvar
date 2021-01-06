package backend.sorumvar.repository;

import backend.sorumvar.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Question,Long> {
}
