package nuesoft.repositorysample.repository;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import nuesoft.repositorysample.model.Code;
import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.repository.base.IAdapter;
import nuesoft.repositorysample.webService.ApiInterface;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mysterious on 8/14/17.
 */

public class RestAdapter extends IAdapter {

    Context context;
    static ApiInterface apiInterface;

    public RestAdapter(Context context) {
        this.context = context;
//        apiInterface = ApiClient.getService(context);
    }

    @Override
    public <T extends BaseModel> void save(final T model, final ResponseCallBack responseCallBack) {
        HashMap<String, String> map = model.toHashMap();

        Map<String, String> headerMap = new HashMap<>();

        apiInterface.createBaseModel(model.getUrl(), map, headerMap).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

//                responseResult.setDescription(response.errorBody().toString());
                responseCallBack.onResponse(new nuesoft.repositorysample.webService.Response(response, model.getClass()));

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


    @Override
    public <T extends BaseModel> void getAll(final ResponseCallBack responseCallBack) {

        Map<String, String> headerMap = new HashMap<>();

//        String url = T.newInstance().getUrl();
//UL from T

        apiInterface.getBaseModel("apiv1/codes", headerMap, null).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("", "");
                responseCallBack.onResponse(new nuesoft.repositorysample.webService.Response(response, Code.class));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public <T extends BaseModel> void getOne(int id, final ResponseCallBack responseCallBack) {

        Map<String, String> headerMap = new HashMap<>();
        //T type

        apiInterface.getBaseModel("apiv1/codes/"+id, headerMap, headerMap).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("", "");
                responseCallBack.onResponse(new nuesoft.repositorysample.webService.Response(response, Code.class));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}



