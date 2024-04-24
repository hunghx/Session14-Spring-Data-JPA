package ra.repositoryImp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.model.Category;
import ra.repository.CategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryRepositoryImp implements CategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> findAll() {
//      List<Category> listCategories = entityManager.createQuery("select c from Category c", Category.class)
//                .getResultList();
        return entityManager.createQuery("select c from Category c", Category.class).getResultList();
    }
    @Override
    public Category findById(int catalogId) {
        return entityManager.createQuery("select c from Category c where c.catalogId=:id", Category.class)
                .setParameter("id", catalogId).getSingleResult();
    }

    @Override
    @Transactional
    public Category save(Category category) {
        try {
            entityManager.persist(category);
            return category;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public boolean update(Category category) {
        try {
            entityManager.merge(category);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int catalogId) {
        try {
            Category catalogDelete = findById(catalogId);
            entityManager.remove(catalogDelete);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    @Override
    public List<Category> findByName(String catalogName) {
        return entityManager.createQuery("select c from Category c where c.catalogName like %:name%",Category.class)
                .setParameter("name",catalogName).getResultList();
    }
}
