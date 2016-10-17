package com.example.kevinvelasco.instaclone.oauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.kevinvelasco.instaclone.LoggedInActivity;


public class InstaAuthWebViewClient extends WebViewClient {


    private SharedPreferences preferences;
    private static final String ACCESS_TOKEN = "access_token";
    private Context context;

    public InstaAuthWebViewClient(Context context, SharedPreferences preferences) {
        this.context= context;
        this.preferences = preferences;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (!TextUtils.isEmpty(url) && url.contains(ACCESS_TOKEN)){
            String[] split = url.split("=");
            String token = split[1];
            if (context instanceof Activity) {
                preferences.edit().putString(InstagramData.TOKEN, token).apply();
                startLoggedInActivity((Activity) context);
                return true;
            }
         }
        return false;
    }



    private void startLoggedInActivity(Activity activity){
        Intent intent = new Intent(activity, LoggedInActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }


}
