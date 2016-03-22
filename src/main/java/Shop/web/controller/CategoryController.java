package Shop.web.controller;

import Shop.core.service.CategoryService;
import Shop.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Денис on 22.03.2016.
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String getCategoryList(ModelMap model){
        model.addAttribute("categories", categoryService.getAllCategories());
        System.out.println("geting category list");
        return "index";
    }

    @RequestMapping(value = "categories/{id}", method = RequestMethod.GET)
    public String getContentOfSelectedCategory(ModelMap model, @PathVariable("id") Integer id){
        model.addAttribute("products", productService.getProductsByCategory(id));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("current_category", categoryService.getCategoryById(id).getName());
        return "categories";
    }
}
