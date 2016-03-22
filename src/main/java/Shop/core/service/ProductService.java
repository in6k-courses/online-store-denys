package Shop.core.service;

import Shop.core.entity.Product;
import Shop.core.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Денис on 22.03.2016.
 */
@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public Product getProductById(int id) {
        return productDao.findById(id);
    }

    public List<Product> getProductsByCategory(Integer id){
        List<Product> result = new ArrayList<>();
        for(Product p : productDao.findAll()){
            if(p.getCategory().getId() == id){
                result.add(p);
            }
        }
        return result;
    }
}
