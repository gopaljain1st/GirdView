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

public class RiceAndOtherGains extends AppCompatActivity {
    private static final String apiurl="https://simplyfied.co.in/groceryapp/fetchadditem.php";
   // ArrayList<RiceAndOtherGainsModel> riceAndOtherGainsModelArrayList;
   ArrayList<AttaAndOtherModel>  riceAndOtherGainsModelArrayList;
    RecyclerView recyclerView;
    AttaAndOtherAdapter gridItemAdapter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_rice_and_other_gains);
        setContentView(R.layout.activity_atta_and_other);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Rice And other Gains");
        recyclerView=findViewById(R.id.recycle_view_item);

        //recyclerView=findViewById(R.id.recycle_view_item_rice);
        riceAndOtherGainsModelArrayList=new ArrayList<>();
        gridItemAdapter=new AttaAndOtherAdapter(this, riceAndOtherGainsModelArrayList);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setAdapter(riceAndOtherGainsAdapter);
        progressDialog=new ProgressDialog(RiceAndOtherGains.this,R.style.MyAlertDialogStyle);
        progressDialog.setTitle("Grocerry");
        progressDialog.setMessage("Please Wait......");

        progressDialog.show();
        recyclerView.setAdapter(gridItemAdapter);
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
                           riceAndOtherGainsModelArrayList.add(new AttaAndOtherModel(R.drawable.rice_grid,name,weight,product_price,selling));
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
                Toast.makeText(RiceAndOtherGains.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        });
      /*  riceAndOtherGainsModelArrayList.add(new RiceAndOtherGainsModel(R.drawable.geo11,"Basmati Rice","300","200","10kg"));
        riceAndOtherGainsModelArrayList.add(new RiceAndOtherGainsModel(R.drawable.geo12,"Basmati Rice","300","200","10kg"));
        riceAndOtherGainsModelArrayList.add(new RiceAndOtherGainsModel(R.drawable.geo1,"Basmati Rice","300","200","10kg"));
        riceAndOtherGainsModelArrayList.add(new RiceAndOtherGainsModel(R.drawable.geo2,"Basmati Rice","300","200","10kg"));
        riceAndOtherGainsModelArrayList.add(new RiceAndOtherGainsModel(R.drawable.geo13,"Basmati Rice","300","200","10kg"));
        riceAndOtherGainsModelArrayList.add(new RiceAndOtherGainsModel(R.drawable.geo14,"Basmati Rice","300","200","10kg"));
        riceAndOtherGainsModelArrayList.add(new RiceAndOtherGainsModel(R.drawable.geo10,"Basmati Rice","300","200","10kg"));
        riceAndOtherGainsModelArrayList.add(new RiceAndOtherGainsModel(R.drawable.geo9,"Basmati Rice","300","200","10kg"));
*//*
        riceAndOtherGainsModelArrayList.add(new  AttaAndOtherModel(R.drawable.geo11,"Basmati Rice","300","200","10kg"));
        riceAndOtherGainsModelArrayList.add(new  AttaAndOtherModel(R.drawable.geo12,"Basmati Rice","300","200","10kg"));
        riceAndOtherGainsModelArrayList.add(new  AttaAndOtherModel(R.drawable.geo1,"Basmati Rice","300","200","10kg"));
        riceAndOtherGainsModelArrayList.add(new  AttaAndOtherModel(R.drawable.geo2,"Basmati Rice","300","200","10kg"));
        riceAndOtherGainsModelArrayList.add(new  AttaAndOtherModel(R.drawable.geo13,"Basmati Rice","300","200","10kg"));
        riceAndOtherGainsModelArrayList.add(new  AttaAndOtherModel(R.drawable.geo14,"Basmati Rice","300","200","10kg"));
        riceAndOtherGainsModelArrayList.add(new  AttaAndOtherModel(R.drawable.geo10,"Basmati Rice","300","200","10kg"));
        riceAndOtherGainsModelArrayList.add(new  AttaAndOtherModel(R.drawable.geo9,"Basmati Rice","300","200","10kg"));
*/
        //RiceAndOtherGainsAdapter riceAndOtherGainsAdapter=new RiceAndOtherGainsAdapter(this,riceAndOtherGainsModelArrayList);

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
