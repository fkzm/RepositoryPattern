package nuesoft.repositorysample.webService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import nuesoft.repositorysample.model.base.BaseModel;
import okhttp3.Headers;

/**
 * Created by mysterious on 8/23/17.
 */

public class Response {

    private okhttp3.Response responseBody;
    private String body;
    private Type type;
    public Headers headers;
    IOException ioException;

    public Response(okhttp3.Response responseBody) {
        this.responseBody = responseBody;
        this.headers = responseBody.headers();
        try {
            this.body = this.responseBody.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Response(IOException ioException) {
        this.ioException = ioException;
    }


    public Response(okhttp3.Response responseBody, Type type) {
        this.responseBody = responseBody;
        this.headers = responseBody.headers();
        this.type = type;
        try {
            this.body = this.responseBody.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getStatus() {

        return this.responseBody.code();
    }

    public String getHeader(String key) {
        return this.responseBody.headers().get(key);
    }

    public String getIdentity() {
        return this.getHeader("X-Identity");
    }

    public boolean isAuthenticated() {
        return getIdentity() != null;
    }

    public String getBody() {
        return this.body;
    }


    public String getField(String name) {

        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(this.getBody());
            String value = (String) jsonObj.get(name);
            return value;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T extends BaseModel> List<T> getList() {

        List<T> modelList = new ArrayList<T>();

        JsonElement outerJson = new JsonParser().parse(this.body);
        JsonArray array = outerJson.getAsJsonArray();
        Iterator iterator = array.iterator();

        while (iterator.hasNext()) {
            JsonElement innerJson = (JsonElement) iterator.next();
            Gson gson = new Gson();
            T code = gson.fromJson(innerJson, this.type);
            modelList.add(code);
        }
        return modelList;
    }

    public HashMap<String, Object> getMap() {

        ObjectMapper mapper = new ObjectMapper();

        HashMap<String, Object> map = new HashMap<String, Object>();

        try {
            map = mapper.readValue(this.getBody(), new TypeReference<Map<String, String>>() {
            });
            return map;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
