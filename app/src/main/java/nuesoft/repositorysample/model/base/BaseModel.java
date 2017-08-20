package nuesoft.repositorysample.model.base;

import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.RealmModel;
import nuesoft.repositorysample.Repository.ResponseCallBack;
import nuesoft.repositorysample.Repository.base.BaseAdapter;
import nuesoft.repositorysample.store.Store;

/**
 * Created by mysterious on 8/15/17.
 */

public abstract class BaseModel implements RealmModel {

    public abstract String getUrl();

    public abstract Metadata getMetadata();

    private BaseAdapter adapter;

    public BaseModel() {

    }

    public BaseModel(BaseAdapter baseAdapter) {
        this.adapter = baseAdapter;
    }

    public BaseAdapter getAdapter() {
        return this.adapter;
    }

    private <T extends BaseModel> void save(T model, ResponseCallBack responseCallBack) {
        Store.getInstance().getCurrentAdapter().save(model, responseCallBack);
    }

    public <T extends BaseModel> void update(T model, ResponseCallBack responseCallBack) {
        Store.getInstance().getCurrentAdapter().delete(model, responseCallBack);
    }

    public <T extends BaseModel> void delete(T model, ResponseCallBack responseCallBack) {
        Store.getInstance().getCurrentAdapter().delete(model, responseCallBack);
    }

    public static <T> List<T> getAll(ResponseCallBack responseCallBack) {
        return Store.getInstance().getCurrentAdapter().getAll(responseCallBack);
    }

    public static <T> List<T> getOne(int id, ResponseCallBack responseCallBack) {
        return Store.getInstance().getCurrentAdapter().getOne(id, responseCallBack);
    }

    public HashMap<String, Object> toHashMap() {

        HashMap<String, Object> hashMap = new HashMap<>();

        for (Field field : this.getMetadata().getFields()) {

            String methodName = "get" + Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1);
            try {
                Method method = this.getClass().getMethod(methodName);
                Object object = method.invoke(this);
                Log.d("name", "" + object.toString());
                hashMap.put(field.getTitle(), object);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }


    public abstract void sync(Map<String, BaseAdapter> userAdapterMap);

    public abstract void migrate(BaseAdapter destinationAdapter);

//    abstract Metadata getMetaData();
//
//    Dictionary<String, Object> toJson() {
//        Dictionary<String, Object> result = new Dictionary<String, Object>()
//        for(Field field in this.getMetaData().fields) {
//            String methodName = "get" + capitalize(field.name)
//            Object value = getattr(this, methodName);
//            result.add(field.key, value)
//        }
//        return result
//    }

}
