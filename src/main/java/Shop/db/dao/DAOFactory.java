package Shop.db.dao;

import Shop.CustomExceptions.PersistException;

public interface DAOFactory<Context> {

    interface DAOCreator<Context>{
        public GenericDAO create(Context context);
    }

    Context getContext() throws PersistException;

    GenericDAO getDAO(Context context, Class classDAO) throws PersistException;
}