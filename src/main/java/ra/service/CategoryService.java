package ra.service;

import ra.dto.request.CreateCategoryRequest;
import ra.dto.response.CreateCategoryResponse;
import ra.dto.response.FindAllResponse;
import ra.model.Category;

import java.util.List;

public interface CategoryService {
    Category findById(int id);
    List<FindAllResponse> findAll();
    CreateCategoryResponse save(CreateCategoryRequest request);
    boolean update(Category request);
    void deleteById(int id);
}
