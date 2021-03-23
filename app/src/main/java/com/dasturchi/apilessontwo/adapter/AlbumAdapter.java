package com.dasturchi.apilessontwo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dasturchi.apilessontwo.R;
import com.dasturchi.apilessontwo.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumHolder>{
    Context context;
    List<Album> albumList;

    public AlbumAdapter(Context context, List<Album> albumList) {
        this.context = context;
        this.albumList = albumList;
    }

    @Override
    public int getItemViewType(int position) {
        Album album = albumList.get(position);// position = 10
        if (album.getTitle().charAt(0) == 'n'){
            return 10;
        }
        return 12;
    }

    @NonNull
    @Override
    public AlbumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_album,parent,false);
        View view2 = LayoutInflater.from(context).inflate(R.layout.item_album2,parent,false);
        AlbumHolder holder = new AlbumHolder(view);
        AlbumHolder holder2 = new AlbumHolder(view2);

        if (viewType == 10){
            return holder2;
        } else {
            return holder;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull AlbumHolder holder, int position) {
        Album album = albumList.get(position);

        holder.tvTitleAlbum.setText(album.getTitle());

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    class AlbumHolder extends RecyclerView.ViewHolder{
        TextView tvTitleAlbum;
        public AlbumHolder(@NonNull View itemView) {
            super(itemView);
            tvTitleAlbum = itemView.findViewById(R.id.tvTitleAlbum);
        }
    }
}
