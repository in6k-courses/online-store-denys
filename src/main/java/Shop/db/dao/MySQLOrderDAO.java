package Shop.db.dao;

import Shop.CustomExceptions.PersistException;
import Shop.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by employee on 3/17/16.
 */
public class MySQLOrderDAO extends AbstractJDBCDAO<Order> {

    public MySQLOrderDAO(Connection connection) { super(connection); }

    @Override
    public String getSelectQuery() {
        return null;
    }

    @Override
    public String getCreateQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    protected List<Order> parseResultSet(ResultSet rs) throws PersistException {
        return null;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Order object) throws PersistException {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Order object) throws PersistException {

    }

    public Order create(Order object) throws PersistException {
        return null;
    }
}
