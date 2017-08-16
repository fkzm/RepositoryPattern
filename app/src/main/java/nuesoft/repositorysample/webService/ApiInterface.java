package nuesoft.repositorysample.webService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Ehsan on 2017-01-24.
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST("sessions")
    Call<ResponseBody> signIn(@Field("email") String email, @Field("password") String password);

}