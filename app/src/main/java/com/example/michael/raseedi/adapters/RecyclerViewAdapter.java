package com.example.michael.raseedi.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.michael.raseedi.R;
import com.example.michael.raseedi.model.Ad;
import com.example.michael.raseedi.activities.DetailAdActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private List<Ad> allAds = new ArrayList<>();

    private Context mContext;

    public RecyclerViewAdapter(Context mContext, List<Ad> allAds) {
        this.allAds = allAds;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(mContext)
                .asBitmap()
                .load(allAds.get(position).getPicture())
                .into(holder.picture);

        holder.title.setText(allAds.get(position).getTitle());

        holder.listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext,DetailAdActivity.class);
                i.putExtra("title", allAds.get(position).getTitle());
                i.putExtra("picture", allAds.get(position).getPicture());
                i.putExtra("url", allAds.get(position).getUrl());
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allAds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView picture;
        TextView title;
        RelativeLayout listItem;

        public ViewHolder(View itemView) {
            super(itemView);

            picture = itemView.findViewById(R.id.imageId);
            title = itemView.findViewById(R.id.imageNameId);
            listItem = itemView.findViewById(R.id.list_item_id);
        }
    }
}
