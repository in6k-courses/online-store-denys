package Shop.db;

import Shop.CustomExceptions.SQLDataBaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by employee on 3/14/16.
 */
public abstract class AbstractJDBCDao<T, PK> implements GenericDAO<T, PK> {
    private Connection connection;

    AbstractJDBCDao(Connection connection) {
        this.connection = connection;
    }

    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getDeleteQuery();

    public abstract String getUpdateQuery();

    protected abstract List<T> parseResultSet(ResultSet rs);

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object);

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object);

    public T getByPK(int key) throws SQLException {
        List<T> list;
        String sql = getSelectQuery();
        sql += "WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new SQLDataBaseException("Get by PK exception");
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            throw new SQLDataBaseException("Get by PK exception, more then one row");
        }
        return list.get(1);
    }

    public List<T> getAll() throws SQLException {
        List<T> list;
        String sql = getSelectQuery();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new SQLDataBaseException("Get all exception");
        }
        return list;
    }

    public T persist(T object) throws SQLException {
        T persistIstance;
        String sql = getCreateQuery();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new SQLDataBaseException("On persist modify not 1 record " + count);
            }
        } catch (Exception e) {
            throw new SQLDataBaseException("Exception: Persist to DB failure");
        }
        sql = getSelectQuery() + "WHERE id = last_isert_id()";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<T> list = parseResultSet(rs);
            if (list == null || list.size() != 1) {
                throw new SQLDataBaseException("Exception on findByPK");
            }
            persistIstance = list.iterator().next();
        } catch (Exception e) {
            throw new SQLDataBaseException("Exception: Persist to DB failure");
        }
        return persistIstance;
    }

    public void update(T object) throws SQLException {
        String sql = getUpdateQuery();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatementForUpdate(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new SQLDataBaseException("On update modify not one record " + count);
            }
        } catch (Exception e) {
            throw new SQLDataBaseException("Exception: Update to DB failure");
        }
    }

    public void delete(T object) throws SQLException {
        String sql = getDeleteQuery();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            int count = statement.executeUpdate();
            if(count != 1){
                throw new SQLDataBaseException("On delete modify not one record: " + count);
            }
            statement.close();
        } catch (Exception e){
            throw  new SQLDataBaseException("Exception: Delete to DB failure");
        }
    }
}
