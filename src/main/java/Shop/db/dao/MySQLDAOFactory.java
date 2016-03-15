package Shop.db.dao;

import Shop.CustomExceptions.PersistException;
import Shop.db.dao.DAOFactory;
import Shop.db.dao.GenericDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by employee on 3/14/16.
 */
public class MySQLDAOFactory implements DAOFactory {

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
        }
        //TODO add DAOs for classes to Map
    }

    public Connection getContext() throws PersistException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return connection;
    }

    public GenericDAO getDAO(Object o, Class classDAO) throws PersistException {
        DAOCreator creator = creators.get(classDAO);
        if(creator == null) {
            throw new PersistException("DAO object for " + classDAO + "is not exist");
        }
        return creator.create(connection);
    }
}
