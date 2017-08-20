package nuesoft.repositorysample.Repository;

import java.util.ArrayList;
import java.util.List;

import nuesoft.repositorysample.Repository.base.BaseAdapter;
import nuesoft.repositorysample.model.user.User;
import nuesoft.repositorysample.webService.ApiClient;
import nuesoft.repositorysample.webService.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mysterious on 8/14/17.
 */

public class RestAdapter implements BaseAdapter {

    @Override
    public <T> void create(T model, final ResponseCallBack responseCallBack) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        apiInterface.signIn("", "").enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                List<User> userList = new ArrayList<User>();

                if (response.isSuccessful()) {
                    userList.add(response.body());
                }


                ResponseResult<User> r = new ResponseResult<>(response.code(), userList);
                responseCallBack.onResponse(r);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                responseCallBack.onFailure(t);

            }
        });
    }

    @Override
    public <T> List<T> getAll(T model) {
        return null;
    }

    @Override
    public <T> T getOne(T model) {
        return null;
    }

    @Override
    public <T> T update(T model) {
        return null;

    }

    @Override
    public <T> T delete(T model) {
        return null;
    }

    @Override
    public <T> String getUrlFromModel(T model) {
        return null;
    }

//
//    protected String getUrlForModel(modelType) {
//        throws new sun.reflect.generics.reflectiveObjects.NotImplementedException()
//    }
//
//
//    public RestAdapter(UserCallBack userCallBack) {
//        super(userCallBack);
//    }
//
//    @Override
//    public void create(User model) {
//        _apiInterface = ApiClient.getClient().create(ApiInterface.class);
//
//        _apiInterface.signIn("", "").enqueue(new Callback<ResponseBody>() {
//
//            @Override
//            public void onResponse(Call<ResponseBody> call, ResponseResult<ResponseBody> response) {
//                _userCallBack.createUserResult(true);
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                _userCallBack.createUserResult(false);
//            }
//        });
//    }


//    @Override
//    void create(final User user) {
//
//        System.out.println("create user in rest: " + user.getName());
//
//        _apiInterface = ApiClient.getClient().create(ApiInterface.class);
//
//        _apiInterface.signIn("", "").enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, ResponseResult<ResponseBody> response) {
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

}



