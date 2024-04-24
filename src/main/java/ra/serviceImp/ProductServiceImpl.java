package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import ra.dto.request.ProductRequest;
import ra.model.Product;
import ra.repository.CategoryRepository;
import ra.repository.ProductRepository;
import ra.service.IProductService;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    private static final String uploadPath ="C:\\Users\\AD\\Desktop\\ra_jv230913_md4_springmvc_hibernate_dto_crud\\src\\main\\webapp\\uploads";
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("id ko tồn tại"));
    }

    @Override
    public Product save(ProductRequest request) {
        // chuyển đổi request thành entity
        Product product = new Product();
        if (request.getFile().getSize()!=0){
            // upload file
            product.setImageUrl(request.getFile().getOriginalFilename());

            try {
                FileCopyUtils.copy(request.getFile().getBytes(),new File(uploadPath+File.separator+request.getFile().getOriginalFilename()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        product.setName(request.getName());
        product.setCategory(categoryRepository.findById(request.getCategoryId()).orElse(null));
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        return productRepository.save(product);
    }

    @Override
    public Product save(ProductRequest request, Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
