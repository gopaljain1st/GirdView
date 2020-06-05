package com.example.girdview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity  implements  NavigationView
        .OnNavigationItemSelectedListener{
    GridView gridView;
    ViewPager viewPager;
NotificationBadge badge;
    Toolbar toolbar;
    DrawerLayout mDrawerLayout;

    String[] fruitNames = {"Atta & Other Flours","Rice & Other Grains","Edible Oils & Ghee ","Tea & Coffee","Salt & Sugar","Hair Care","Laundry & Detergent","Masalas"};
    int[] fruitImages = {R.drawable.geo11,R.drawable.rice_grid,R.drawable.edilble,R.drawable.tea,R.drawable.sugar_grid,R.drawable.shampoo_grid,R.drawable.detergent,R.drawable.masala};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_layout);


        if(Build.VERSION.SDK_INT>=21){
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        }


        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Home");

        mDrawerLayout=findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this,mDrawerLayout,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        NavigationView navigationView=findViewById(R.id.navigation_view);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);




        viewPager=findViewById(R.id.view_pager);

        PackagesAdapter packagesAdapter=new PackagesAdapter(this);
        viewPager.setAdapter(packagesAdapter);

        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),1000,2000);

        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: {
                        Intent intent = new Intent(getApplicationContext(), AttaAndOtherActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        Intent intent1 = new Intent(getApplicationContext(), RiceAndOtherGains.class);
                        startActivity(intent1);
                        break;
                    }
                    case 2: {
                        Intent intent2 = new Intent(getApplicationContext(), OilsAndGhee.class);
                        startActivity(intent2);
                        break;
                    }
                    case 3: {
                        Intent intent3 = new Intent(getApplicationContext(), TeaAndCoffee.class);
                        startActivity(intent3);
                        break;
                    }
                    case 4: {
                        Intent intent4 = new Intent(getApplicationContext(), SaltAndSugarActivity.class);
                        startActivity(intent4);
                        break;
                    }
                    case 5: {
                        Intent intent5 = new Intent(getApplicationContext(), HairCareActivity.class);
                        startActivity(intent5);
                        break;
                    }
                    case 7: {
                        Intent intent7 = new Intent(getApplicationContext(), MasalaActivity.class);
                        startActivity(intent7);
                        break;
                    }
                    case 6: {
                        Intent intent8 = new Intent(getApplicationContext(), LaundryAndDetergentActivity.class);
                        startActivity(intent8);
                        break;
                    }


                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_drawer_menu,menu);
       /* View view=menu.findItem(R.id.cart).getActionView();
        badge=(NotificationBadge) view.findViewById(R.id.badge);
        badge.setText(""+getProfilesCount());*/
        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    public long getProfilesCount() {
        Myhelper myhelper=new Myhelper(this);
        SQLiteDatabase db = myhelper.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, "PRODUCT");
        db.close();
        return count;
    }
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cart:
                startActivity(new Intent(MainActivity.this, CartActivity.class));
                break;
            case R.id.home:
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                break;
            case R.id.chatandcomplain:
            {//startActivity(new Intent(MainActivity.this, CartActivity.class));
                Toast.makeText(this, "Chat And Complain", Toast.LENGTH_SHORT).show();
                break;}
            case R.id.myorder:
                startActivity(new Intent(MainActivity.this, MyorderActivity.class));
                //Toast.makeText(this, "My Order", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_logout:
            {
                SharedPreferences prefs = this.getSharedPreferences("User_Info", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("email", "");     //RESET TO DEFAULT VALUE
                editor.putString("password", "");     //RESET TO DEFAULT VALUE
                editor.commit();
                Toast.makeText(this, "Succefully Logout", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return fruitImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View view1 = getLayoutInflater().inflate(R.layout.custome_item,null);
            TextView name = view1.findViewById(R.id.fruits);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(fruitNames[i]);
            image.setImageResource(fruitImages[i]);
            return view1;
        }


    }
    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                    }
                    else if(viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }
                    else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }

    }
}