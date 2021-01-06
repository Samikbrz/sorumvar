package backend.sorumvar.repository;

import backend.sorumvar.model.ImageInfo;
import backend.sorumvar.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageInfo,Long> {
}
