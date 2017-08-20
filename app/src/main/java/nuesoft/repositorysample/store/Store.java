package nuesoft.repositorysample.store;

import java.util.List;
import java.util.Map;

import nuesoft.repositorysample.Repository.base.BaseAdapter;
import nuesoft.repositorysample.Repository.RepositoryType;
import nuesoft.repositorysample.exception.StoreException;
import nuesoft.repositorysample.model.user.User;

/**
 * Created by mysterious on 8/14/17.
 */


public class Store {

    private static Store store = null;

    private Store() {

    }

    public static Store getInstance() {

        if (store == null) {
            store = new Store();
        }

        return store;
    }

    private static BaseAdapter _currentUserAdapter;
    private static Map<String, BaseAdapter> _userAdapterMap;

    private static boolean _isConnectedToInternet = false;

    public void registerAdapters(Map<String, BaseAdapter> userAdapterMap) {
        _userAdapterMap = userAdapterMap;
        chooseCurrentAdapter();
    }

    private static void chooseCurrentAdapter() {

        if (_isConnectedToInternet) {

            _currentUserAdapter = _userAdapterMap.get(RepositoryType.REST.toString());

        } else {

            _currentUserAdapter = _userAdapterMap.get(RepositoryType.REALM.toString());
        }
    }


    public <T> T create(T model) {
        return _currentUserAdapter.create(model);
    }

    public <T> T delete(T model) {
        return _currentUserAdapter.delete(model);
    }

    public <T> T getOne(T model) {
        return _currentUserAdapter.getOne(model);
    }

    public <T> List<T> getAll(T model) {
        return _currentUserAdapter.getAll(model);
    }

    public void migrate(BaseAdapter destinationUserAdapter) {
        _currentUserAdapter = destinationUserAdapter;
    }

    public void sync(User user, Map<String, BaseAdapter> destinationAdapterList) {

        for (BaseAdapter userAdapter : destinationAdapterList.values()) {
            userAdapter.update(user.getClass());
//            userAdapter.updateUser(user);
        }
    }

    public Map<String, BaseAdapter> getAdapters() {
        return _userAdapterMap;
    }

    public BaseAdapter getCurrentAdapter() {
        return _currentUserAdapter;
    }
}