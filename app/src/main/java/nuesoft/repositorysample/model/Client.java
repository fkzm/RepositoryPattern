package nuesoft.repositorysample.model;

import java.util.Map;

import nuesoft.repositorysample.store.Authenticator;
import nuesoft.repositorysample.webService.MyRequest;

/**
 * Created by mysterious on 8/24/17.
 */

public class Client {

    private String baseUrl;
    private String tokenLocalStorageKey;
    public Authenticator authenticator;

    public Client(String baseUrl, String tokenLocalStorageKey, Authenticator authenticator) {
        this.baseUrl = baseUrl;
        this.tokenLocalStorageKey = tokenLocalStorageKey;
        this.authenticator = authenticator;

    }

    public void login(Map<String, Object> credentials) {
//        this.request("", "").addParameters(credentials).send();
    }

    public void logout() {
        this.authenticator.deleteJwtToken();

    }

    public MyRequest request(Object... args) {
        return new MyRequest(this).addAuthenticationHeaders(false);
    }
}
