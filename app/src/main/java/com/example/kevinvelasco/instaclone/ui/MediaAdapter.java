package com.example.kevinvelasco.instaclone.ui;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kevinvelasco.instaclone.R;
import com.example.kevinvelasco.instaclone.api.InstaService;
import com.example.kevinvelasco.instaclone.db.InstaSession;
import com.example.kevinvelasco.instaclone.model.Like;
import com.example.kevinvelasco.instaclone.model.Media;
import com.example.kevinvelasco.instaclone.model.MediaSearchResponse;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.MediaViewHolder> {

    private final List<Media> mediaList = new ArrayList<>();
    private InstaService instaService;


    @Override
    public MediaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MediaViewHolder((LayoutInflater.from(parent.getContext()).inflate(R.layout.media_card, parent, false)));
    }

    @Override
    public void onBindViewHolder(MediaViewHolder holder, int position) {
        Media media = mediaList.get(position);
        holder.getButton().setOnClickListener(v -> {
            if (instaService != null){
                if (media.isUserHasLiked()){
                    instaService.unlikeMediaById(media.getMediaId(), new InstaSession(holder.imageView.getContext()).getString(InstaSession.TOKEN))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .unsubscribeOn(Schedulers.io())
                            .subscribe(new Observer<Like>() {
                                @Override
                                public void onCompleted() {
                                    Snackbar.make(holder.imageView, "Unliked Image", Snackbar.LENGTH_LONG)
                                        .show();
                                }

                                @Override
                                public void onError(Throwable e) {
                                    Snackbar.make(holder.imageView, e.toString(), Snackbar.LENGTH_LONG)
                                            .show();
                                }

                                @Override
                                public void onNext(Like Like) {
                                    media.setUserHasLiked(false);
                                    notifyDataSetChanged();
                                }
                            });
                } else {
                    instaService.likeMediaById(media.getMediaId(), new InstaSession(holder.imageView.getContext()).getString(InstaSession.TOKEN))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .unsubscribeOn(Schedulers.io())
                            .subscribe(new Observer<Like>() {
                                @Override
                                public void onCompleted() {
                                    Snackbar.make(holder.imageView, "Liked Image", Snackbar.LENGTH_LONG)
                                            .show();
                                }

                                @Override
                                public void onError(Throwable e) {
                                    Snackbar.make(holder.imageView, e.toString(), Snackbar.LENGTH_LONG)
                                            .show();
                                }

                                @Override
                                public void onNext(Like Like) {
                                    media.setUserHasLiked(true);
                                    notifyDataSetChanged();
                                }
                            });
                }
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

    public void setService(InstaService instaService){
        this.instaService = instaService;
    }



     class MediaViewHolder extends RecyclerView.ViewHolder {

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
