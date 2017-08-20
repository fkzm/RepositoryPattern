package nuesoft.repositorysample.store;

import java.util.List;
import java.util.Map;

import nuesoft.repositorysample.Repository.base.BaseAdapter;
import nuesoft.repositorysample.Repository.RepositoryType;
import nuesoft.repositorysample.Repository.ResponseCallBack;
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

    private static BaseAdapter _currentAdapter;
    private static Map<String, BaseAdapter> _adapterMap;

    private static boolean _isConnectedToInternet = true;

    public void registerAdapters(Map<String, BaseAdapter> adapterMap) {
        _adapterMap = adapterMap;
        chooseCurrentAdapter();
    }

    private static void chooseCurrentAdapter() {

        if (_isConnectedToInternet) {
            _currentAdapter = _adapterMap.get(RepositoryType.REST.toString());

        } else {
            _currentAdapter = _adapterMap.get(RepositoryType.REALM.toString());
        }
    }

    public <T> void create(T model, ResponseCallBack responseCallBack) {
        _currentAdapter.create(model, responseCallBack);
    }

    public <T> T delete(T model) {
        return _currentAdapter.delete(model);
    }

    public <T> T getOne(T model) {
        return _currentAdapter.getOne(model);
    }

    public <T> List<T> getAll(T model) {
        return _currentAdapter.getAll(model);
    }

    public void migrate(BaseAdapter destinationUserAdapter) {
        _currentAdapter = destinationUserAdapter;
    }

    public void sync(User user, Map<String, BaseAdapter> destinationAdapterList) {

        for (BaseAdapter userAdapter : destinationAdapterList.values()) {
            userAdapter.update(user.getClass());
        }
    }

    public Map<String, BaseAdapter> getAdapters() {
        return _adapterMap;
    }

    public BaseAdapter getCurrentAdapter() {
        return _currentAdapter;
    }
}