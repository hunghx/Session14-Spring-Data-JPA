package ra.service;

import ra.dto.request.ProductRequest;
import ra.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);
    Product save (ProductRequest request);
    Product save (ProductRequest request,Integer id);


    void deleteById(Integer id);
 }
