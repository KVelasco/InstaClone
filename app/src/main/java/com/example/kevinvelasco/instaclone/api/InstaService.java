package com.example.kevinvelasco.instaclone.api;


import com.example.kevinvelasco.instaclone.model.Like;
import com.example.kevinvelasco.instaclone.model.MediaSearchResponse;

import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface InstaService {

    @GET("media/search")
    Observable<MediaSearchResponse> getMediaByLocation(@Query("lat") String lat, @Query("lng") String lng, @Query("access_token") String accessToken);

    @POST("media/{media-id}/likes?access_token=ACCESS-TOKEN")
    Observable<Like> likeMediaById(@Path("media-id") String mediaId, @Query("access_token") String accessToken);

    @DELETE("media/{media-id}/likes?access_token=ACCESS-TOKEN")
    Observable<Like> unlikeMediaById(@Path("media-id") String mediaId, @Query("access_token") String accessToken);


}
