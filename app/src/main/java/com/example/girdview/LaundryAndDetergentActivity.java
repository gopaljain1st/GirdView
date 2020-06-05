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

public class LaundryAndDetergentActivity extends AppCompatActivity {
    private static final String apiurl="https://simplyfied.co.in/groceryapp/fetchadditem.php";
    RecyclerView recyclerView;
//ArrayList<LaundryAndDetergentModel>laundryAndDetergentModelArrayList;
    ArrayList<AttaAndOtherModel>laundryAndDetergentModelArrayList;
    AttaAndOtherAdapter gridItemAdapter;
    ProgressDialog progressDialog;
//LaundryAndDetergentAdapter laundryAndDetergentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_laundry_and_detergent);
        setContentView(R.layout.activity_atta_and_other);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Detergent");


       // recyclerView=findViewById(R.id.recycle_view_laundry);
        recyclerView=findViewById(R.id.recycle_view_item);
        laundryAndDetergentModelArrayList=new ArrayList<>();
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        gridItemAdapter=new AttaAndOtherAdapter(this, laundryAndDetergentModelArrayList);
        recyclerView.setAdapter(gridItemAdapter);
        progressDialog=new ProgressDialog(LaundryAndDetergentActivity.this,R.style.MyAlertDialogStyle);
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
                         laundryAndDetergentModelArrayList.add(new AttaAndOtherModel(R.drawable.rice_grid,name,weight,product_price,selling));
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
                Toast.makeText(LaundryAndDetergentActivity.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);

       /* laundryAndDetergentModelArrayList.add(new LaundryAndDetergentModel(R.drawable.deter1,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new LaundryAndDetergentModel(R.drawable.deter2,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new LaundryAndDetergentModel(R.drawable.deter1,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new LaundryAndDetergentModel(R.drawable.deter1,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new LaundryAndDetergentModel(R.drawable.deter1,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new LaundryAndDetergentModel(R.drawable.deter1,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new LaundryAndDetergentModel(R.drawable.deter1,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new LaundryAndDetergentModel(R.drawable.deter1,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new LaundryAndDetergentModel(R.drawable.deter1,"Detergent","100gm","5","100"));
*/
    /*    laundryAndDetergentModelArrayList.add(new AttaAndOtherModel(R.drawable.deter1,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new AttaAndOtherModel(R.drawable.deter2,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new AttaAndOtherModel(R.drawable.deter1,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new AttaAndOtherModel(R.drawable.deter1,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new AttaAndOtherModel(R.drawable.deter1,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new AttaAndOtherModel(R.drawable.deter1,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new AttaAndOtherModel(R.drawable.deter1,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new AttaAndOtherModel(R.drawable.deter1,"Detergent","100gm","5","100"));
        laundryAndDetergentModelArrayList.add(new AttaAndOtherModel(R.drawable.deter1,"Detergent","100gm","5","100"));
*/
      //  LaundryAndDetergentAdapter laundryAndDetergentAdapter=new LaundryAndDetergentAdapter(this, laundryAndDetergentModelArrayList);



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
