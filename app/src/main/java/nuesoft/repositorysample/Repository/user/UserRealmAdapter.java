package nuesoft.repositorysample.Repository.user;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import nuesoft.repositorysample.model.user.User;

/**
 * Created by mysterious on 8/16/17.
 */

public class UserRealmAdapter extends UserAdapter {

    private Realm _realm;

    public UserRealmAdapter(UserCallBack userCallBack) {
        super(userCallBack);
        _realm = Realm.getDefaultInstance();

    }

    @Override
    public void create(User model) {

        _realm.beginTransaction();
        _realm.copyToRealm(model);
        _realm.commitTransaction();
    }

    @Override
    public void update(User model) {

        _realm.beginTransaction();
        _realm.copyToRealmOrUpdate(model);
        _realm.commitTransaction();
    }

    @Override
    public List<User> getAll() {

        List<User> userList = new ArrayList<>();
        RealmResults<User> userRealmResult = _realm.where(User.class).findAll();
        userList.addAll(_realm.copyFromRealm(userRealmResult));
        return userList;
    }

    @Override
    public void remove(User model) {

        User user = _realm.where(User.class).equalTo("_id", model.getNationalCode()).findFirst();
        user.deleteFromRealm();
    }
}