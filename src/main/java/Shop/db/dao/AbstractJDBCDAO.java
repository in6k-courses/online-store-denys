package Shop.db.dao;

import Shop.CustomExceptions.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by employee on 3/14/16.
 */
public abstract class AbstractJDBCDAO<T> implements GenericDAO<T> {
    private Connection connection;

    public AbstractJDBCDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getDeleteQuery();

    public abstract String getUpdateQuery();

    protected abstract List<T> parseResultSet(ResultSet rs) throws PersistException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws PersistException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws PersistException;

    public T getByPK(int key) throws PersistException {
        List<T> list;
        String sql = getSelectQuery();
        sql += "WHERE id = ? ;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            throw new PersistException("Get by PK exception, more then one row");
        }
        return list.iterator().next();
    }

    public List<T> getAll() throws PersistException {
        List<T> list;
        String sql = getSelectQuery();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }

    public T persist(T object) throws PersistException {
        T persistIstance;
        String sql = getCreateQuery();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On persist modify not 1 record " + count);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        sql = getSelectQuery() + " WHERE id = LAST_INSERT_ID() ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<T> list = parseResultSet(rs);
            if (list == null || list.size() != 1) {
                throw new PersistException("Exception on findByPK");
            }
            persistIstance = list.get(0);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return persistIstance;
    }

    public void update(T object) throws PersistException {
        String sql = getUpdateQuery();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatementForUpdate(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On update modify not one record " + count);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    public void delete(T object) throws PersistException {
        String sql = getDeleteQuery();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            int count = statement.executeUpdate();
            if(count != 1){
                throw new PersistException("On delete modify not one record: " + count);
            }
            statement.close();
        } catch (Exception e){
            throw  new PersistException(e);
        }
    }
}
