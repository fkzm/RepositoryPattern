package nuesoft.repositorysample.store;

import android.content.Context;
import android.content.SharedPreferences;

public class JWTTokenHelper {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor sharedPreferencesEditor;
    private static JWTTokenHelper jWTTokenHelper = null;
    private static String tokenSharedPreferencesKey;

    public static void init(Context context, String tokenKey) {

        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();
        tokenSharedPreferencesKey = tokenKey;
    }

    public static void setJwtToken(String token) {
        sharedPreferencesEditor.putString(tokenSharedPreferencesKey, token);
        sharedPreferencesEditor.apply();
    }

    public static boolean hasJwtToken() {

        String token = sharedPreferences.getString(tokenSharedPreferencesKey, "");
        if (token.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String getJwtToken() {

        String token = sharedPreferences.getString(tokenSharedPreferencesKey, "");
        return token;
    }

    public static void deleteJwtToken() {

        sharedPreferencesEditor.remove(tokenSharedPreferencesKey);
        sharedPreferencesEditor.apply();
    }

    public static void deleteRefreshToken() {

        sharedPreferencesEditor.remove(tokenSharedPreferencesKey);
        sharedPreferencesEditor.apply();
    }
}