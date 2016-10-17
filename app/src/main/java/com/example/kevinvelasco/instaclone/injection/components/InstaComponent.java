package com.example.kevinvelasco.instaclone.injection.components;

import com.example.kevinvelasco.instaclone.LauncherActivity;
import com.example.kevinvelasco.instaclone.LoggedInActivity;
import com.example.kevinvelasco.instaclone.LoginActivity;
import com.example.kevinvelasco.instaclone.injection.UserScope;
import com.example.kevinvelasco.instaclone.injection.modules.InstaModule;

import dagger.Component;

@UserScope
@Component(dependencies = NetComponent.class, modules = InstaModule.class)
public interface InstaComponent {
    void inject(LoggedInActivity activity);
    void inject(LoginActivity activity);
    void inject(LauncherActivity activity);
}