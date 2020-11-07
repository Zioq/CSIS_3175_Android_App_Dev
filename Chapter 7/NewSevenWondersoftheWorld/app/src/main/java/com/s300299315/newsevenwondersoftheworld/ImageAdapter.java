package com.s300299315.newsevenwondersoftheworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter {


    private Integer [] mData; //mData contain all the resources. It stores all data which will be displayed in grid
    private LayoutInflater mInflator; // Force us to Re-draw the component in the activity
    private ItemClickListener mClickListener; // use to handler event when user click each item


    public ImageAdapter(Context context, Integer[] data){
        mInflator = LayoutInflater.from(context);
        mData = data;
    }

    //Method return particular item depends on the data id
    public Integer getItem(int id) {
        return mData[id];
    }

    //Method for Click Listener
    public void setClickListener(ItemClickListener listener) {
        mClickListener = listener;
    }


    @NonNull
    @Override //Viewholder is a holder to hold item in the recycler view
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflator.inflate(R.layout.recyclerview_itm,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).imgView.setImageResource(mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener {

        //Member Variable
        ImageView imgView;

        // This constructor is for to create item
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // to show the item on the grid
            imgView = itemView.findViewById(R.id.imgSmall);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
          if(mClickListener != null) {
              mClickListener.onItemClick(view, getAdapterPosition());
          }
        }
    }

    //Click item -> send this info to activity -> let the activity to do large img
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
