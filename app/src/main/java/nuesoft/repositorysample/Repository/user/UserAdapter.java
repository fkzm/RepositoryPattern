package nuesoft.repositorysample.Repository.user;

import java.util.List;

import nuesoft.repositorysample.Repository.base.BaseAdapter;
import nuesoft.repositorysample.model.user.User;

/**
 * Created by mysterious on 8/14/17.
 */

public abstract class UserAdapter extends BaseAdapter<User> {

    UserAdapter.UserCallBack _userCallBack;

    UserAdapter(UserAdapter.UserCallBack userCallBack) {
        _userCallBack = userCallBack;
    }


    public interface UserCallBack {

        void createUserResult(boolean result);

        void getAllUserResult(List<User> userList);

        void deleteUser(boolean result);
    }

//    abstract User getUserById(int id);


}
