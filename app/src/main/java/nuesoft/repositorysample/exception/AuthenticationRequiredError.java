package nuesoft.repositorysample.exception;

/**
 * Created by mysterious on 8/27/17.
 */

public class AuthenticationRequiredError extends Exception {

    public AuthenticationRequiredError() {
        super("Authentication Required.");
    }
}
