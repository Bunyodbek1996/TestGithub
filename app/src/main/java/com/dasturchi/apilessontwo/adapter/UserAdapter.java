package com.dasturchi.apilessontwo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dasturchi.apilessontwo.AlbumActivity;
import com.dasturchi.apilessontwo.R;
import com.dasturchi.apilessontwo.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder>{
    Context context;
    List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getItemViewType(int position) {
        User user = userList.get(position);// position = 10
        if (user.getName().charAt(0) == 'L' || user.getName().charAt(0) == 'l'){
            return 2;
        }
        return 12;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user,parent,false);
        View view2 = LayoutInflater.from(context).inflate(R.layout.item_user2,parent,false);
        UserHolder holder = new UserHolder(view);
        UserHolder holder2 = new UserHolder(view2);

        if (viewType == 2){
            return holder2;
        } else {
            return holder;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User user = userList.get(position);
        holder.tvNameUser.setText(user.getName());

        holder.tvAddressUser.setText(
                user.getAddress().getStreet()+" "+user.getAddress().getSuite()
        );

        holder.tvNameUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AlbumActivity.class);
                intent.putExtra("userId",user.getId()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserHolder extends RecyclerView.ViewHolder{
        TextView tvNameUser,tvAddressUser;
        public UserHolder(@NonNull View itemView) {
            super(itemView);
            tvNameUser = itemView.findViewById(R.id.tvNameUser);
            tvAddressUser = itemView.findViewById(R.id.tvAddressUser);
        }
    }
}
