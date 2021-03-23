package com.dasturchi.apilessontwo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dasturchi.apilessontwo.R;
import com.dasturchi.apilessontwo.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder>{
    Context context;
    List<Photo> list;

    public PhotoAdapter(Context context, List<Photo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        Photo photo = list.get(position);
        if (photo.getTitle().charAt(0) == 'a' || photo.getTitle().charAt(0) == 'A'){
            return 101;
        }
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_photo,parent,false);
        View view2 = LayoutInflater.from(context).inflate(R.layout.item_photo2,parent,false);
        if (viewType == 101){
            PhotoHolder holder = new PhotoHolder(view2);
            return holder;
        }
        PhotoHolder holder = new PhotoHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
        Photo photo = list.get(position);
        holder.tvTitlePhoto.setText(photo.getTitle());

        Picasso.get()
                .load(photo.getUrl())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PhotoHolder extends RecyclerView.ViewHolder{
        TextView tvTitlePhoto;
        ImageView image;
        public PhotoHolder(@NonNull View itemView) {
            super(itemView);
            tvTitlePhoto = itemView.findViewById(R.id.tvTitlePhoto);
            image = itemView.findViewById(R.id.image);
        }
    }
}
