package com.example.girdview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MyorderActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Myorder> myorders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        myorders=new ArrayList<>();
        recyclerView=findViewById(R.id.rerere);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyorderActivity.this));
        myorders.add(new Myorder("31/05/2020","15:25","1597534682","Shipped","5","370"));
        myorders.add(new Myorder("31/05/2020","15:25","1597534682","Shipped","5","370"));
        myorders.add(new Myorder("31/05/2020","15:25","1597534682","Shipped","5","370"));
        myorders.add(new Myorder("31/05/2020","15:25","1597534682","Shipped","5","370"));
        recyclerView.setAdapter(new MyorderAdapter(MyorderActivity.this,myorders));
    }
}
