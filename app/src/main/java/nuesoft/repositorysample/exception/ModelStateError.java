package nuesoft.repositorysample.exception;

/**
 * Created by mysterious on 8/27/17.
 */

public class ModelStateError extends Exception {

    public ModelStateError(String error) {
        super(error);
    }
}
