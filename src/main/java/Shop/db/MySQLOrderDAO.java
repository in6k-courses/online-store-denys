package Shop.db;

import Shop.CustomExceptions.PersistException;
import Shop.Order;
import Shop.db.dao.AbstractJDBCDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by employee on 3/17/16.
 */
public class MySQLOrderDAO extends AbstractJDBCDAO<Order> {

    public MySQLOrderDAO(Connection connection) { super(connection); }

    @Override
    public String getSelectQuery() {
        return "SELECT id, user_id , date, total_price FROM shop.orders";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO shop.orders (user_id , date , total_price) VALUES ( ? , ? , ? )";
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
        LinkedList<Order> result = new LinkedList<Order>();
        try{
            while(rs.next()){
                Order o = new Order();
                o.setId(rs.getInt("id"));
                o.setUserId(rs.getInt("user_id"));
                o.setDate(rs.getTimestamp("date"));
                o.setTotalPrice(rs.getBigDecimal("total_price"));
                result.add(o);
            }
        } catch (Exception e){
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Order object) throws PersistException {
        try{
            statement.setInt(1, object.getUserId());
            statement.setTimestamp(2, object.getDate());
            statement.setBigDecimal(3, object.getTotalPrice());
        } catch (Exception e){
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Order object) throws PersistException {

    }

    public Order create(Order object) throws PersistException {
        return persist(object);
    }
}
