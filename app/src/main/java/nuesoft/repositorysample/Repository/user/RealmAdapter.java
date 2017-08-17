package nuesoft.repositorysample.Repository.user;

import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import nuesoft.repositorysample.Repository.base.BaseAdapter;
import nuesoft.repositorysample.model.user.User;

/**
 * Created by mysterious on 8/16/17.
 */

public class RealmAdapter implements BaseAdapter {

    private Realm _realm;

    @Override
    public <T> void create(T model) {
        Method method = null;
        try {


            method = model.getClass().getMethod("getName");
            String name = (String) method.invoke(model);
            Log.d("name", "" + name);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> List<T> get(T model) {
        return null;
    }

    @Override
    public <T> T getOne(T model) {
        return null;
    }

    @Override
    public <T> void update(T model) {

    }

    @Override
    public <T> void delete(T model) {

    }

    @Override
    public <T> String getUrlFromModel(T model) {
        return null;
    }

//    @Override
//    public <T> void create(Class<T> model) {
//        try {
//            Method method = model.getClass().getMethod("getAge");
//            int name = (int) method.invoke(model);
//            Log.d("name", ""+name);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public <T> List<T> get(Class<T> model) {
//        return null;
//    }
//
//    @Override
//    public <T> T getOne(Class<T> model) {
//        return null;
//    }
//
//    @Override
//    public <T> void update(Class<T> model) {
//
//    }
//
//    @Override
//    public <T> void delete(Class<T> model) {
//
//    }
//
//    @Override
//    public <T> String getUrlFromModel(Class<T> model) {
//        return null;
//    }

//    public RealmAdapter(UserAdapter.UserCallBack userCallBack) {
//        super(userCallBack);
//        _realm = Realm.getDefaultInstance();
//
//    }

//    @Override
//    public void create(User model) {
//
//        _realm.beginTransaction();
//        _realm.copyToRealm(model);
//        _realm.commitTransaction();
//    }
//
//    @Override
//    public void update(User model) {
//
//        _realm.beginTransaction();
//        _realm.copyToRealmOrUpdate(model);
//        _realm.commitTransaction();
//    }
//
//    @Override
//    public List<User> getAll() {
//
//        List<User> userList = new ArrayList<>();
//        RealmResults<User> userRealmResult = _realm.where(User.class).findAll();
//        userList.addAll(_realm.copyFromRealm(userRealmResult));
//        return userList;
//    }
//
//    @Override
//    public void remove(User model) {
//
//        User user = _realm.where(User.class).equalTo("_id", model.getNationalCode()).findFirst();
//        user.deleteFromRealm();
//    }
}