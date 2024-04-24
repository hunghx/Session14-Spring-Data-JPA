package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.dto.request.CreateCategoryRequest;
import ra.dto.response.CreateCategoryResponse;
import ra.dto.response.FindAllResponse;
import ra.model.Category;
import ra.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/categoryController")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView("categories");
        List<FindAllResponse> listCategoriesResponse = categoryService.findAll();
        mav.addObject("listCategories", listCategoriesResponse);
        return mav;
    }
    @PostMapping("/add")
    public String doAdd(@ModelAttribute CreateCategoryRequest categoryRequest){
        CreateCategoryResponse response = categoryService.save(categoryRequest);
        return "redirect:/categoryController/findAll";
    }
    @GetMapping("/add")
    public String add(){
        return "add-category";
    }
    @GetMapping("/delete")
    public String doDelete(@RequestParam Integer id){
        categoryService.deleteById(id);
        return "redirect:/categoryController/findAll";
    }
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam Integer id){
        ModelAndView view = new ModelAndView("edit-category");
        view.addObject("category",categoryService.findById(id));
        return view;
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute Category categoryRequest){
        categoryService.update(categoryRequest);
        return "redirect:/categoryController/findAll";
    }

}
