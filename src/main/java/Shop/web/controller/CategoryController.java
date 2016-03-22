package Shop.web.controller;

import Shop.core.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Денис on 22.03.2016.
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("")
    public String getCategoryList(ModelMap model){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "index";
    }
}
