package Shop.db_abstract_dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by employee on 3/14/16.
 */
public interface GenericDAO<T, PK> {
    T create() throws SQLException;

    T persist(T object) throws SQLException;

    T getByPK(int key) throws SQLException;

    void upgrade(T object) throws SQLException;

    void delete(T object) throws SQLException;

    List<T> getAll() throws SQLException;

}
