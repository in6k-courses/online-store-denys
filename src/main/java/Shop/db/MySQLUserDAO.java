package Shop.db;


import Shop.CustomExceptions.PersistException;
import Shop.db.dao.AbstractJDBCDAO;
import Shop.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySQLUserDAO extends AbstractJDBCDAO<User> {

    public MySQLUserDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, f_name, l_name, telephone FROM shop.users";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO shop.users (f_name, l_name, tel) VALUES ( ? , ? , ? )";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM shop.users WHERE id = ?";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE shop.users SET f_name = ? , l_name = ? , telephone = ? WHERE id = ?";
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<User> result = new LinkedList<User>();
        try{
            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setFirstName(rs.getString("f_name"));
                u.setLastName(rs.getString("l_name"));
                u.setTelephone(rs.getString("telephone"));
                result.add(u);
            }
        } catch (Exception e){
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws PersistException {
        try{
            statement.setString(1, object.getFirstName());
            statement.setString(2, object.getLastName());
            statement.setString(3, object.getTelephone());
        } catch (Exception e){
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws PersistException {
        try{
            statement.setString(1, object.getFirstName());
            statement.setString(2, object.getLastName());
            statement.setString(3, object.getTelephone());
            statement.setInt(4, object.getId());
        } catch (Exception e){
            throw new PersistException(e);
        }
    }

    public User create(User object) throws PersistException {
        return persist(object);
    }
}
