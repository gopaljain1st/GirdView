package com.example.girdview;


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

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private Context context;
    private List<Order> personUtils;

    public OrderAdapter(Context context, List personUtils) {
        this.context = context;
        this.personUtils = personUtils;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_to_order, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Order pu = personUtils.get(position);
       /* final Myhelper myhelper=new Myhelper(context);
        final SQLiteDatabase database=myhelper.getWritableDatabase();*/
        holder.itemimage.setImageResource(pu.getImageid());
        holder.product_name.setText(pu.getProductname());
        holder.brand_name.setText(pu.getBrandname());
        holder.pprice.setText(pu.getProductprice());
        holder.sprice.setText(pu.getSellingPrice());
        holder.item_qty.setText(""+pu.getQty());
    }

    @Override
    public int getItemCount() {
        return personUtils.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemimage;
        TextView product_name,brand_name,pprice,sprice,item_qty;

        public ViewHolder(View itemView) {
            super(itemView);
            itemimage=itemView.findViewById(R.id.product_img);
            product_name =  itemView.findViewById(R.id.product_name);
            brand_name=itemView.findViewById(R.id.brand_name);
            sprice=itemView.findViewById(R.id.selling_price);
            pprice=itemView.findViewById(R.id.product_price);
            item_qty=itemView.findViewById(R.id.product_qty);
        }
    }
}
