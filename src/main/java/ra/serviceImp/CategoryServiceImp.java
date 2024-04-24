package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.dto.request.CreateCategoryRequest;
import ra.dto.response.CreateCategoryResponse;
import ra.dto.response.FindAllResponse;
import ra.mapper.CreateCategoryMapper;
import ra.mapper.FindAllMapper;
import ra.model.Category;
import ra.repository.CategoryRepository;
import ra.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private FindAllMapper findAllMapper;
    @Autowired
    private CreateCategoryMapper createCategoryMapper;

    @Override
    public List<FindAllResponse> findAll() {
        //List entity
        List<Category> listCategories = categoryRepository.findAll();
        //List entity --> list DTO --> return controller
        return listCategories.stream().map(catalog -> findAllMapper.mapperEntityToResponse(catalog))
                .collect(Collectors.toList());
    }

    @Override
    public CreateCategoryResponse save(CreateCategoryRequest request) {
        //1. Chuyển từ Request sang Entity
        Category categoryNew = createCategoryMapper.mapperRequestToEntity(request);
        //2. Gọi respository thêm mới và nhận Entity
        Category category = categoryRepository.save(categoryNew);
        //3. Entity sang response và return về controller
        return createCategoryMapper.mapperEntityToResponse(category);
    }

    @Override
    public void deleteById(int id) {
       Category cat = categoryRepository.findById(id).orElse(null);
       if (cat == null){
           throw new RuntimeException("danh mục không tồn tại");
       }
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean update(Category request) {
        // ngày tạo ko bị sửa
        Category old = findById(request.getCatalogId());
        if (old==null){
            throw new RuntimeException("kooong tông tại catalog");
        }
        old.setStatus(request.isStatus());
        old.setDescriptions(request.getDescriptions());
        old.setCatalogName(request.getCatalogName());
         categoryRepository.save(old);
         return true;
    }
}
