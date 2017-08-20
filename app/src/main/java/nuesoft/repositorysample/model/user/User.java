package nuesoft.repositorysample.model.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nuesoft.repositorysample.Repository.RepositoryType;
import nuesoft.repositorysample.Repository.base.BaseAdapter;
import nuesoft.repositorysample.Repository.RealmAdapter;
import nuesoft.repositorysample.Repository.RestAdapter;
import nuesoft.repositorysample.Repository.SqlAdapter;
import nuesoft.repositorysample.Repository.ResponseCallBack;
import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.store.Store;

/**
 * Created by mysterious on 8/14/17.
 */

public class User extends BaseModel {

    private int _nationalCode;
    private String _name;
    private int _age;

    public int getNationalCode() {
        return _nationalCode;
    }

    public String getName() {
        return this._name;
    }

    public int getAge() {
        return _age;
    }

    public void setNationalCode(int nationalCode) {
        this._nationalCode = nationalCode;
    }

    public void setName(String name) {
        this._name = name;
    }

    public void setAge(int age) {
        this._age = age;
    }


    public User() {

    }

    public User(String name, int age) {
        this._name = name;
        this._age = age;

        Map<String, BaseAdapter> userAdapterMap = new HashMap<>();
        userAdapterMap.put(RepositoryType.REST.toString(), new RestAdapter());
        userAdapterMap.put(RepositoryType.SQL.toString(), new SqlAdapter());
        userAdapterMap.put(RepositoryType.REALM.toString(), new RealmAdapter());

        Store.getInstance().registerAdapters(userAdapterMap);

    }


    public void create(ResponseCallBack<User> responseCallBack) {
        Store.getInstance().create(this, responseCallBack);
    }

    public User delete() {
        return Store.getInstance().delete(this);
    }

    public static List<User> getAll() {
        return Store.getInstance().getAll(new User());
    }

    public static User getOne() {
        return Store.getInstance().getOne(new User());
    }

    public User update() {
        return Store.getInstance().delete(this);
    }


//    private User(UserAdapter.UserCallBack userCallBack) {
//
//        Store userStore = new Store();
//
//        Map<String, UserAdapter> userAdapterMap = new HashMap<>();
//
//        userAdapterMap.put(RepositoryType.REST.toString(), new RestAdapter(userCallBack));
//        userAdapterMap.put(RepositoryType.SQL.toString(), new SqlAdapter(userCallBack));
//        userAdapterMap.put(RepositoryType.REALM.toString(), new RealmAdapter(userCallBack));
//
//        userStore.registerAdapters(userAdapterMap);
//        userStore.chooseCurrentAdapter();
//
//        this._store = userStore;
//    }

//    private User(ResponseCallBack userCallBack) {
//
//        Store userStore = new Store();
//
//        Map<String, UserAdapter> userAdapterMap = new HashMap<>();
//
//        userAdapterMap.put(RepositoryType.REST.toString(), new RestAdapter(userCallBack));
//        userAdapterMap.put(RepositoryType.SQL.toString(), new SqlAdapter(userCallBack));
//
//        userStore.registerAdapters(userAdapterMap);
//        userStore.chooseCurrentAdapter();
//
//        this._store = userStore;
//    }

//    public User(String _name, int _age, UserAdapter.UserCallBack userCallBack) {
//
//        this(userCallBack);
//        this._name = _name;
//        this._age = _age;
//    }

//    public User(String _name, int _age) {
//        this._name = _name;
//        this._age = _age;
//    }

//    public User(String _name, int _age, ResponseCallBack userCallBack) {
//
//        this(userCallBack);
//        this._name = _name;
//        this._age = _age;
//    }


//
//    public Store getUserStore() {
//        return _store;
//    }


    @Override
    public void sync(Map<String, BaseAdapter> userAdapterMap) {

    }

    @Override
    public void migrate(BaseAdapter destinationAdapter) {

//        this._store.migrate((UserAdapter) destinationAdapter);

    }
}
