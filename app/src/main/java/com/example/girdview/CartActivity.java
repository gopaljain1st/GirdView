package com.example.girdview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
   Button checkout;
   TextView subt,totall;
    List<Item> orders;
int subtotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        checkout=findViewById(R.id.checkout);
        orders=new ArrayList<>();
        subt=findViewById(R.id.subtotal);
        totall=findViewById(R.id.total);
        recyclerView=findViewById(R.id.rerere);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(CartActivity.this));
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
           // subtotal+=Integer.parseInt(selling_price);
            int qty = c.getInt(4);
            Item item = new Item(R.drawable.login,name,"Fortune",product_price,selling_price,qty);
            orders.add(item);
        }
        orders.add(new Item(R.drawable.icon1,"Fortune Atta","Fortune","350","320",5));
       /* orders.add(new Item(R.drawable.login,"Fortune Atta","Fortune","350","320",4));
        orders.add(new Item(R.drawable.icon,"Fortune Atta","Fortune","350","320",2));
        orders.add(new Item(R.drawable.login,"Fortune Atta","Fortune","350","320",1));*/
        recyclerView.setAdapter(new CustomRecyclerAdapter2(CartActivity  .this,orders));
      //  subt.setText(""+(subtotal+320));
        //totall.setText(""+(subtotal+35));
        final SharedPreferences prefs = this.getSharedPreferences("User_Info", Context.MODE_PRIVATE);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String loginID = prefs.getString("email", "");
                String loginPWD = prefs.getString("password", "");

                if (loginID.length()>0 && loginPWD.length()>0) {
                    Intent intent=new Intent(CartActivity.this,OrderActivity.class);
                    startActivity(intent);
                } else {
                    //SHOW PROMPT FOR LOGIN DETAILS
                    Toast.makeText(CartActivity.this, "Please Login To Continue", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_for_cart,menu);
        MenuItem menuItem=menu.findItem(R.id.cart1);
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
