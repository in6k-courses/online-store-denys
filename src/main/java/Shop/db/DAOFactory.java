package Shop.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface DAOFactory {
    Connection getConnection() throws SQLException;

    ProductDAO getProductDAO(Connection connection);
}