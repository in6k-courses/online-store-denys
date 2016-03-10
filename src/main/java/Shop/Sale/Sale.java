package Shop.Sale;

import Shop.Product;

import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public interface Sale {
    Product applySale(List<Product> products);
}
