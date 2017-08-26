package nuesoft.repositorysample.repository;

import org.jdeferred.Deferred;
import org.jdeferred.Promise;

import java.util.Map;

import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.repository.base.IAdapter;
import nuesoft.repositorysample.store.Authenticator;
import nuesoft.repositorysample.webService.MyRequest;
import nuesoft.repositorysample.webService.Response;

/**
 * Created by mysterious on 8/14/17.
 */

public class RestAdapter extends IAdapter {

    private String baseUrl;
    private String tokenLocalStorageKey;
    public static Authenticator authenticator;

    public RestAdapter() {
    }


    public RestAdapter(String baseUrl, String tokenLocalStorageKey, Authenticator authenticator1) {
        this.baseUrl = baseUrl;
        this.tokenLocalStorageKey = tokenLocalStorageKey;
        authenticator = authenticator1;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public Authenticator getAuthenticator() {
        if (authenticator == null) {
            authenticator = new Authenticator();
        }
        return authenticator;
    }

    public Promise login(Map<String, Object> credentials) {

        Promise promise = this.request("sessions", "post").addParameters(credentials).send();
        return promise;
    }

    public void logout() {
        authenticator.deleteJwtToken();
    }

    public MyRequest request(String resources, String verb) {
        return new MyRequest(this, resources, verb).addAuthenticationHeaders(false);
    }


    @Override
    public <T extends BaseModel> void save(final T model, ResponseCallBack responseCallBack) {
//        return request()
        Promise promise = this.request(model.url, "POST").setPostProcessor(new Processor() {
            @Override
            public void processor(Deferred deferred, Response response) {
                deferred.resolve(BaseModel.getObject(response.getBody(), model.getClass()));
            }
        }).send();
    }

    @Override
    public <T extends BaseModel> void getOne(int id, final ResponseCallBack responseCallBack) {
//        r.setPostProcessor(new ResponseCallBack()).send()
    }

    @Override
    public <T extends BaseModel> void getAll(final ResponseCallBack responseCallBack) {
//        responseCallBack.onResponse(new Response());
    }

    //
//    @Override
//    public <T extends BaseModel> void save(final T model, final ResponseCallBack responseCallBack) {
//        HashMap<String, String> map = model.toHashMap();
//
//        Map<String, String> headerMap = new HashMap<>();
//
//        apiInterface.createBaseModel(T.url, map, headerMap).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
////                responseResult.setDescription(response.errorBody().toString());
//                responseCallBack.onResponse(new nuesoft.repositorysample.webService.Response(response, model.getClass()));
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
//    }
//
//
//    @Override
//    public <T extends BaseModel> void getAll(final ResponseCallBack responseCallBack) {
//
//        Map<String, String> headerMap = new HashMap<>();
//
////        String url = T.newInstance().getUrl();
////UL from T
//
//        apiInterface.getBaseModel(T.url, headerMap, null).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                Log.d("", "");
//                responseCallBack.onResponse(new nuesoft.repositorysample.webService.Response(response, Code.class));
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
//    }
//
//    @Override
//    public <T extends BaseModel> void getOne(int id, final ResponseCallBack responseCallBack) {
//
//        Map<String, String> headerMap = new HashMap<>();
//        //T type
//        apiInterface.getBaseModel(T.url + id, headerMap, headerMap).enqueue(new Callback<ResponseBody>() {
//
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                Log.d("", "");
//                responseCallBack.onResponse(new nuesoft.repositorysample.webService.Response(response, Code.class));
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
//    }


}





