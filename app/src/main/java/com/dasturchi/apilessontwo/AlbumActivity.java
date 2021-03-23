package com.dasturchi.apilessontwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.dasturchi.apilessontwo.adapter.AlbumAdapter;
import com.dasturchi.apilessontwo.model.Album;
import com.dasturchi.apilessontwo.network.ApiClient;
import com.dasturchi.apilessontwo.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumActivity extends AppCompatActivity {
    List<Album> albums = new ArrayList<>();
    RecyclerView recyclerAlbum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        recyclerAlbum = findViewById(R.id.recyclerAlbum);
        String userId = getIntent().getExtras().getString("userId");

        Toast.makeText(this, "id: "+userId, Toast.LENGTH_SHORT).show();

        Call<List<Album>> call = ApiClient.getApiClient().create(ApiInterface.class).loadUserAlbum(userId);

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                if (response.isSuccessful()){
                    albums = response.body();
                    AlbumAdapter adapter = new AlbumAdapter(AlbumActivity.this,albums);
                    recyclerAlbum.setAdapter(adapter);
                }else{
                    Toast.makeText(AlbumActivity.this, "res: "+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Toast.makeText(AlbumActivity.this, "t: "+ t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}