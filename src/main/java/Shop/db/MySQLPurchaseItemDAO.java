package Shop.db;

import Shop.CustomExceptions.PersistException;
import Shop.ShopBase.PurchaseItem;
import Shop.db.dao.AbstractJDBCDAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by employee on 3/17/16.
 */
public class MySQLPurchaseItemDAO extends AbstractJDBCDAO<PurchaseItem> {

    public MySQLPurchaseItemDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, product_id, order_id, price, amount FROM shop.purchaseitems ";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO shop.purchaseitems (product_id , order_id , price , amount ) VALUE ( ? , ? , ? , ? ) ";
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
    protected List<PurchaseItem> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<PurchaseItem> result = new LinkedList<PurchaseItem>();
        try{
            while(rs.next()){
                PurchaseItem p = new PurchaseItem();
                p.setId(rs.getInt("id"));
                p.setProduct_id(rs.getInt("product_id"));
                p.setOrderId(rs.getInt("order_id"));
                p.setPrice(BigDecimal.valueOf(rs.getDouble("price")));
                p.setAmount(BigDecimal.valueOf(rs.getDouble("amount")));
                result.add(p);
            }
        } catch (Exception e){
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, PurchaseItem object) throws PersistException {
        try{
            statement.setInt(1, object.getProduct().getId());
            statement.setInt(2, object.getOrderId());
            statement.setBigDecimal(3, object.getPrice());
            statement.setBigDecimal(4, object.getAmount());
        } catch (Exception e){
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, PurchaseItem object) throws PersistException {

    }

    public PurchaseItem create(PurchaseItem object) throws PersistException {
        return persist(object);
    }
}
