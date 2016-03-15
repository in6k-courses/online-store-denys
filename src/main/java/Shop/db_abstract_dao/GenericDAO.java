package Shop.db_abstract_dao;

import Shop.CustomExceptions.PersistException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by employee on 3/14/16.
 */
public interface GenericDAO<T> {
    T create() throws PersistException;

    T persist(T object) throws PersistException;

    T getByPK(int key) throws PersistException;

    void update(T object) throws PersistException;

    void delete(T object) throws PersistException;

    List<T> getAll() throws PersistException;

}
