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

public class HairCareActivity extends AppCompatActivity {
    private static final String apiurl="https://simplyfied.co.in/groceryapp/fetchadditem.php";
    RecyclerView recyclerView;
    //HairCareAdapter hairCareAdapter;
   // ArrayList<HairCareModel> hairCareModelArrayList;
    ArrayList<AttaAndOtherModel> hairCareModelArrayList;
    AttaAndOtherAdapter gridItemAdapter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_hair_care);
        setContentView(R.layout.activity_atta_and_other);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Hair Care");


        //recyclerView=findViewById(R.id.recycle_view_item_hair_care);
        recyclerView=findViewById(R.id.recycle_view_item);

        hairCareModelArrayList=new ArrayList<>();
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        gridItemAdapter=new AttaAndOtherAdapter(this, hairCareModelArrayList);
        recyclerView.setAdapter(gridItemAdapter);
        progressDialog=new ProgressDialog(HairCareActivity.this,R.style.MyAlertDialogStyle);
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
                           hairCareModelArrayList.add(new AttaAndOtherModel(R.drawable.rice_grid,name,weight,product_price,selling));
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
                Toast.makeText(HairCareActivity.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        });
      /*  hairCareModelArrayList.add(new HairCareModel(R.drawable.shampoo,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new HairCareModel(R.drawable.shampoo1,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new HairCareModel(R.drawable.shampoo3,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new HairCareModel(R.drawable.shampp4,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new HairCareModel(R.drawable.shampoo3,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new HairCareModel(R.drawable.shampoo1,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new HairCareModel(R.drawable.shampp4,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new HairCareModel(R.drawable.shampoo,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new HairCareModel(R.drawable.shampoo,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new HairCareModel(R.drawable.shampoo,"Shampoo","150g","220","25"));*/

      /*  hairCareModelArrayList.add(new AttaAndOtherModel(R.drawable.shampoo,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new AttaAndOtherModel(R.drawable.shampoo1,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new AttaAndOtherModel(R.drawable.shampoo3,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new AttaAndOtherModel(R.drawable.shampp4,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new AttaAndOtherModel(R.drawable.shampoo3,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new AttaAndOtherModel(R.drawable.shampoo1,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new AttaAndOtherModel(R.drawable.shampp4,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new AttaAndOtherModel(R.drawable.shampoo,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new AttaAndOtherModel(R.drawable.shampoo,"Shampoo","150g","220","25"));
        hairCareModelArrayList.add(new AttaAndOtherModel(R.drawable.shampoo,"Shampoo","150g","220","25"));
*/
        // hairCareAdapter=new HairCareAdapter(this,hairCareModelArrayList);


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
