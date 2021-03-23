package com.dasturchi.apilessontwo.network;


import com.dasturchi.apilessontwo.model.Album;
import com.dasturchi.apilessontwo.model.Photo;
import com.dasturchi.apilessontwo.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/photos")
    Call<List<Photo>> loadPhotos();

    @GET("/users")
    Call<List<User>> loadUsers();

    @GET("/users/{userId}/albums")
    Call<List<Album>> loadUserAlbum(@Path(value = "userId",encoded = true) String u);

}
