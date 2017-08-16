package nuesoft.repositorysample.store;

import java.util.Map;

import nuesoft.repositorysample.Repository.base.BaseAdapter;
import nuesoft.repositorysample.Repository.RepositoryType;
import nuesoft.repositorysample.Repository.user.UserAdapter;
import nuesoft.repositorysample.exception.StoreException;
import nuesoft.repositorysample.model.user.User;

/**
 * Created by mysterious on 8/14/17.
 */

public class UserStore {

    private UserAdapter _currentUserAdapter;
    private Map<String, UserAdapter> _userAdapterMap;

    private boolean _isConnectedToInternet = false;

    public void registerAdapters(Map<String, UserAdapter> userAdapterMap) {
        this._userAdapterMap = userAdapterMap;

    }

    public void chooseCurrentAdapter() {

        if (_isConnectedToInternet) {

            _currentUserAdapter = _userAdapterMap.get(RepositoryType.REST.toString());
        } else {

            _currentUserAdapter = _userAdapterMap.get(RepositoryType.REALM.toString());
        }
    }


    public void create(User user) {
        _currentUserAdapter.create(user);
//        _currentUserAdapter.create(user);
    }

    public void delete(User user) throws StoreException {

        _currentUserAdapter.remove(user);
//        _currentUserAdapter.delete(user);

    }

    public void getAll() {
        _currentUserAdapter.getAll();
//        _currentUserAdapter.getAll();
    }

    public void migrate(UserAdapter destinationUserAdapter) {
        _currentUserAdapter = destinationUserAdapter;
    }

    public void sync(User user, Map<String, BaseAdapter> destinationAdapterList) {

        for (BaseAdapter userAdapter : destinationAdapterList.values()) {
            userAdapter.update(user);
//            userAdapter.updateUser(user);
        }
    }


    public Map<String, UserAdapter> getAdapters() {
        return _userAdapterMap;
    }

    public UserAdapter getCurrentUserAdapter() {
        return _currentUserAdapter;
    }
}