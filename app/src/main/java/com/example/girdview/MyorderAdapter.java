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

public class MyorderAdapter extends RecyclerView.Adapter<MyorderAdapter.ViewHolder> {

    private Context context;
    private List<Myorder> personUtils;

    public MyorderAdapter(Context context, List personUtils) {
        this.context = context;
        this.personUtils = personUtils;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.myorder_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Myorder pu = personUtils.get(position);
       /* final Myhelper myhelper=new Myhelper(context);
        final SQLiteDatabase database=myhelper.get<?xml version="1.0" encoding="utf-8"?>
<android.support.v7.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="150dp"
    android:layout_margin="3dp"
    android:id="@+id/order_history_cart"
    app:cardElevation="5dp"
    android:elevation="5dp">


    <android.support.constraint.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@drawable/b1">

        <TextView
            android:id="@+id/order_date"
            android:layout_width="75dp"
            android:layout_height="16dp"
            android:layout_marginLeft="8dp"
            android:layout_marginTop="8dp"
            android:text="20/04/1997"
            android:textColor="@color/white"
            android:textStyle="bold"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/order_time"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginEnd="8dp"
            android:text="20:18:35"
            android:textColor="@color/white"
            app:layout_constraintBaseline_toBaselineOf="@+id/order_date"
            app:layout_constraintEnd_toEndOf="parent" />


        <LinearLayout
            android:id="@+id/linearLayout"
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:layout_marginTop="32dp"
            android:background="#ec526576"
            android:orientation="horizontal"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/orderIdText"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="8dp"
            android:text="OrderId"
            android:textColor="#8795bb"
            app:layout_constraintBottom_toTopOf="@+id/statustText"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/linearLayout" />

        <TextView
            android:id="@+id/statustText"
            android:layout_width="wrap_content"
            android:layout_height="17dp"
            android:layout_marginStart="8dp"
            android:text="Status"
            android:textColor="#8795bb"
            app:layout_constraintBottom_toTopOf="@+id/totalSavingsText"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/orderIdText" />

        <TextView
            android:id="@+id/totalSavingsText"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="8dp"
            android:text="Total Savings"
            android:textColor="#8795bb"
            app:layout_constraintBottom_toTopOf="@+id/linearLayout2"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/statustText" />

        <TextView
            android:id="@+id/payableAmountText"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginEnd="8dp"
            android:text="Payable Amount"
            android:textColor="#8795bb"
            app:layout_constraintBaseline_toBaselineOf="@+id/payableAmount"
            app:layout_constraintEnd_toStartOf="@+id/payableAmount" />

        <LinearLayout
            android:id="@+id/linearLayout2"
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:background="#ec526576"
            android:orientation="horizontal"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.82" />

        <TextView
            android:id="@+id/orderId"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="TextView"
            android:textColor="#FFFFFF"
            app:layout_constraintBaseline_toBaselineOf="@+id/orderIdText"
            app:layout_constraintStart_toStartOf="@+id/status" />

        <TextView
            android:id="@+id/status"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="TextView"
            android:textColor="#FFFFFF"
            app:layout_constraintBottom_toTopOf="@+id/total_savings"
            app:layout_constraintStart_toStartOf="@+id/total_savings"
            app:layout_constraintTop_toBottomOf="@+id/orderId" />

        <TextView
            android:id="@+id/total_savings"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="8dp"
            android:text="TextView"
            android:textColor="#FFFFFF"
            app:layout_constraintBaseline_toBaselineOf="@+id/totalSavingsText"
            app:layout_constraintStart_toEndOf="@+id/totalSavingsText" />

        <TextView
            android:id="@+id/payableAmount"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginBottom="8dp"
            android:layout_marginEnd="8dp"
            android:layout_marginTop="8dp"
            android:text="TextView"
            android:textColor="#FFFFFF"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/linearLayout2" />


    </android.support.constraint.ConstraintLayout>
</android.support.v7.widget.CardView>WritableDatabase();*/
        holder.order_date.setText(pu.getDate());
        holder.order_time.setText(pu.getTime());
        holder.order_id.setText(pu.order_id);
        holder.order_status.setText(pu.status);
        holder.total_item.setText(pu.getTotal_item());
        holder.amount.setText(pu.getAmount());
    }

    @Override
    public int getItemCount() {
        return personUtils.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView order_date,order_time,order_id,order_status,total_item,amount;

        public ViewHolder(View itemView) {
            super(itemView);
            order_date=itemView.findViewById(R.id.order_date);
            order_time =  itemView.findViewById(R.id.order_time);
            order_id=itemView.findViewById(R.id.orderId);
            order_status=itemView.findViewById(R.id.status);
            total_item=itemView.findViewById(R.id.total_savings);
            amount=itemView.findViewById(R.id.payableAmount);
        }
    }
}
