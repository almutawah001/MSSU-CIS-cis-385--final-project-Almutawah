package com.finalproject.smartpizzashop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homeScreen extends AppCompatActivity {
Button addPizza,viewPizza,addOrder,viewOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        addPizza = findViewById(R.id.addPizza);
        viewPizza=  findViewById(R.id.viewPizza);
        viewOrders= findViewById(R.id.viewOrder);
        addOrder = findViewById(R.id.addOrder);




    }
}