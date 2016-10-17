package com.example.kevinvelasco.instaclone.injection.modules;

import com.example.kevinvelasco.instaclone.api.InstaService;
import com.example.kevinvelasco.instaclone.injection.UserScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class InstaModule {

    @Provides
    @UserScope
    public InstaService providesInstaService(Retrofit retrofit) {
        return retrofit.create(InstaService.class);
    }
}
