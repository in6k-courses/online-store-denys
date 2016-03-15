package Shop.com;

import Shop.CustomExceptions.PersistException;
import Shop.ShopBase.Category;
import Shop.db.dao.DAOFactory;
import Shop.db.dao.MySQLDAOFactory;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/15/16.
 */
public class CategoryPage {

    public static List<String> getCategoriesList() {
        Connection connection;
        DAOFactory<Connection> factory = new MySQLDAOFactory();
        List<String> result = new ArrayList<String>();

        try {
            connection = factory.getContext();
            List<Category> categories = factory.getDAO(connection, Category.class).getAll();
            for (Category c : categories)
                result.add(c.getName());

        } catch (PersistException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
