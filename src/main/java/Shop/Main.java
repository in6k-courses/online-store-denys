package Shop;

import Shop.CustomExceptions.PersistException;
import Shop.ShopBase.Category;
import Shop.ShopBase.Product;
import Shop.ShopBase.PurchaseItem;
import Shop.db.dao.DAOFactory;
import Shop.db.dao.MySQLDAOFactory;


import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Connection connection;

        DAOFactory<Connection> factory = new MySQLDAOFactory();

        try {
            connection = factory.getContext();
            List<Category> c = factory.getDAO(connection, Category.class).getAll();
            System.out.println(c.get(2).getName());
        } catch (PersistException e){
            System.out.println(e.getMessage());
        }
    }

}

