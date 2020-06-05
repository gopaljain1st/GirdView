package com.example.girdview;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomRecyclerAdapter2 extends RecyclerView.Adapter<CustomRecyclerAdapter2.ViewHolder> {

    private Context context;
    private List<Item> personUtils;

    public CustomRecyclerAdapter2(Context context, List personUtils) {
        this.context = context;
        this.personUtils = personUtils;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    public void onBindViewHolder(final ViewHolder holder, final int position) {
        //holder.itemView.setTag(personUtils.get(position));
        final Myhelper myhelper=new Myhelper(context);
        final SQLiteDatabase database=myhelper.getWritableDatabase();
        final Item pu = personUtils.get(position);
        final int[] number = {pu.getQty()};
        holder.item_qty.setText(""+pu.getQty());
holder.minus.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (number[0] == 1) {
            holder.item_qty.setText(""+number[0]);
        }

        if (number[0] > 1) {

            number[0] = number[0] - 1;
           /* ContentValues values = new ContentValues();
            values.put("QTY",number[0]);
            database.update("PRODUCT", values, "NAME="+pu.getProduct_name(), null);*/
            holder.item_qty.setText(""+number[0]);
        }
    }
});
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // attaAndOtherModel.setQuantity(item+1);

                number[0] = number[0] + 1;
             /*   ContentValues values = new ContentValues();
                values.put("QTY",number[0]);
                database.update("PRODUCT", values, "NAME="+pu.getProduct_name(), null);*/
                holder.item_qty.setText(""+number[0]);
            }
        });

        holder.product_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myhelper.getWritableDatabase().execSQL("delete from PRODUCT");
                personUtils.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, personUtils.size());
                Toast.makeText(context, "Item Succesfully Removed", Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemimage.setImageResource(pu.getImage_id());
        holder.product_name.setText(pu.getProduct_name());
        holder.brand_name.setText(pu.getBrand());
        holder.pprice.setText(pu.getProduct_price());
        holder.sprice.setText(pu.getSelling_price());
    }

    @Override
    public int getItemCount() {
        return personUtils.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemimage,add,minus,product_delete;
        public TextView product_name,brand_name,pprice,sprice,item_qty;

        public ViewHolder(View itemView) {
            super(itemView);
            itemimage=itemView.findViewById(R.id.product_img);
            product_name =  itemView.findViewById(R.id.product_name);
            brand_name=itemView.findViewById(R.id.brand_name);
            sprice=itemView.findViewById(R.id.selling_price);
            pprice=itemView.findViewById(R.id.product_price);
            add=itemView.findViewById(R.id.addd);
            minus=itemView.findViewById(R.id.remove);
            item_qty=itemView.findViewById(R.id.product_qty);
            product_delete=itemView.findViewById(R.id.product_del);
        }
    }

}
