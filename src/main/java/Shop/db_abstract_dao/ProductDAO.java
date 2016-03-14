package Shop.db_abstract_dao;

import Shop.ShopBase.Product;
import Shop.db.IProductDAO;

/**
 * Created by employee on 3/14/16.
 */
public class ProductDAO extends AbstractJDBCDAO<Product, Integer> implements IProductDAO {
}
