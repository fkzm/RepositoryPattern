package nuesoft.repositorysample.model.base;

import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import nuesoft.repositorysample.repository.ResponseCallBack;
import nuesoft.repositorysample.repository.base.BaseCRUDProvider;
import nuesoft.repositorysample.repository.base.IAdapter;
import nuesoft.repositorysample.store.Store;

/**
 * Created by mysterious on 8/15/17.
 */

public abstract class BaseModel implements BaseCRUDProvider {

    public abstract String getUrl();

    public abstract String getTableName();

    public abstract Metadata getMetadata();

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
    public <T extends BaseModel> void save(T model, ResponseCallBack responseCallBack) {
        this.getAdapter().save(model, responseCallBack);
    }

    public static <T extends BaseModel> void getOne(int id, ResponseCallBack responseCallBack) {
//        Store.getInstance().getCurrentAdapter().getAll(responseCallBack);
    }

    public HashMap<String, String> toHashMap() {

        HashMap<String, String> hashMap = new HashMap<>();

        for (MyField myField : this.getMetadata().getMyFields()) {

            String methodName = "get" + Character.toUpperCase(myField.getName().charAt(0)) + myField.getName().substring(1);
            try {
                Method method = this.getClass().getMethod(methodName);
                Object object = method.invoke(this);
                String value = object.toString();
                Log.d("name", "" + object.toString());
                hashMap.put(myField.getName(), value);
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
}
