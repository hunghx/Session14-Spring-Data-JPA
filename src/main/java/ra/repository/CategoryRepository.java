package ra.repository;

import ra.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();

    Category findById(int catalogId);

    Category save(Category category);

    boolean update(Category category);

    boolean delete(int catalogId);

    List<Category> findByName(String catalogName);
}
