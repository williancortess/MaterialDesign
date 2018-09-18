package com.willian.cortes.willmaterialdesign;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView title;
    public TextView desc;
    public AppCompatButton btLink;

    public ViewHolder(View itemView) {
        super(itemView);

        this.image = itemView.findViewById(R.id.featuredImage);
        this.title = itemView.findViewById(R.id.title);
        this.desc = itemView.findViewById(R.id.desc);
        this.btLink = itemView.findViewById(R.id.btLink);
    }
}
