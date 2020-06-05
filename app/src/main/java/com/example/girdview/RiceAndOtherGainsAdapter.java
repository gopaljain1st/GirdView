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

public class RiceAndOtherGainsAdapter extends RecyclerView.Adapter<RiceAndOtherGainsAdapter.RiceViewHolder> {

    Context context;
    List<RiceAndOtherGainsModel> riceAndOtherGainsModels;

    public RiceAndOtherGainsAdapter(Context context, List<RiceAndOtherGainsModel> riceAndOtherGainsModels) {
        this.context = context;
        this.riceAndOtherGainsModels = riceAndOtherGainsModels;
    }

    @NonNull
    @Override
    public RiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_card_for_rice_and_other_gains,parent,false);
        RiceAndOtherGainsAdapter.RiceViewHolder riceViewHolder=new RiceAndOtherGainsAdapter.RiceViewHolder(view);
        return  riceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RiceViewHolder holder, int position) {

        RiceAndOtherGainsModel riceAndOtherGainsModel=riceAndOtherGainsModels.get(position);

        holder.rice_item_price.setText("Out Price: \u20B9"+riceAndOtherGainsModel.getRicePrice());
        holder.rice_item_quantity.setText(riceAndOtherGainsModel.getRiceQuantity());
        holder.rice_item_left_price.setText("MRP: \u20B9"+riceAndOtherGainsModel.getRicePriceLeft());
        holder.rice_item_name.setText(riceAndOtherGainsModel.getRiceName());
        holder.rice_item_image.setImageResource(riceAndOtherGainsModel.getRiceAndGainsImage());
    }

    @Override
    public int getItemCount() {
        return riceAndOtherGainsModels.size();
    }

    public class RiceViewHolder extends RecyclerView.ViewHolder {
        ImageView rice_item_image;
        TextView rice_item_name,rice_item_quantity,rice_item_left_price,rice_item_price;
        public RiceViewHolder(@NonNull View itemView) {
            super(itemView);
            rice_item_image=itemView.findViewById(R.id.rice_image);
            rice_item_name=itemView.findViewById(R.id.rice_name);
            rice_item_left_price=itemView.findViewById(R.id.rice_item_price_left);
            rice_item_price=itemView.findViewById(R.id.rice_item_price);
            rice_item_quantity=itemView.findViewById(R.id.rice_quantity);

        }
    }
}
