package com.example.girdview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LaundryAndDetergentAdapter extends RecyclerView.Adapter<LaundryAndDetergentAdapter.LaundryViewHolder> {

    Context context;
    List<LaundryAndDetergentModel> laundryAndDetergentModelList;

    public LaundryAndDetergentAdapter(Context context, List<LaundryAndDetergentModel> laundryAndDetergentModelList) {
        this.context = context;
        this.laundryAndDetergentModelList = laundryAndDetergentModelList;
    }

    @NonNull
    @Override
    public LaundryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_card_detergent,parent,false);
        LaundryViewHolder laundryViewHolder=new LaundryViewHolder(view);
        return laundryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LaundryViewHolder holder, int position) {

        LaundryAndDetergentModel laundryAndDetergentModel=laundryAndDetergentModelList.get(position);
        holder.detergent_item_image.setImageResource(laundryAndDetergentModel.getDetergentImage());
        holder.detergent_item_left_price.setText("MRP: \u20B9"+laundryAndDetergentModel.getDetergentLeftPrice());
        holder.detergent_item_name.setText(laundryAndDetergentModel.getDetergentName());
        holder.detergent_item_quantity.setText(laundryAndDetergentModel.getDetergentQuantity());
        holder.detergent_item_price.setText("Out Price: \u20B9"+ laundryAndDetergentModel.getDetergentPrice());

    }

    @Override
    public int getItemCount() {
        return laundryAndDetergentModelList.size();
    }

    public class LaundryViewHolder extends RecyclerView.ViewHolder
    {
        ImageView detergent_item_image;
        TextView detergent_item_name,detergent_item_quantity,detergent_item_left_price,detergent_item_price;

        public LaundryViewHolder(@NonNull View itemView)
        {
            super(itemView);

            detergent_item_image=itemView.findViewById(R.id.detergent_image);
            detergent_item_left_price=itemView.findViewById(R.id.detergent_price_left);
            detergent_item_name=itemView.findViewById(R.id.detergent_name);
            detergent_item_price=itemView.findViewById(R.id.detergent_item_price);
            detergent_item_quantity=itemView.findViewById(R.id.detergent_quantity);


        }
    }
}
