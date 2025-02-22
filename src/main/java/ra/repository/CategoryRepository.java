package ra.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.Category;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
   boolean existsByCatalogName(String name);
}
