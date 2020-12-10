package com.finalproject.smartpizzashop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dashboard extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.setting_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView = findViewById(R.id.bottomNav);
        Fragment selectedfragment = new pizzafragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedfragment).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedfragment = null;
                switch (item.getItemId()) {
                    case R.id.pizza: {
                      selectedfragment = new pizzafragment();
                      break;
                    }
                    case R.id.orders: {
                    selectedfragment = new OrderFragment();
                        break;
                    }

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedfragment).commit();
                return true;
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.settings:
                Intent intent = new Intent(dashboard.this, SettingsActivity.class);
                startActivity(intent);
                return true;



        }
        return super.onOptionsItemSelected(item);
    }
}