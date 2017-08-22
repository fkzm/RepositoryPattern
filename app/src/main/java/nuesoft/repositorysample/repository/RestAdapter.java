package nuesoft.repositorysample.repository;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nuesoft.repositorysample.model.user.User;
import nuesoft.repositorysample.repository.base.IAdapter;
import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.webService.ApiClient;
import nuesoft.repositorysample.webService.ApiInterface;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mysterious on 8/14/17.
 */

public class RestAdapter implements IAdapter {

    Context context;
    ApiInterface apiInterface;

    public RestAdapter(Context context) {
        this.context = context;
        this.apiInterface = ApiClient.getService(context);
    }

    @Override
    public <T extends BaseModel> void save(T model, final ResponseCallBack responseCallBack) {
        HashMap<String, String> map = model.toHashMap();

        Map<String, String> headerMap = new HashMap<>();


//        apiInterface.createBaseModel(model.getUrl(), map, headerMap).enqueue(new Callback<BaseModel>() {
//            @Override
//            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
//                Log.d("d", "" + response.isSuccessful());
//            }
//
//            @Override
//            public void onFailure(Call<BaseModel> call, Throwable t) {
//
//            }
//        });

        this.apiInterface.createBaseModel(model.getUrl(), map, headerMap).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


//        apiInterface.createBaseModel(model.getUrl(), map, headerMap).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.d("fail", t.toString());
//                Log.d("fail", call.request().toString());
//
//            }
//        });
    }
}



