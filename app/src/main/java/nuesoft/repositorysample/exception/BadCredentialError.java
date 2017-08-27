package nuesoft.repositorysample.exception;

/**
 * Created by mysterious on 8/27/17.
 */

public class BadCredentialError extends Exception {
    public BadCredentialError() {
        super("Invalid or Bad Credentials.");
    }
}
