package nuesoft.repositorysample.Repository.user;

import java.util.List;

import nuesoft.repositorysample.model.user.User;
import nuesoft.repositorysample.webService.ApiClient;
import nuesoft.repositorysample.webService.ApiInterface;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mysterious on 8/14/17.
 */

public class UserRestAdapter extends UserAdapter {

    private ApiInterface _apiInterface;


    public UserRestAdapter(UserCallBack userCallBack) {
        super(userCallBack);
    }

    @Override
    public void create(User model) {
        _apiInterface = ApiClient.getClient().create(ApiInterface.class);

        _apiInterface.signIn("", "").enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                _userCallBack.createUserResult(true);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                _userCallBack.createUserResult(false);
            }
        });
    }

    @Override
    public void update(User model) {
        System.out.println("User has updated in rest: " + model.getName());

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void remove(User model) {
        System.out.println("User has removed in rest: " + model.getName());

    }


//    @Override
//    void create(final User user) {
//
//        System.out.println("create user in rest: " + user.getName());
//
//        _apiInterface = ApiClient.getClient().create(ApiInterface.class);
//
//        _apiInterface.signIn("", "").enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//                _userCallBack.createUserResult(true);
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//                _userCallBack.createUserResult(false);
//            }
//        });
//    }

//    @Override
//    void delete(User user) throws NoRestStore {
//
//        throw new NoRestStore("No delete in rest");
//    }

}



