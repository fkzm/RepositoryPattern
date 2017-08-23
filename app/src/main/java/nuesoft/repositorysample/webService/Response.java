package nuesoft.repositorysample.webService;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import nuesoft.repositorysample.model.Code;
import nuesoft.repositorysample.model.User;
import nuesoft.repositorysample.model.base.BaseModel;
import okhttp3.ResponseBody;

/**
 * Created by mysterious on 8/23/17.
 */

public class Response {

    private retrofit2.Response<ResponseBody> responseBody;
    private String body;
    private int status;
    private int identity;
    Type type;


    public Response(retrofit2.Response<ResponseBody> responseBody, Type type) {
        this.responseBody = responseBody;
        this.type = type;
    }

    public retrofit2.Response<ResponseBody> getResponseBody() {
        return responseBody;
    }

    public String getBody() {
        try {
            return this.responseBody.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int getStatus() {
        return status;
    }

    public int getIdentity() {
        return identity;
    }

    public void setResponseBody(retrofit2.Response<ResponseBody> responseBody) {
        this.responseBody = responseBody;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public <T extends BaseModel> T getObject() {
        Gson gson = new Gson();
        T t = gson.fromJson(this.getBody(), this.type);
        return t;
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
        Gson gson = new Gson();

//        Type listType = new TypeToken<List<Code>>() {
//        }.getType();

        List<T> a = new ArrayList<T>();


        List<T> list = gson.fromJson(this.getBody(), a.getClass());
        return list;
    }
}
