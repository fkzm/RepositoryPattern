package nuesoft.repositorysample.store;

import java.util.HashMap;
import java.util.Map;

import nuesoft.repositorysample.MyApp;
import nuesoft.repositorysample.repository.RestAdapter;
import nuesoft.repositorysample.repository.base.IAdapter;

/**
 * Created by mysterious on 8/14/17.
 */


public class Store {

    private static Store store = null;
    private static IAdapter _currentAdapter;
    private static Map<String, IAdapter> _adaptersMap;
    private static boolean _isConnectedToInternet = true;


    private Store() {

    }

    public static Store getInstance() {
        if (store == null) {
            store = new Store();
            Map<String, IAdapter> adapterMap = new HashMap<>();
            adapterMap.put("REST", new RestAdapter("https://nc.carrene.com/apiv1/", "token", Authenticator.getAuthenticator()
            ));
            registerAdapters(adapterMap);
        }
        return store;
    }

    private static void registerAdapters(Map<String, IAdapter> adapterMap) {
        _adaptersMap = adapterMap;
    }

    public IAdapter getCurrentAdapter() {

        if (_isConnectedToInternet) {
            _currentAdapter = _adaptersMap.get("REST");

        } else {
            _currentAdapter = _adaptersMap.get("REALM");
        }
        return _currentAdapter;
    }

    public void setAdapter(IAdapter adapter) {
        _currentAdapter = adapter;
    }

    public Map<String, IAdapter> getAdapters() {
        return _adaptersMap;
    }

    public IAdapter getAdapter(String adapterMapName) {
        return _adaptersMap.get(adapterMapName);
    }
}