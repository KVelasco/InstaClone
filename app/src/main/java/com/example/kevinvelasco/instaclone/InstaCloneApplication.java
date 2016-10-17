package com.example.kevinvelasco.instaclone;

import android.app.Application;

import com.example.kevinvelasco.instaclone.injection.components.DaggerInstaComponent;
import com.example.kevinvelasco.instaclone.injection.components.DaggerNetComponent;
import com.example.kevinvelasco.instaclone.injection.components.InstaComponent;
import com.example.kevinvelasco.instaclone.injection.components.NetComponent;
import com.example.kevinvelasco.instaclone.injection.modules.AppModule;
import com.example.kevinvelasco.instaclone.injection.modules.InstaModule;
import com.example.kevinvelasco.instaclone.injection.modules.NetModule;


public class InstaCloneApplication extends Application {

    private NetComponent netComponent;
    private InstaComponent instaComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.instagram.com/v1/"))
                .build();

        instaComponent = DaggerInstaComponent.builder()
                .netComponent(netComponent)
                .instaModule(new InstaModule())
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

    public InstaComponent getInstaComponent() {
        return instaComponent;
    }
}
