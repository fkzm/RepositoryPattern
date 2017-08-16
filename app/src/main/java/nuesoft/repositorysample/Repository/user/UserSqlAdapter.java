package nuesoft.repositorysample.Repository.user;

import java.util.List;

import nuesoft.repositorysample.model.user.User;

/**
 * Created by mysterious on 8/14/17.
 */

public class UserSqlAdapter extends UserAdapter {


    public UserSqlAdapter(UserCallBack userCallBack) {
        super(userCallBack);
    }

    @Override
    public void create(User model) {
        System.out.println("User has created in sql: " + model.getName());

    }

    @Override
    public void update(User model) {
        System.out.println("User has updated in sql: " + model.getName());

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void remove(User model) {
        System.out.println("User has removed in sql: " + model.getName());
    }

}
