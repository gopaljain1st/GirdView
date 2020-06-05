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

public class OilsAndGheeAdapter extends RecyclerView.Adapter<OilsAndGheeAdapter.OilsViewHolder> {

    Context context;
    List<OilsAndGheeModel> oilsAndGheeModelList;

    public OilsAndGheeAdapter(Context context, List<OilsAndGheeModel> oilsAndGheeModelList) {
        this.context = context;
        this.oilsAndGheeModelList = oilsAndGheeModelList;
    }

    @NonNull
    @Override
    public OilsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_card_for_oils_and_ghee,parent,false);
        OilsViewHolder oilsViewHolder=new OilsViewHolder(view);
        return  oilsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OilsViewHolder holder, int position) {

        OilsAndGheeModel oilsAndGheeModel=oilsAndGheeModelList.get(position);
        holder.oils_item_quantity.setText(oilsAndGheeModel.getOilsAndGheeQuantity());
        holder.oils_item_price.setText("Out Price: \u20B9"+oilsAndGheeModel.getOilsAndGheePrice());
        holder.oils_item_name.setText(oilsAndGheeModel.getOilsAndGheeName());
        holder.oils_item_left_price.setText("MRP: \u20B9"+oilsAndGheeModel.OilsAndGheePriceLeft);
        holder.oils_item_image.setImageResource(oilsAndGheeModel.getOilsAndGheeImage());

    }

    @Override
    public int getItemCount() {
        return oilsAndGheeModelList.size();
    }

    public class OilsViewHolder extends RecyclerView.ViewHolder {
        ImageView oils_item_image;
        TextView oils_item_name,oils_item_quantity,oils_item_left_price,oils_item_price;

        public OilsViewHolder(@NonNull View itemView) {
            super(itemView);

            oils_item_image=itemView.findViewById(R.id.oils_item_image);
            oils_item_left_price=itemView.findViewById(R.id.oils_item_price_left);
            oils_item_name=itemView.findViewById(R.id.oils_item_name);
            oils_item_price=itemView.findViewById(R.id.oils_item_price);
            oils_item_quantity=itemView.findViewById(R.id.oils_item_quantity);

        }
    }
}
