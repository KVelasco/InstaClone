package com.example.kevinvelasco.instaclone;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.kevinvelasco.instaclone.db.InstaSession;

public class LauncherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent;
        String token  = new InstaSession(this).getString(InstaSession.TOKEN);

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
