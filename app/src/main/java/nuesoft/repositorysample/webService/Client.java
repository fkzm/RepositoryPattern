package nuesoft.repositorysample.webService;

import java.util.Map;

import nuesoft.repositorysample.store.Authenticator;
import nuesoft.repositorysample.webService.MyRequest;
import okhttp3.OkHttpClient;

/**
 * Created by mysterious on 8/24/17.
 */

public class Client {

    private String baseUrl;
    private String tokenLocalStorageKey;

    public static Authenticator authenticator;

    private OkHttpClient okHttpClient;


    public Client(String baseUrl, String tokenLocalStorageKey, Authenticator authenticator1) {
        this.baseUrl = baseUrl;
        this.tokenLocalStorageKey = tokenLocalStorageKey;
        authenticator = authenticator1;

    }

    public Authenticator getAuthenticator() {
        if (authenticator == null) {
            authenticator = new Authenticator();
        }
        return authenticator;
    }

    public void login(Map<String, Object> credentials) {
//        this.request("", "").addParameters(credentials).send();
    }

    public void logout() {
        authenticator.deleteJwtToken();

    }

    public MyRequest request(Object... args) {
        return new MyRequest(this).addAuthenticationHeaders(false);
    }
}
