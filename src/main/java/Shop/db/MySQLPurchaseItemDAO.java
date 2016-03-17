package Shop.db;

import Shop.CustomExceptions.PersistException;
import Shop.ShopBase.PurchaseItem;
import Shop.db.dao.AbstractJDBCDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        return null;
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO shop.purchaseitems (product_id , order_id , cost , amount ) VALUE ( ? , ? , ? , ? ) ";
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
        return null;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, PurchaseItem object) throws PersistException {
        try{
            statement.setInt(1, object.getProduct().getId());
            statement.setInt(2, ); //TODO
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
