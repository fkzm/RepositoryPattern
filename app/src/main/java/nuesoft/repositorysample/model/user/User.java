package nuesoft.repositorysample.model.user;

import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import nuesoft.repositorysample.Repository.RepositoryType;
import nuesoft.repositorysample.Repository.base.BaseAdapter;
import nuesoft.repositorysample.Repository.user.RealmAdapter;
import nuesoft.repositorysample.Repository.user.RestAdapter;
import nuesoft.repositorysample.Repository.user.SqlAdapter;
import nuesoft.repositorysample.exception.StoreException;
import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.store.Store;

/**
 * Created by mysterious on 8/14/17.
 */

public class User {

    //    @PrimaryKey
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
//
//    @Override
//    public void sync(Map<String, BaseAdapter> userAdapterMap) {
//
//    }
//
//    @Override
//    public void migrate(BaseAdapter destinationAdapter) {
//
////        this._store.migrate((UserAdapter) destinationAdapter);
//
//    }

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

    public void create() {
        Store.getInstance().create(this);
    }

//    public void remove() throws StoreException {
//        this._store.delete(this);
//    }
//
//    public void getAll() {
//        this._store.getAll();
//    }
//
//    public Store getUserStore() {
//        return _store;
//    }

    public static void get() {

        Store.getInstance().getCurrentUserAdapter().get(User.class);
    }

}
