package nuesoft.repositorysample.store;

import java.util.HashMap;
import java.util.Map;

import nuesoft.repositorysample.Repository.RealmAdapter;
import nuesoft.repositorysample.Repository.RestAdapter;
import nuesoft.repositorysample.Repository.base.BaseAdapter;
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
            Map<String, BaseAdapter> adapterMap = new HashMap<>();
            adapterMap.put("REST", new RestAdapter());
            adapterMap.put("REALM", new RealmAdapter());
            registerAdapters(adapterMap);
        }

        return store;
    }

    private static BaseAdapter _currentAdapter;
    private static Map<String, BaseAdapter> _adapterMap;
    private static boolean _isConnectedToInternet = true;

    public static void registerAdapters(Map<String, BaseAdapter> adapterMap) {
        _adapterMap = adapterMap;
    }

    public BaseAdapter getCurrentAdapter() {

        if (_isConnectedToInternet) {
            _currentAdapter = _adapterMap.get("REST");

        } else {
            _currentAdapter = _adapterMap.get("REALM");
        }
        return _currentAdapter;
    }
}