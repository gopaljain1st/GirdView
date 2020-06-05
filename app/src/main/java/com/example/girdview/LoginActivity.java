package com.example.girdview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    Button login;
    TextView newUser;
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Login");
        email=findViewById(R.id.loginid);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        final SharedPreferences sp = getSharedPreferences("User_Info", MODE_PRIVATE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://simplyfied.co.in/groceryapp/userlogin.php";
                if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Enter all Field", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equalsIgnoreCase("login falied")){
                                 Toast.makeText(LoginActivity.this, "Incorrect Credential"+response, Toast.LENGTH_SHORT).show();
                            }
                            else {

                                // Toast.makeText(LoginActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                                // Log.d("response","response"+response);
                                String arr[] = response.split(" ");
                                SharedPreferences.Editor editor=sp.edit();
                                editor.putString("id",""+arr[0]);
                                editor.putString("name",arr[1]);
                                editor.putString("mobile",arr[2]);
                                editor.putString("city",arr[3]);
                                editor.putString("address",arr[4]);
                                editor.putString("email",email.getText().toString());
                                editor.putString("password",password.getText().toString());
                                editor.commit();
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                Toast.makeText(getApplicationContext(), "Login sucess", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(LoginActivity.this, ""+error, Toast.LENGTH_SHORT).show();
                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String ,String > map=new HashMap<>();

                            map.put("email",email.getText().toString());
                            map.put("password",password.getText().toString());
                            return map;
                        }
                    };
                    RequestQueue requestQueue= Volley.newRequestQueue(LoginActivity.this);
                    requestQueue.add(stringRequest);
                }

            }
        });

        newUser=findViewById(R.id.newUser);
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}
