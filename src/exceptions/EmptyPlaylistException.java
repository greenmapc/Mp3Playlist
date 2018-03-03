package exceptions;

/**
 * User: Anna Kuzmenko
 */
public class EmptyPlaylistException extends Exception {
    public EmptyPlaylistException(String message) {
        super(message);
    }
}
