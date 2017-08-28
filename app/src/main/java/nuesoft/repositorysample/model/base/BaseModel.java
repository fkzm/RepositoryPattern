package nuesoft.repositorysample.model.base;

import com.google.gson.Gson;

import org.jdeferred.Deferred;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;

import nuesoft.repositorysample.exception.ModelStateError;
import nuesoft.repositorysample.repository.base.BaseCRUDProvider;
import nuesoft.repositorysample.repository.base.IAdapter;
import nuesoft.repositorysample.store.Store;
import nuesoft.repositorysample.webService.MyRequest;

/**
 * Created by mysterious on 8/15/17.
 */

public abstract class BaseModel implements BaseCRUDProvider {

    public static String url;

    public abstract String getTableName();

    public abstract Metadata getMetadata();

    public String status;

    public void setAdapter(IAdapter adapter) {
        this.adapter = adapter;
        Store.getInstance().setAdapter(adapter);
    }

    protected IAdapter adapter;

    public BaseModel() {

    }

    public BaseModel(IAdapter iAdapter) {
        this.adapter = iAdapter;
    }

    public IAdapter getAdapter() {
        return this.adapter;
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
