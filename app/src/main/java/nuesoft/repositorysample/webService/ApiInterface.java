package nuesoft.repositorysample.webService;

import java.util.Map;

import nuesoft.repositorysample.model.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by Ehsan on 2017-01-24.
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST("sessions")
    Call<User> signIn(@Field("email") String email, @Field("password") String password);


//    @FormUrlEncoded
//    @POST()
//    <T extends BaseModel> Call<T> createBaseModel(@Url String url, @FieldMap Map<String, Object> body, @HeaderMap Map<String, String> headerMap);

    @FormUrlEncoded
    @POST()
    Call<ResponseBody> createBaseModel(@Url String url, @FieldMap Map<String, String> body, @HeaderMap Map<String, String> headerMap);


    @GET
    Call<ResponseBody> getBaseModel(@Url String url, @HeaderMap Map<String, String> headerMap, @QueryMap Map<String, String> options);


    @DELETE
    Call<ResponseBody> deleteBaseModel(@Url String url, @HeaderMap Map<String, String> headerMap);


}