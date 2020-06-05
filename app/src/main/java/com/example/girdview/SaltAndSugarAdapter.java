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

public class SaltAndSugarAdapter extends RecyclerView.Adapter<SaltAndSugarAdapter.SaltViewHolder>  {
   Context context;
    List<SaltAndSugarModel> saltAndSugarModelList;

    public SaltAndSugarAdapter(Context context, List<SaltAndSugarModel> saltAndSugarModelList) {
        this.context = context;
        this.saltAndSugarModelList = saltAndSugarModelList;
    }

    @NonNull
    @Override
    public SaltViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_card_salt_and_sugar,parent,false);
        SaltViewHolder saltViewHolder=new SaltViewHolder(view);
        return saltViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SaltViewHolder holder, int position) {

        SaltAndSugarModel saltAndSugarModel=saltAndSugarModelList.get(position);
        holder.salt_item_image.setImageResource(saltAndSugarModel.getSaltAndSugarImage());
        holder.salt_item_left_price.setText("MRP: \u20B9"+saltAndSugarModel.getSaltAndSugarPriceLeft());
        holder.salt_item_name.setText(saltAndSugarModel.getSaltAndSugarName());
        holder.salt_item_price.setText("Out Price: \u20B9"+saltAndSugarModel.getSaltAndSugarPrice());
        holder.salt_item_quantity.setText(saltAndSugarModel.getSaltAndSugarQuantity());
    }

    @Override
    public int getItemCount() {
        return saltAndSugarModelList.size();
    }

    public class SaltViewHolder extends RecyclerView.ViewHolder
    {
        ImageView salt_item_image;
        TextView salt_item_name,salt_item_quantity,salt_item_left_price,salt_item_price;

        public SaltViewHolder(@NonNull View itemView) {
            super(itemView);

            salt_item_image=itemView.findViewById(R.id.salt_image);
            salt_item_name=itemView.findViewById(R.id.salt_name);
            salt_item_left_price=itemView.findViewById(R.id.salt_price_left);
            salt_item_price=itemView.findViewById(R.id.salt_item_price);
            salt_item_quantity=itemView.findViewById(R.id.salt_quantity);

        }
    }
}
