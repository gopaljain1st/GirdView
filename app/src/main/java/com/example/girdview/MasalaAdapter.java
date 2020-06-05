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

public class MasalaAdapter extends RecyclerView.Adapter<MasalaAdapter.MasalaViewHolder> {
   Context context;
   List<MasalaModel> masalaModelList;

    public MasalaAdapter(Context context, List<MasalaModel> masalaModelList) {
        this.context = context;
        this.masalaModelList = masalaModelList;
    }

    @NonNull
    @Override
    public MasalaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_card_masala,parent,false);
        MasalaViewHolder masalaViewHolder=new MasalaViewHolder(view);
        return masalaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MasalaViewHolder holder, int position) {

        MasalaModel masalaModel=masalaModelList.get(position);
        holder.masalaPriceLeft.setText("MRP: \u20B9"+masalaModel.getMasalasPriceLeft());
        holder.masalaPrice.setText("Out Price: \u20B9"+masalaModel.getMasalasPrice());
        holder.masalaName.setText(masalaModel.getMasalasName());
        holder.masalaQuantity.setText(masalaModel.getMasalasQuantity());
        holder.masalaImage.setImageResource(masalaModel.getMasalasImage());
    }

    @Override
    public int getItemCount() {
        return masalaModelList.size();
    }

    public class MasalaViewHolder extends RecyclerView.ViewHolder
    {
        ImageView masalaImage;
        TextView masalaName,masalaPrice,masalaPriceLeft,masalaQuantity;

        public MasalaViewHolder(@NonNull View itemView) {
            super(itemView);

            masalaImage=itemView.findViewById(R.id.masala_image);
            masalaPriceLeft=itemView.findViewById(R.id.masala_price_left);
            masalaPrice=itemView.findViewById(R.id.masala_item_price);
            masalaQuantity=itemView.findViewById(R.id.masala_quantity);
            masalaName=itemView.findViewById(R.id.masala_name);
        }
    }
}
