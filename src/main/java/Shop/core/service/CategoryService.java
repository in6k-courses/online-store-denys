package Shop.core.service;

import Shop.core.entity.Category;
import Shop.core.repository.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Денис on 22.03.2016.
 */
@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public List<Category> getAllCategories(){
        return categoryDao.findAll();
    }

    public Category getCategoryById(int id){
        return categoryDao.findById(id);
    }
}
