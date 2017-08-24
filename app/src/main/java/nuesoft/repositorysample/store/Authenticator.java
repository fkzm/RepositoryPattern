package nuesoft.repositorysample.store;

import android.content.Context;
import android.content.SharedPreferences;

import nuesoft.repositorysample.webService.MyRequest;
import nuesoft.repositorysample.webService.Response;
import okhttp3.Headers;

public class Authenticator {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor sharedPreferencesEditor;
    private String tokenRequestHeaderKey = "Authorization";
    private String tokenLocalStorageKey = "token";
    private String tokenResponseHeaderKey = "X-New-JWT-Token";
    private boolean isAuthenticated;
    private String token;

    public Authenticator() {

    }

    public Authenticator(String tokenRequestHeaderKey, String tokenLocalStorageKey, String tokenResponseHeaderKey, Context context) {

        this.tokenLocalStorageKey = tokenRequestHeaderKey;
        this.tokenLocalStorageKey = tokenLocalStorageKey;
        this.tokenResponseHeaderKey = tokenResponseHeaderKey;
        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();
    }

    public void setToken(String token) {
        sharedPreferencesEditor.putString(tokenLocalStorageKey, token);
        sharedPreferencesEditor.apply();
    }

    public boolean hasJwtToken() {

        String token = sharedPreferences.getString(this.tokenLocalStorageKey, "");
        if (token.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getJwtToken() {

        String token = sharedPreferences.getString(this.tokenLocalStorageKey, "");
        return token;
    }

    public void deleteJwtToken() {

        sharedPreferencesEditor.remove(tokenLocalStorageKey);
        sharedPreferencesEditor.apply();
    }

    public void addAuthenticationHeader(MyRequest myRequest) {

        if (!this.isAuthenticated) {

        }
        Headers.Builder headers = new Headers.Builder();
        headers.add("Bearer " + this.token);
        myRequest.setHeader(headers.build());
    }

    public void removeAuthenticationHeaders(MyRequest myRequest) {
        myRequest.headers.newBuilder().removeAll(this.tokenRequestHeaderKey).build();
    }

    public void checkResponse(Response response) {

        String token = response.headers.get(this.tokenResponseHeaderKey);
        if (token != null) {
            this.token = token;
        }
    }

    public boolean isAuthenticated() {
        return false;
    }


//    public void deleteRefreshToken() {
//
//        sharedPreferencesEditor.remove(tokenSharedPreferencesKey);
//        sharedPreferencesEditor.apply();
//    }
}