package nuesoft.repositorysample.webService;

import android.content.Context;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import nuesoft.repositorysample.store.JWTTokenHelper;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ehsan on 2017-01-24.
 */


public class ApiClient {


    private static Retrofit retrofit = null;
    private static ApiInterface _apiInterface;

    public static Retrofit getClient(Context context) {

        if (retrofit == null) {

//            ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));

//            JWTTokenHelper.init(context, "KEY");

            final OkHttpClient okClient = new OkHttpClient.Builder().readTimeout(3, TimeUnit.MINUTES).connectTimeout(3, TimeUnit.MINUTES)
                    .addInterceptor(
                            new Interceptor() {
                                @Override
                                public Response intercept(Interceptor.Chain chain) throws IOException {
                                    Request request = chain.request();

//                                    if (JWTTokenHelper.hasJwtToken()) {
//                                        String token = JWTTokenHelper.getJwtToken();
//                                        request = request.newBuilder().addHeader("Authorization", "Bearer " + token).build();
//                                    }

                                    Response response = chain.proceed(request);

                                    int responseCode = response.code();

                                    switch (responseCode) {

                                        // Refresh token has expired
                                        case 401: {

                                            break;
                                        }

                                        // Server failed
                                        case 500: {

                                            break;
                                        }

                                        // Ok and response
                                        case 200: {

//                                            String identity = response.header("x-identity");
//                                            if (JWTTokenHelper.hasJwtToken() && identity.length() == 0) {
//                                                break;
//                                            }
                                        }
                                    }


                                    String newJwtToken = response.header("X-New-JWT-Token");

                                    if (newJwtToken != null) {
                                        JWTTokenHelper.setJwtToken(newJwtToken);
                                    }

                                    return response;

                                }
                            })
//                    .cookieJar(cookieJar)
                    .build();

            retrofit = new Retrofit.Builder().baseUrl("https://nc.carrene.com/")
                    .client(okClient)
                    .build();
        }
        return retrofit;
    }

    public static ApiInterface getService(Context context) {
        if (_apiInterface == null) {
            _apiInterface = getClient(context).create(ApiInterface.class);
        }
        return _apiInterface;
    }
}



