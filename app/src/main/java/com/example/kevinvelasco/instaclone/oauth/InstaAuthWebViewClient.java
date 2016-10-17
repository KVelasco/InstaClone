package com.example.kevinvelasco.instaclone.oauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.kevinvelasco.instaclone.LoggedInActivity;
import com.example.kevinvelasco.instaclone.db.InstaSession;


public class InstaAuthWebViewClient extends WebViewClient {


    private static final String ACCESS_TOKEN = "access_token";
    private Context context;

    public InstaAuthWebViewClient(Context context) {
        this.context= context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (!TextUtils.isEmpty(url) && url.contains(ACCESS_TOKEN)){
            String[] split = url.split("=");
            String token = split[1];
            if (context instanceof Activity) {
                new InstaSession(context).putString(InstaSession.TOKEN, token);
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
