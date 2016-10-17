package com.example.kevinvelasco.instaclone;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.kevinvelasco.instaclone.oauth.InstaAuthWebViewClient;
import com.example.kevinvelasco.instaclone.oauth.InstagramData;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @Inject
    SharedPreferences preferences;

    @BindView(R.id.web_view)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((InstaCloneApplication) getApplication()).getInstaComponent().inject(this);


        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setWebViewClient(new InstaAuthWebViewClient(this, preferences));
        webView.getSettings().setJavaScriptEnabled(true);

        loginToInstagram();
    }


    private void loginToInstagram(){
        final Uri.Builder builder = new Uri.Builder();

        builder.scheme(InstagramData.SCHEME)
                .authority(InstagramData.AUTHORITY)
                .appendPath(InstagramData.OAUTH_PATH)
                .appendPath(InstagramData.AUTHORIZE_PATH)
                .appendQueryParameter(InstagramData.CLIENT_ID, InstagramData.CLIENT_ID_VALUE)
                .appendQueryParameter(InstagramData.REDIRECT_URI, InstagramData.REDIRECT_URI_VALUE)
                .appendQueryParameter(InstagramData.RESPONSE_TYPE, InstagramData.RESPONSE_TYPE_VALUE)
                .appendQueryParameter(InstagramData.SCOPE, InstagramData.SCOPE_VALUES);

        webView.loadUrl(builder.build().toString());
    }

}
