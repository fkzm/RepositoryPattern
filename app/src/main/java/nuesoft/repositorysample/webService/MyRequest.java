package nuesoft.repositorysample.webService;

import android.util.Log;

import com.google.gson.Gson;

import org.jdeferred.Deferred;
import org.jdeferred.impl.DeferredObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import nuesoft.repositorysample.exception.AuthenticationRequiredError;
import nuesoft.repositorysample.repository.Processor;
import nuesoft.repositorysample.repository.RestAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by mysterious on 8/24/17.
 */


public class MyRequest {

    String resource = "session";
    RestAdapter restAdapter;
    String verb = "get";
    Map<String, Object> payload;
    public Headers headers;
    Map<String, String> queryString;
    String encoding = "json";

    Processor processor;

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public MyRequest(RestAdapter restAdapter, String resource, String verb, Map<String, Object> payload, Map<String, String> queryString, String encoding) {
        this.restAdapter = restAdapter;
        this.resource = resource;
        this.verb = verb;
        this.payload = payload;
        this.queryString = queryString;
        this.encoding = encoding;
    }

    public MyRequest(RestAdapter restAdapter, String resource, String verb) {
        this.restAdapter = restAdapter;
        this.resource = resource;
        this.verb = verb;
    }

    public MyRequest addQueryString(String key, String value, boolean allowDuplicate) {
        this.queryString.put(key, value);
        return this;
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

    public String getUrl() {
        try {
            URL mergedURL = new URL(this.restAdapter.getBaseUrl() + this.resource);
            return mergedURL.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MyRequest addAuthenticationHeaders(boolean force) throws AuthenticationRequiredError {
        if (this.restAdapter.getAuthenticator().isAuthenticated()) {
            this.restAdapter.getAuthenticator().addAuthenticationHeader(this);
        } else if (force) {
            throw new AuthenticationRequiredError();
        }
        return this;
    }

    public MyRequest filter(String field, Object expression) {

        this.addQueryString(field, expression.toString(), true);
        return this;
    }

    public MyRequest filter(HashMap<String, Object> filters) {
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            this.addQueryString(entry.getKey(), entry.getValue().toString(), true);
        }
        return this;
    }

    public MyRequest setPostProcessor(Processor processor) {
        this.processor = processor;
        return this;
    }

    public MyRequest removeAuthenticationHeaders() {
        this.restAdapter.getAuthenticator().removeAuthenticationHeaders(this);
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

    public Deferred send() {

        final Deferred<Response, Response, Response> deferred = new DeferredObject<Response, Response, Response>();

        OkHttpClient client = new OkHttpClient();

        Request.Builder requestBuilder = new Request.Builder();

        if (this.headers != null) {
            requestBuilder.headers(this.headers);
        }

        RequestBody requestBody = RequestBody.create(JSON, getJson());

        String url = getUrl();

        requestBuilder.method(this.verb.toUpperCase(), requestBody).url(url);

        client.newCall(requestBuilder.build()).enqueue(new Callback() {

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                Response response2 = new Response(response);
                deferred.resolve(response2);
                Log.d("", "");

            }

            @Override
            public void onFailure(Call call, IOException e) {
                Response response2 = new Response(e);
                deferred.reject(response2);

            }


        });

        return deferred;
    }
}
