package nuesoft.repositorysample.Repository.user;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import nuesoft.repositorysample.Repository.base.BaseAdapter;
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

public class RestAdapter implements BaseAdapter {
    @Override
    public <T> void create(T model) {

    }

    @Override
    public <T> List<T> get(T model) {
        return null;
    }

    @Override
    public <T> T getOne(T model) {
        return null;
    }

    @Override
    public <T> void update(T model) {

    }

    @Override
    public <T> void delete(T model) {

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
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                _userCallBack.createUserResult(true);
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                _userCallBack.createUserResult(false);
//            }
//        });
//    }
//
//    @Override
//    public void update(User model) {
//        System.out.println("User has updated in rest: " + model.getName());
//
//    }
//
//    @Override
//    public List<User> getAll() {
//        return null;
//    }
//
//    @Override
//    public void remove(User model) {
//        System.out.println("User has removed in rest: " + model.getName());
//
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



