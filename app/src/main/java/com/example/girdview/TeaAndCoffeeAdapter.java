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

public class TeaAndCoffeeAdapter extends RecyclerView.Adapter<TeaAndCoffeeAdapter.TeaViewHolder> {

    Context context;
    List<TeaAndCoffeeModel> teaAndCoffeeAdapterList;

    public TeaAndCoffeeAdapter(Context context, List<TeaAndCoffeeModel> teaAndCoffeeAdapterList) {
        this.context = context;
        this.teaAndCoffeeAdapterList = teaAndCoffeeAdapterList;
    }

    @NonNull
    @Override
    public TeaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_card_for_tea_and_coffee,parent,false);
      TeaViewHolder teaViewHolder=new TeaViewHolder(view);
        return  teaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeaViewHolder holder, int position) {

        TeaAndCoffeeModel teaAndCoffeeModel=teaAndCoffeeAdapterList.get(position);
        holder.teaName.setText(teaAndCoffeeModel.getTeaAndCoffeeName());
        holder.teaPrice.setText("Out Price: \u20B9"+teaAndCoffeeModel.getTeaAndCoffeePrice());
        holder.teaQuantity.setText(teaAndCoffeeModel.getTeaAndCoffeeQuantity());
        holder.teaPriceLeft.setText("MRP: \u20B9"+teaAndCoffeeModel.getTeaAndCoffeePriceLeft());
        holder.teaImage.setImageResource(teaAndCoffeeModel.getTeaAndCoffeeImage());


    }

    @Override
    public int getItemCount() {
        return teaAndCoffeeAdapterList.size();
    }

    public class TeaViewHolder extends RecyclerView.ViewHolder {

        ImageView teaImage;
        TextView teaName,teaPrice,teaPriceLeft,teaQuantity;

        public TeaViewHolder(@NonNull View itemView) {
            super(itemView);

            teaImage=itemView.findViewById(R.id.tea_image);
            teaPrice=itemView.findViewById(R.id.tea_item_price);
            teaPriceLeft=itemView.findViewById(R.id.tea_price_left);
            teaQuantity=itemView.findViewById(R.id.tea_quantity);
            teaName=itemView.findViewById(R.id.tea_name);

        }
    }
}
