package com.example.firebackend;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View view;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        view = itemView;
    }
    public  void setDetails(Context context, String title, String image){
        TextView mtitletv = view.findViewById(R.id.rtitle_view);
        ImageView mImageview = view.findViewById(R.id.rimage_view);

        mtitletv.setText(title);
        Picasso.get().load(image).into(mImageview);

        Animation animation = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
        itemView.startAnimation(animation);
    }
}
