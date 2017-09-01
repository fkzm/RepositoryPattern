package nuesoft.repositorysample.model.base;

import com.google.gson.Gson;

import org.jdeferred.Deferred;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nuesoft.repositorysample.exception.ModelStateError;
import nuesoft.repositorysample.repository.base.BaseCRUDProvider;
import nuesoft.repositorysample.repository.base.IAdapter;
import nuesoft.repositorysample.store.Store;

/**
 * Created by mysterious on 8/15/17.
 */

public abstract class BaseModel implements BaseCRUDProvider {

    public static String url;

    public abstract String getTableName();

    public abstract Metadata getMetadata();

    protected String status;
    public Map<String, Object> primaryKeys;
    private String eTag;
    private int hash;
    private int serverHash;
    protected IAdapter adapter;

    public BaseModel() {
        this.status = "new";
        this.eTag = null;
        this.hash = 0;
        this.serverHash = 0;
    }

    public BaseModel(IAdapter iAdapter) {
        this();
        this.adapter = iAdapter;
    }

    public String getStatus() {
        return status;
    }

    public String geteTag() {
        return eTag;
    }

    public void setAdapter(IAdapter adapter) {
        this.adapter = adapter;
        Store.getInstance().setAdapter(adapter);
    }

    public IAdapter getAdapter() {
        return this.adapter;
    }

    public String getResourcePath() {
        //change to java 8 stream
        String resource = "";
        for (Object object : getIdentity()) {
            resource += (String) object + "\\";
        }
        return url + "\\" + resource;
    }

    public List<Object> getIdentity() {
        return (List<Object>) this.primaryKeys.values();
    }

    @Override
    public <T extends BaseModel> Deferred delete(T model) throws ModelStateError {
        return this.getAdapter().delete(model);
    }

    @Override
    public <T extends BaseModel> Deferred save(T model) throws ModelStateError {
        return this.getAdapter().save(model);
    }

    public static <T extends BaseModel> void getOne(int id) {
//        Store.getInstance().getCurrentAdapter().getAll(responseCallBack);
    }

    public static <T extends BaseModel> T getObject(String body, Type type) {
        Gson gson = new Gson();
        T t = gson.fromJson(body, type);
        return t;
    }

    public void updateProperties(HashMap<String, Object> values) {

        for (String key : values.keySet()) {
            try {
                Field field = this.getClass().getDeclaredField(key);
                field.setAccessible(true);
                field.set(this, values.get(key));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public HashMap<String, Object> toHashMap() {

        HashMap<String, Object> hashMap = new HashMap<>();

        for (MyField myField : this.getMetadata().getMyFields()) {

//            String methodName = "get" + Character.toUpperCase(myField.getName().charAt(0)) + myField.getName().substring(1);
//
//            try {
//                Method method = this.getClass().getMethod(methodName);
//                Object object = method.invoke(this);
//                String value = object.toString();

            Field filed = null;
            try {
                filed = this.getClass().getDeclaredField(myField.getName());
                filed.setAccessible(true);
                Object object = filed.get(this);
                hashMap.put(myField.getName(), object);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }
}
