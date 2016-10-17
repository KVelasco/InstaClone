package com.example.kevinvelasco.instaclone;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kevinvelasco.instaclone.api.InstaService;
import com.example.kevinvelasco.instaclone.model.MediaSearchResponse;
import com.example.kevinvelasco.instaclone.oauth.InstagramData;
import com.example.kevinvelasco.instaclone.ui.MediaAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class LoggedInActivity extends AppCompatActivity {

    MediaAdapter mediaAdapter;

    @Inject
    SharedPreferences preferences;

    @Inject
    InstaService instaService;

    @BindView(R.id.recycler)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged_in_activity);
        ButterKnife.bind(this);
        ((InstaCloneApplication) getApplication()).getInstaComponent().inject(this);

        mediaAdapter = new MediaAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mediaAdapter);
        mediaAdapter.setService(instaService);
        mediaAdapter.setSharedPreferences(preferences);

        instaService.getMediaByLocation("37.7749", "-122.4194", preferences.getString(InstagramData.TOKEN, ""))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<MediaSearchResponse>() {
                    @Override
                    public void onCompleted() {
                        Snackbar.make(recyclerView, "Success!", Snackbar.LENGTH_LONG)
                                .show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Snackbar.make(recyclerView, e.toString(), Snackbar.LENGTH_LONG)
                                .show();
                    }

                    @Override
                    public void onNext(MediaSearchResponse mediaSearchResponse) {
                        mediaAdapter.setMediaList(mediaSearchResponse.getMedia());
                    }
                });



    }
}
