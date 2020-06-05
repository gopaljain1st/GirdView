package com.example.girdview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TeaAndCoffee extends AppCompatActivity {
    private static final String apiurl="https://simplyfied.co.in/groceryapp/fetchadditem.php";
    RecyclerView recyclerView;
   // ArrayList<TeaAndCoffeeModel> teaAndCoffeeModelArrayList;
    ArrayList<AttaAndOtherModel> teaAndCoffeeModelArrayList;
    AttaAndOtherAdapter gridItemAdapter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_tea_and_coffee);
        setContentView(R.layout.activity_atta_and_other);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Tea And Coffee");


       // recyclerView=findViewById(R.id.recycle_view_tea_and_coffee);
        recyclerView=findViewById(R.id.recycle_view_item);
        teaAndCoffeeModelArrayList=new ArrayList<>();

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        // recyclerView.setAdapter(teaAndCoffeeAdapter);
        gridItemAdapter=new AttaAndOtherAdapter(this, teaAndCoffeeModelArrayList);
        recyclerView.setAdapter(gridItemAdapter);
      /*  teaAndCoffeeModelArrayList.add(new TeaAndCoffeeModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new TeaAndCoffeeModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new TeaAndCoffeeModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new TeaAndCoffeeModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new TeaAndCoffeeModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new TeaAndCoffeeModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new TeaAndCoffeeModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new TeaAndCoffeeModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new TeaAndCoffeeModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new TeaAndCoffeeModel(R.drawable.geo14,"Tea","85","20","100gm"));*/

      /*  teaAndCoffeeModelArrayList.add(new AttaAndOtherModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new AttaAndOtherModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new AttaAndOtherModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new AttaAndOtherModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new AttaAndOtherModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new AttaAndOtherModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new AttaAndOtherModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new AttaAndOtherModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new AttaAndOtherModel(R.drawable.geo14,"Tea","85","20","100gm"));
        teaAndCoffeeModelArrayList.add(new AttaAndOtherModel(R.drawable.geo14,"Tea","85","20","100gm"));*/
      // TeaAndCoffeeAdapter teaAndCoffeeAdapter=new TeaAndCoffeeAdapter(this,teaAndCoffeeModelArrayList);

        progressDialog=new ProgressDialog(TeaAndCoffee.this,R.style.MyAlertDialogStyle);
        progressDialog.setTitle("Grocerry");
        progressDialog.setMessage("Please Wait......");

        progressDialog.show();
        StringRequest request=new StringRequest(Request.Method.POST, apiurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // attaAndOtherModels.clear();
                try {
                    //Toast.makeText(AttaAndOtherActivity.this, "" + response, Toast.LENGTH_SHORT).show();
                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    if (sucess.equals("1")) {
                        progressDialog.dismiss();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String id=object.getString("id");
                            String name=object.getString("item_name");
                            String product_price=object.getString("item_mrp");
                            String selling=object.getString("item_outprice");
                            String weight=object.getString("item_weight");
                            teaAndCoffeeModelArrayList.add(new AttaAndOtherModel(R.drawable.rice_grid,name,weight,product_price,selling));
                            gridItemAdapter.notifyDataSetChanged();
                        }
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(TeaAndCoffee.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
