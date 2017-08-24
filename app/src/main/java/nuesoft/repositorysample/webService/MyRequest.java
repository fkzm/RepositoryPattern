package nuesoft.repositorysample.webService;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import nuesoft.repositorysample.model.Client;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by mysterious on 8/24/17.
 */

public class MyRequest {

    String verb;
    String encoding;
    String resource;
    Map<String, Object> payload;
    Map<String, String> queryString;
    public Map<String, Object> headers;
    Client client;

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public MyRequest(Client client) {
        this.client = client;
    }

    public void addQueryString(String key, String value, boolean allowDuplicate) {
        this.queryString.put(key, value);
    }

    public MyRequest setVerb(String verb) {
        this.verb = verb;
        return this;
    }

    public MyRequest setEncoding(String encoding) {
        this.encoding = encoding;
        return this;
    }

    public MyRequest setHeader(Map<String, Object> headers) {
        this.headers = headers;
        return this;
    }

    public MyRequest sort(String id) {
        this.addQueryString("sort", id, false);
        return this;
    }

    public MyRequest take(int take) {
        this.addQueryString("take", "" + take, false);
        return this;
    }

    public MyRequest skip(String skip) {
        this.addQueryString("skip", skip, false);
        return this;
    }

    public void send() {

        OkHttpClient client = new OkHttpClient();

        Request.Builder requestBuilder = new Request.Builder();

        for (Map.Entry<String, Object> header : this.headers.entrySet()) {
            requestBuilder.addHeader(header.getKey(), "" + header.getValue());
        }

        RequestBody requestBody = RequestBody.create(JSON, getJson());
        requestBuilder.method(this.verb, requestBody);

//        client.interceptors().add(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                return null;
//            }
//        });
    }

    public String getJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this.payload);
        return json;
    }

    public MyRequest addAuthenticationHeaders(boolean force) {
        if (this.client.authenticator.isAuthenticated()) {
            this.client.authenticator.addAuthenticationHeader(this);
        } else if (force) {
//            throw new AuthenticationRequiredError()
        }
        return this;
    }

    public MyRequest addParameters(Map<String, Object> payload) {
        this.payload = payload;
        return this;
    }
}
