package Shop.db_abstract_dao;

import Shop.CustomExceptions.PersistException;
import Shop.ShopBase.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Денис on 15.03.2016.
 */
public class MySQLProductDAO extends AbstractJDBCDAO<Product> {
    public MySQLProductDAO(Connection connection){ super(connection);}

    @Override
    public String getSelectQuery() {
        return "SELECT id, name, cost, category_id FROM shop.products";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO shop.products (name, cost, category_id) VALUES (?, ?, ?)";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM shop.products WHERE id = ?";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE shop.products SET name = ? , cost = ? , category_id = ? WHERE id = ?";
    }

    @Override
    protected List<Product> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Product> result = new LinkedList<Product>();
        try{
            while(rs.next()){
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setCost(rs.getBigDecimal("cost"));
                p.setCategory(rs.getInt("category_id"));
                result.add(p);
            }
        } catch (Exception e){
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Product object) throws PersistException{
        try{
            statement.setString(1, object.getName());
            statement.setBigDecimal(2, object.getCost());
            statement.setInt(3, object.getCategory());
        } catch (Exception e){
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Product object) throws PersistException{
        try{
            statement.setString(1, object.getName());
            statement.setBigDecimal(2, object.getCost());
            statement.setInt(3, object.getCategory());
            statement.setInt(4, object.getCategory());
        } catch (Exception e){
            throw new PersistException(e);
        }
    }

    public Product create() throws PersistException {
        Product p = new Product();
        return persist(p);
    }
}
