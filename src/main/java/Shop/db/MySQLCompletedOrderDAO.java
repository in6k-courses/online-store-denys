package Shop.db;

import Shop.CompletedOrder;
import Shop.CustomExceptions.PersistException;
import Shop.db.dao.AbstractJDBCDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by employee on 3/18/16.
 */
public class MySQLCompletedOrderDAO extends AbstractJDBCDAO<CompletedOrder> {

    public MySQLCompletedOrderDAO(Connection connection){ super(connection); }

    @Override
    public String getSelectQuery() {
        return "SELECT orders.id,\n" +
                "  orders.date,\n" +
                "  orders.total_price,\n" +
                "  concat(users.f_name, \" \", users.l_name) AS \"name_surname\",\n" +
                "  users.telephone, \n" +
                "  orders.status\n" +
                "FROM orders\n" +
                "INNER JOIN users\n" +
                "ON orders.user_id = users.id";
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
        return "UPDATE shop.orders SET status = ? WHERE id = ? ";
    }

    @Override
    protected List<CompletedOrder> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<CompletedOrder> result = new LinkedList<CompletedOrder>();
        try{
            while(rs.next()){
                CompletedOrder co = new CompletedOrder();
                co.setOrderId(rs.getInt("id"));
                co.setDate(rs.getTimestamp("date"));
                co.setTotalPrice(rs.getBigDecimal("total_price"));
                co.setNameAndSurname(rs.getString("name_surname"));
                co.setTelephone(rs.getString("telephone"));
                co.setStatus(rs.getBoolean("status"));
                result.add(co);
            }
        } catch (Exception e){
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, CompletedOrder object) throws PersistException {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, CompletedOrder object) throws PersistException {
        try{
            statement.setBoolean(1, (object.isStatus() ? false : true));
            statement.setInt(2, object.getOrderId());
        } catch (Exception e){
            throw new PersistException(e);
        }
    }

    public CompletedOrder create(CompletedOrder object) throws PersistException {
        return null;
    }
}
