package com.dasturchi.apilessontwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.dasturchi.apilessontwo.adapter.UserAdapter;
import com.dasturchi.apilessontwo.model.User;
import com.dasturchi.apilessontwo.network.ApiClient;
import com.dasturchi.apilessontwo.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserActivity extends AppCompatActivity {
    List<User> userList = new ArrayList<>();
    RecyclerView recyclerUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        recyclerUser = findViewById(R.id.recyclerUser);

        Call<List<User>> call = ApiClient.getApiClient().create(ApiInterface.class).loadUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()){
                    userList = response.body();
                    UserAdapter adapter = new UserAdapter(UserActivity.this,userList);
                    recyclerUser.setAdapter(adapter);
                }else{
                    Toast.makeText(UserActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(UserActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}