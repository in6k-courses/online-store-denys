package Shop.db;

import Shop.CustomExceptions.PersistException;
import Shop.core.entity.Category;
import Shop.db.dao.AbstractJDBCDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by employee on 3/15/16.
 */
public class MySQLCategoryDAO extends AbstractJDBCDAO<Category> {
    public MySQLCategoryDAO(Connection connection) { super(connection);}

    @Override
    public String getSelectQuery() {
        return "SELECT id, name FROM shop.categories ";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO shop.categories ( name ) VALUE ( ? ) ";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM shop.categories WHERE id = ? ";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE shop.categories SET name = ? WHERE id = ? ";
    }

    @Override
    protected List<Category> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Category> result = new LinkedList<Category>();
        try{
            while(rs.next()){
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                result.add(c);
            }
        } catch (Exception e){
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Category object) throws PersistException {
        try{
            statement.setString(1, object.getName());
        } catch (Exception e){
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Category object) throws PersistException {
        try{
            statement.setString(1, object.getName());
        } catch (Exception e){
            throw new PersistException(e);
        }
    }

    public Category create(Category object) throws PersistException {
        return persist(object);
    }
}
