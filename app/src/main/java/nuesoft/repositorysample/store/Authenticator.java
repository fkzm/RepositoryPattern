package nuesoft.repositorysample.store;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

import mobile.utility.JwtTokenHelper;
import nuesoft.repositorysample.MyApp;
import nuesoft.repositorysample.exception.AuthenticationRequiredError;
import nuesoft.repositorysample.model.Member;
import nuesoft.repositorysample.webService.MyRequest;
import nuesoft.repositorysample.webService.Response;
import okhttp3.Headers;

public class Authenticator {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor sharedPreferencesEditor;
    private static String tokenRequestHeaderKey = "Authorization";
    private static String tokenLocalStorageKey = "token";
    private static String tokenResponseHeaderKey = "X-New-JWT-Token";
    private boolean isAuthenticated;
    private String token;
    private static Authenticator authenticator;
    private Member member;

    public Authenticator() {

    }

    public static Authenticator getAuthenticator() {
        if (authenticator == null) {
            return new Authenticator(tokenRequestHeaderKey, tokenLocalStorageKey, tokenResponseHeaderKey, MyApp.getInstance());
        }
        return authenticator;
    }

    public Authenticator(String tokenRequestHeaderKey1, String tokenLocalStorageKey1, String tokenResponseHeaderKey1, Context context) {

        tokenRequestHeaderKey = tokenRequestHeaderKey1;
        tokenLocalStorageKey = tokenLocalStorageKey1;
        tokenResponseHeaderKey = tokenResponseHeaderKey1;
        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();
        this.member = null;
    }

    public void setToken(String token) {
        this.token = token;
        sharedPreferencesEditor.putString(tokenLocalStorageKey, token);
        sharedPreferencesEditor.apply();
        createMember();

    }

    public void createMember() {
        Map<String, Object> jwtTokenBody = JwtTokenHelper.getTokenBody(this.token);
        String fullName = (String) jwtTokenBody.get("name");
        int id = (int) jwtTokenBody.get("id");
        this.member = new Member(id, fullName);
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
        this.member = null;
    }

    public void addAuthenticationHeader(MyRequest myRequest) throws AuthenticationRequiredError {

        if (!this.isAuthenticated) {
            throw new AuthenticationRequiredError();
        }

        Headers.Builder headers = new Headers.Builder();
        headers.add("Bearer " + getJwtToken());
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
        return this.member != null;
    }


//    public void deleteRefreshToken() {
//
//        sharedPreferencesEditor.remove(tokenSharedPreferencesKey);
//        sharedPreferencesEditor.apply();
//    }
}