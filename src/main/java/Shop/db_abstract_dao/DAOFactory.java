package Shop.db_abstract_dao;

import Shop.CustomExceptions.PersistException;
import Shop.db.ProductDAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface DAOFactory<Context> {

    interface DAOCreator<Context>{
        public GenericDAO create(Context context);
    }

    Context getContext() throws PersistException;

    GenericDAO getDAO(Context context, Class classDAO) throws PersistException;
}