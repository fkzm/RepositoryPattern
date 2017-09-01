package nuesoft.repositorysample;

import nuesoft.repositorysample.repository.RestAdapter;
import nuesoft.repositorysample.store.Authenticator;

/**
 * Created by mysterious on 9/1/17.
 */

public class MockUpRestAdapter extends RestAdapter {

    public MockUpRestAdapter() {
        super("https://nc.carrene.com", "token", Authenticator.getAuthenticator());
    }
}
