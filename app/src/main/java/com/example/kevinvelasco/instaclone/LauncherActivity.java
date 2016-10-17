package com.example.kevinvelasco.instaclone;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.kevinvelasco.instaclone.oauth.InstagramData;

import javax.inject.Inject;

public class LauncherActivity extends Activity {

    @Inject
    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((InstaCloneApplication) getApplication()).getInstaComponent().inject(this);

        Intent intent;
        String token = mSharedPreferences.getString(InstagramData.TOKEN, "");

        if (TextUtils.isEmpty(token)){
            intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            intent = new Intent(this, LoggedInActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
