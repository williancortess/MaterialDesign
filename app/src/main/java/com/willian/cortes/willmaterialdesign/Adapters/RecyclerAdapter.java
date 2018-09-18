package com.willian.cortes.willmaterialdesign.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pkmmte.pkrss.Article;
import com.willian.cortes.willmaterialdesign.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder>{
    private List<Article> list;

    public RecyclerAdapter(List<Article> list){
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Article article = list.get(position);

        holder.title.setText(article.getTitle());
        holder.desc.setText(article.getDescription());
        new DowloadImageTask(holder.image).execute(article.getEnclosure().getUrl());
        holder.btLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, article.getSource());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
