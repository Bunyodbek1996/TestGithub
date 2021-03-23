package com.dasturchi.apilessontwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.dasturchi.apilessontwo.adapter.PhotoAdapter;
import com.dasturchi.apilessontwo.model.Photo;
import com.dasturchi.apilessontwo.network.ApiClient;
import com.dasturchi.apilessontwo.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Photo> photoList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photoList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);


        Call<List<Photo>> call = ApiClient.getApiClient().create(ApiInterface.class).loadPhotos();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.isSuccessful()){
                    photoList = response.body();
                    PhotoAdapter adapter = new PhotoAdapter(MainActivity.this,photoList);
                    recyclerView.setAdapter(adapter);
                }else{
                    Toast.makeText(MainActivity.this, response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });
    }
}