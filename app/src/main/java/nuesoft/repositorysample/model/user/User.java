package nuesoft.repositorysample.model.user;

import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import nuesoft.repositorysample.Repository.RepositoryType;
import nuesoft.repositorysample.Repository.base.BaseAdapter;
import nuesoft.repositorysample.Repository.user.UserAdapter;
import nuesoft.repositorysample.Repository.user.UserRealmAdapter;
import nuesoft.repositorysample.Repository.user.UserRestAdapter;
import nuesoft.repositorysample.Repository.user.UserSqlAdapter;
import nuesoft.repositorysample.exception.StoreException;
import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.store.UserStore;

/**
 * Created by mysterious on 8/14/17.
 */

public class User extends RealmObject implements BaseModel {

    @PrimaryKey
    private int _nationalCode;
    private String _name;
    private int _age;

    @Ignore
    private UserStore _userStore;

    public int getNationalCode() {
        return _nationalCode;
    }

    public String getName() {
        return _name;
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

    @Override
    public void sync(Map<String, BaseAdapter> userAdapterMap) {

    }

    @Override
    public void migrate(BaseAdapter destinationAdapter) {

        this._userStore.migrate((UserAdapter) destinationAdapter);

    }

    public User() {

    }

    private User(UserAdapter.UserCallBack userCallBack) {

        UserStore userStore = new UserStore();

        Map<String, UserAdapter> userAdapterMap = new HashMap<>();

        userAdapterMap.put(RepositoryType.REST.toString(), new UserRestAdapter(userCallBack));
        userAdapterMap.put(RepositoryType.SQL.toString(), new UserSqlAdapter(userCallBack));
        userAdapterMap.put(RepositoryType.REALM.toString(), new UserRealmAdapter(userCallBack));

        userStore.registerAdapters(userAdapterMap);
        userStore.chooseCurrentAdapter();

        this._userStore = userStore;
    }

//    private User(ResponseCallBack userCallBack) {
//
//        UserStore userStore = new UserStore();
//
//        Map<String, UserAdapter> userAdapterMap = new HashMap<>();
//
//        userAdapterMap.put(RepositoryType.REST.toString(), new UserRestAdapter(userCallBack));
//        userAdapterMap.put(RepositoryType.SQL.toString(), new UserSqlAdapter(userCallBack));
//
//        userStore.registerAdapters(userAdapterMap);
//        userStore.chooseCurrentAdapter();
//
//        this._userStore = userStore;
//    }

    public User(String _name, int _age, UserAdapter.UserCallBack userCallBack) {

        this(userCallBack);
        this._name = _name;
        this._age = _age;
    }

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
        this._userStore.create(this);
    }

    public void remove() throws StoreException {
        this._userStore.delete(this);
    }

    public void getAll() {
        this._userStore.getAll();
    }

    public UserStore getUserStore() {
        return _userStore;
    }


}
