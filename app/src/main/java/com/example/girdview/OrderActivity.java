package com.example.girdview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Order> orders;
    String orderId,time;
    int count=0,totalPrice=0;
    Button placeorder;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);


       placeorder=findViewById(R.id.placeorder);
        orders=new ArrayList<>();
        orderId=""+System.currentTimeMillis();
        time="12:00";
        recyclerView=findViewById(R.id.rerere);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(OrderActivity.this));
        Myhelper myhelper=new Myhelper(this);
        SQLiteDatabase database = myhelper.getReadableDatabase();
        String sql = "select * from PRODUCT";
        Cursor c = database.rawQuery(sql,null);
        orders = new ArrayList<>();
        while(c.moveToNext()){
            int id = c.getInt(0);
            String name =c.getString(1);
            String product_price =c.getString(2);
            String selling_price =c.getString(3);
            int qty = c.getInt(4);
            if(!selling_price.equals(""))
                totalPrice+=Integer.parseInt(selling_price) * qty;
            Order item = new Order(id,1,name,selling_price,qty);
            orders.add(item);
            count++;
        }
        recyclerView.setAdapter(new OrderAdapter(OrderActivity.this,orders));
        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {   final ProgressDialog pd = new ProgressDialog(OrderActivity.this);
                pd.setTitle("Uploading Item....");
                pd.show();
                HashMap<String,ArrayList<Order>> hm = new HashMap<>();
                hm.put("order",orders);
                Gson gson = new Gson();
                final String jsonData = gson.toJson(hm);
                Log.e("JsonData", "onClick: "+jsonData );
                final SharedPreferences shared = getSharedPreferences("User_Info", MODE_PRIVATE);
                String url = "https://simplyfied.co.in/groceryapp/proceed_order.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.dismiss();
                        Toast.makeText(OrderActivity.this, "" + response, Toast.LENGTH_SHORT).show();
                        Log.d("response", "response" + response);
                        pd.dismiss();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.dismiss();
                        Toast.makeText(OrderActivity.this, "" + error, Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> map = new HashMap<>();
                        map.put("allItems",jsonData);
                        map.put("orderId",orderId);
                        map.put("userId",shared.getString("id",""));
                        map.put("name",shared.getString("name",""));
                        map.put("mobile",shared.getString("mobile",""));
                        map.put("address",shared.getString("address",""));
                        map.put("deliveryTime",time);
                        map.put("itemCount",""+count);
                        map.put("totalPrice",""+totalPrice);
                        map.put("orderStatus","Pending");
                        return map;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(OrderActivity.this);
                requestQueue.add(stringRequest);
            }
        });
    }
}
