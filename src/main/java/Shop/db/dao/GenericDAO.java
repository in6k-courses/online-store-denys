package Shop.db.dao;

import Shop.CustomExceptions.PersistException;

import java.util.List;

/**
 * Created by employee on 3/14/16.
 */
public interface GenericDAO<T> {
    T create(T object) throws PersistException;

    T persist(T object) throws PersistException;

    T getByPK(int key) throws PersistException;

    void update(T object) throws PersistException;

    void delete(T object) throws PersistException;

    List<T> getAll() throws PersistException;

}
