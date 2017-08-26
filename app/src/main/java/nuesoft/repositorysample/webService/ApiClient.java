package nuesoft.repositorysample.webService;

import android.content.Context;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import okhttp3.OkHttpClient;

public class ApiClient {

    private static OkHttpClient okHttpClient = null;

    public static OkHttpClient getClient(Context context) {

        if (okHttpClient == null) {

            ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
            okHttpClient = new OkHttpClient.Builder().cookieJar(cookieJar).build();
        }

        return okHttpClient;
    }
}
