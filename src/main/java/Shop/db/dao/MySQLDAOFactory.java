package Shop.db.dao;

import Shop.CustomExceptions.PersistException;
import Shop.ShopBase.Category;
import Shop.ShopBase.Product;
import Shop.User;
import Shop.db.MySQLCategoryDAO;
import Shop.db.MySQLProductDAO;
import Shop.db.MySQLUserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by employee on 3/14/16.
 */
public class MySQLDAOFactory implements DAOFactory<Connection> {

    private String user = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/shop";
    private String driver = "com.mysql.jdbc.Driver";
    private Map<Class, DAOCreator> creators;
    private Connection connection;

    public MySQLDAOFactory(){
        try{
            Class.forName(driver);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("no driver!");
        }

        creators = new HashMap<Class, DAOCreator>();
        creators.put(Product.class, new DAOCreator() {
            public GenericDAO create(Object o) {
                return new MySQLProductDAO(connection);
            }
        });
        creators.put(Category.class, new DAOCreator() {
            public GenericDAO create(Object o) {
                return new MySQLCategoryDAO(connection);
            }
        });
        creators.put(User.class, new DAOCreator() {
            public GenericDAO create(Object o) {
                return new MySQLUserDAO(connection);
            }
        });

    }

    public Connection getContext() throws PersistException {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("no connection");
        }
        return connection;
    }

    public GenericDAO getDAO(Connection connection, Class classDAO) throws PersistException {
        DAOCreator creator = creators.get(classDAO);
        if(creator == null) {
            throw new PersistException("DAO object for " + classDAO + " is not exist");
        }
        return creator.create(connection);
    }
}
