package com.example.kevinvelasco.instaclone.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kevinvelasco.instaclone.R;
import com.example.kevinvelasco.instaclone.model.Media;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.MediaViewHolder> {

    private final List<Media> mediaList = new ArrayList<>();
    Listener listener;



    @Override
    public MediaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MediaViewHolder((LayoutInflater.from(parent.getContext()).inflate(R.layout.media_card, parent, false)));
    }

    @Override
    public void onBindViewHolder(MediaViewHolder holder, int position) {
        Media media = mediaList.get(position);
        holder.getButton().setOnClickListener(v -> {
            if (listener != null) {
                listener.onClick(media);
            }
        });
        holder.bind(media);
    }

    public void setMediaList(List<Media> mediaList){
        this.mediaList.clear();
        this.mediaList.addAll(mediaList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mediaList.size();
    }

    public void setListener(Listener Listener){
        this.listener = Listener;
    }

    public interface Listener{
        void onClick(Media media);
    }

     static  class MediaViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_view_card)
        ImageView imageView;

        @BindView(R.id.like_button)
        Button button;

        @BindView(R.id.like_status)
        TextView textView;

        public MediaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bind(Media media){
            Picasso.with(imageView.getContext())
                    .load(media.getImages().getStandardResolution().getUrl())
                    .into(imageView);

            if (media.isUserHasLiked()){
                button.setText("Unlike Image");
                textView.setText("Image is Liked");
            } else {
                button.setText("Like Image");
                textView.setText("Image is not Liked");
            }


        }

        public Button getButton() {
            return button;
        }

     }
}
