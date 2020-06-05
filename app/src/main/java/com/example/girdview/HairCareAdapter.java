package com.example.girdview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HairCareAdapter extends RecyclerView.Adapter<HairCareAdapter.HairViewHolder> {

    Context context;
    List<HairCareModel> hairCareModelList;

    public HairCareAdapter(Context context, List<HairCareModel> hairCareModelList) {
        this.context = context;
        this.hairCareModelList =hairCareModelList ;
    }

    @NonNull
    @Override
    public HairViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_card_hair_care,parent,false);
      HairViewHolder hairViewHolder=new HairViewHolder(view);
        return  hairViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HairViewHolder holder, int position) {

       HairCareModel hairCareModel=hairCareModelList.get(position);
       holder.hair_item_image.setImageResource(hairCareModel.getHairAndCareImage());
       holder.hair_item_left_price.setText("MRP: \u20B9"+hairCareModel.getHairAndCarePriceLeft());
       holder.hair_item_name.setText(hairCareModel.getHairAndCareName());
       holder.hair_item_price.setText("Out Price: \u20B9"+hairCareModel.getHairAndCarePrice());
       holder.hair_item_quantity.setText(hairCareModel.getHairAndCareQuantity());
       holder.setItemClickListner(new ItemClickListner() {
           @Override
           public void onItemClickListner(View v, int position) {
               context.startActivity(new Intent(context,DescriptionActivity.class));
           }
       });



    }

    @Override
    public int getItemCount() {
        return hairCareModelList.size();
    }

    public class HairViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ItemClickListner itemClickListner;
        ImageView hair_item_image;
        TextView hair_item_name,hair_item_quantity,hair_item_left_price,hair_item_price;

        public HairViewHolder(@NonNull View itemView) {
            super(itemView);

            hair_item_image=itemView.findViewById(R.id.hair_image);
            hair_item_left_price=itemView.findViewById(R.id.hair_price_left);
            hair_item_name=itemView.findViewById(R.id.hair_name);
            hair_item_price=itemView.findViewById(R.id.hair_item_price);
            hair_item_quantity=itemView.findViewById(R.id.hair_quantity);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            this.itemClickListner.onItemClickListner(view,getLayoutPosition());
        }

        public void setItemClickListner(ItemClickListner ic){
            this.itemClickListner=ic;
        }

    }
}
