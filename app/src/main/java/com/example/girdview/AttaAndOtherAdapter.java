package com.example.girdview;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AttaAndOtherAdapter extends RecyclerView.Adapter<AttaAndOtherAdapter.GridViewHolder> {


    Context context;
    List<AttaAndOtherModel> attaAndOtherModelList;

    public AttaAndOtherAdapter(Context context, List<AttaAndOtherModel> attaAndOtherModelList) {
        this.context = context;
        this.attaAndOtherModelList = attaAndOtherModelList;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_card_for_atta_and_other,parent,false);
        GridViewHolder gridViewHolder=new GridViewHolder(view);
        return  gridViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {

        final AttaAndOtherModel attaAndOtherModel = attaAndOtherModelList.get(position);
       //String item=holder.item_count.getText().toString();
        //final int item=attaAndOtherModel.getQuantity();
        final Myhelper myhelper=new Myhelper(context);
        final SQLiteDatabase database=myhelper.getWritableDatabase();
        final int[] number = {1};
       holder.minus_item.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (number[0] == 1) {
                   holder.item_count.setText(""+number[0]);
               }

               if (number[0] > 1) {

                   number[0] = number[0] - 1;
                   holder.item_count.setText(""+number[0]);
               }
           }
       });
        holder.add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   // attaAndOtherModel.setQuantity(item+1);

                number[0] = number[0] + 1;
                holder.item_count.setText(""+number[0]);
            }
        });
        holder.item_quantity.setText(attaAndOtherModel.getItemQuantity());
        holder.item_price.setText("Out Price: \u20B9"+ attaAndOtherModel.getItemPrice());
        holder.item_left_price.setText("MRP: \u20B9"+ attaAndOtherModel.getItemLeftPrice());
        holder.item_name.setText(attaAndOtherModel.getItemName());
        holder.item_image.setImageResource(attaAndOtherModel.getItemImage());
    holder.add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //SQLiteDatabase mydatabase = openOrCreateDatabase("your database name",MODE_PRIVATE,null);
//            String sql="CREATE TABLE PRODUCT(_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PRODUCT_PRICE TEXT,SELLING_PRICE TEXT)";
            if(holder.add.getText()=="Added")
            {
                //myhelper.getWritableDatabase().execSQL("delete from PRODUCT where NAME="+attaAndOtherModel.getItemName());
              //  myhelper.getWritableDatabase().execSQL("delete from PRODUCT");
                //holder.add.setText("ADD");
                Toast.makeText(context, "Item Already Added", Toast.LENGTH_SHORT).show();
            }
            else {
                ContentValues values = new ContentValues();
                values.put("NAME", attaAndOtherModel.getItemName());
                values.put("PRODUCT_PRICE", "\u20B9" + attaAndOtherModel.getItemLeftPrice());
                values.put("SELLING_PRICE", "\u20B9" + attaAndOtherModel.getItemPrice());
                values.put("QTY",number[0]);
                database.insert("PRODUCT", null, values);
                database.close();
                //holder.add.setText("Remove");
                holder.add.setText("Added");
            }
            }
    });
        holder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                Intent intent=new Intent(context,DescriptionActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return attaAndOtherModelList.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ItemClickListner itemClickListner;
        ImageView item_image,add_item,minus_item;
        TextView item_name,item_quantity,item_left_price,item_price,item_count;
        Button add;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            item_image=itemView.findViewById(R.id.item_image);
            item_name=itemView.findViewById(R.id.item_name);
            item_left_price=itemView.findViewById(R.id.item_price_left);
            item_price=itemView.findViewById(R.id.item_price);
            item_quantity=itemView.findViewById(R.id.item_quantity);
            item_count=itemView.findViewById(R.id.item_count);
            add_item=itemView.findViewById(R.id.add_icon);
            add=itemView.findViewById(R.id.btn_add);
            minus_item=itemView.findViewById(R.id.substract_icon);
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
