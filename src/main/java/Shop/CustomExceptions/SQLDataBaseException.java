package Shop.CustomExceptions;

import java.sql.SQLException;

/**
 * Created by employee on 3/14/16.
 */
public class SQLDataBaseException extends SQLException {
    public SQLDataBaseException(String message){
        System.out.println(message);
    }
}
