package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.dto.request.ProductRequest;
import ra.model.Product;
import ra.service.CategoryService;
import ra.service.IProductService;

@Controller
@RequestMapping("/ProductController")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/findAll")
    public String findAll(Model model){
        model.addAttribute("products", productService.findAll());
        return "products";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("catagories",categoryService.findAll());
        return "add-product";
    }
    @PostMapping("/add")
    public String doAdd(@ModelAttribute ProductRequest request){
        Product product = productService.save(request);
        return "redirect:/ProductController/findAll";
    }
}
