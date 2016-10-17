package com.example.kevinvelasco.instaclone.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Map;

public class InstaSession {

    public static final String TOKEN = "token";

    private SharedPreferences preferences;


    public InstaSession(Context appContext) {
        preferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }

    public InstaSession(Context context, String fileName, int mode){
        preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }



    public String getString(String key) {
        return preferences.getString(key, "");
    }


    public void putString(String key, String value) {
        preferences.edit().putString(key, value).apply();
    }



    public void remove(String key) {
        preferences.edit().remove(key).apply();
    }


    public void clear() {
        preferences.edit().clear().apply();
    }


    public Map<String, ?> getAll() {
        return preferences.getAll();
    }
}
