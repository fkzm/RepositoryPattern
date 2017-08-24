package nuesoft.repositorysample.webService;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import nuesoft.repositorysample.MyApp;
import okhttp3.*;

/**
 * Created by mysterious on 8/24/17.
 */

public class MyRequest {

    String verb;
    String encoding;
    String resource;
    Map<String, Object> payload;
    Map<String, String> queryString;
    Client client;
    public Headers headers;

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

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

    public MyRequest setHeader(Headers headers) {
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

    public String getJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this.payload);
        return json;
    }

    public MyRequest addAuthenticationHeaders(boolean force) {
        if (this.client.getAuthenticator().isAuthenticated()) {
            this.client.getAuthenticator().addAuthenticationHeader(this);
        } else if (force) {
//            throw new AuthenticationRequiredError()
        }
        return this;
    }

    public MyRequest removeAuthenticationHeaders() {
        this.client.getAuthenticator().removeAuthenticationHeaders(this);
        return this;
    }

    public MyRequest addParameter(String key, Object value) {
        Map<String, Object> paramterMap = new HashMap<>();
        paramterMap.put(key, value);
        addParameters(paramterMap);
        return this;
    }

    public MyRequest addParameters(Map<String, Object> payload) {
        this.payload = payload;
        return this;
    }

    public void send() {

        OkHttpClient client = new OkHttpClient();

        Request.Builder requestBuilder = new Request.Builder();

        requestBuilder.headers(this.headers);

        RequestBody requestBody = RequestBody.create(JSON, getJson());

        requestBuilder.method(this.verb, requestBody);

        ApiClient.getClient(MyApp.getInstance()).newCall(requestBuilder.build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {

            }
        });

    }
}
