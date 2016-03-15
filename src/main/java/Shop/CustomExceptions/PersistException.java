package Shop.CustomExceptions;

/**
 * Created by Денис on 15.03.2016.
 */
public class PersistException extends Exception {
    public PersistException(){
    }

    public PersistException(String message){
        super(message);
    }

    public PersistException(Throwable cause) {
        super(cause);
    }

}
