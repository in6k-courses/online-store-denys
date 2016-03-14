package Shop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by employee on 3/14/16.
 */
public class MySQLDAOFactory implements DAOFactory {

    private String user = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/shop";
    private String driver = "com.mysql.jdbc.Driver";
    private Connection connection;

    //TODO add other classes DAO

    public MySQLDAOFactory(){
        try{
            Class.forName(driver);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }

    public IProductDAO getProductDAO(Connection connection){
        return new MySQLProductDAO(connection);
    }
}
