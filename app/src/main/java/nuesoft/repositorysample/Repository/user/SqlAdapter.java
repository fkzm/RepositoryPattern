package nuesoft.repositorysample.Repository.user;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import nuesoft.repositorysample.Repository.base.BaseAdapter;
import nuesoft.repositorysample.model.user.User;

/**
 * Created by mysterious on 8/14/17.
 */

public class SqlAdapter implements BaseAdapter {
    @Override
    public <T> void create(T model) {

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


//    public SqlAdapter(UserCallBack userCallBack) {
//        super(userCallBack);
//    }
//
//    @Override
//    public void create(User model) {
//        System.out.println("User has created in sql: " + model.getName());
//
//    }
//
//    @Override
//    public void update(User model) {
//        System.out.println("User has updated in sql: " + model.getName());
//
//    }
//
//    @Override
//    public List<User> getAll() {
//        return null;
//    }
//
//    @Override
//    public void remove(User model) {
//        System.out.println("User has removed in sql: " + model.getName());
//    }

}
