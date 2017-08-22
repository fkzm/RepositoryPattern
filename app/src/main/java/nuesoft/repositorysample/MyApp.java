package nuesoft.repositorysample;

import android.app.Application;

/**
 * Created by mysterious on 8/22/17.
 */

public class MyApp extends Application {

    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
