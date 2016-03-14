package Shop.db;

import Shop.ShopBase.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by employee on 3/14/16.
 */
public interface IProductDAO {
    Product create(Product product);

    Product read(int key) throws SQLException;

    void update(Product product) throws SQLException;

    void delete(Product product) throws SQLException;

    List<Product> getAll() throws SQLException;
}
