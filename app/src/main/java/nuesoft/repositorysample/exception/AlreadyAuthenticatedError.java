package nuesoft.repositorysample.exception;

/**
 * Created by mysterious on 8/27/17.
 */
public class AlreadyAuthenticatedError extends Exception {
    public AlreadyAuthenticatedError() {
        super("Already Authenticated.");
    }
}
