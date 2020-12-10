package com.finalproject.smartpizzashop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.finalproject.smartpizzashop.database.DatabaseAssistant;
import com.finalproject.smartpizzashop.model.Order;
import com.google.android.material.textfield.TextInputEditText;

import java.security.SecurityPermission;
import java.util.Random;

public class addOrder extends AppCompatActivity {
    Button btnAddPizza;
    TextInputEditText name, price,time,address,pizzaname,extraToppinng,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPrefs  = PreferenceManager.getDefaultSharedPreferences( addOrder.this);
        boolean darkTheme = sharedPrefs.getBoolean( SettingsFragment.PREFERENCE_THEME, false);
        if (darkTheme) {


        }
        setContentView(R.layout.activity_add_order);
        btnAddPizza = findViewById(R.id.save);
        pizzaname= findViewById(R.id.pizzaname);
        name = findViewById(R.id.name);
        extraToppinng=  findViewById(R.id.extraTopping);
        address = findViewById(R.id.crustType);
        price = findViewById(R.id.price);
        time=findViewById(R.id.prepTime);
        contact= findViewById(R.id.contact);
        btnAddPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sname =  name.getText().toString();
                String Sprice=  price.getText().toString();
                String Stime  ="";
                String  Scrust= address.getText().toString();
                boolean errror=false;

                if(Scrust!=null){
                    if(Scrust.equals("")){
                        address.setError("Required");
                        errror=true;

                    }
                }
                else{
                    address.setError("Required");
                    errror=true;
                }
                if(Sname!=null){
                    if(Sname.equals("")){
                        name.setError("Required");
                        errror=true;

                    }
                }
                else{
                    name.setError("Required");
                    errror=true;
                }
                if(Sprice!=null){
                    if(Sprice.equals("")){

                        price.setError("Required");
                        errror=true;
                    }
                }
                else{
                    price.setError("Required");
                    errror=true;
                }


                if (!errror){


                    Order order =  new Order();

                    order.setCustomerName(name.getText().toString());
                    order.setPizzaName(pizzaname.getText().toString());
                     order.setPrice(price.getText().toString());
                      order.setExtraToppings(extraToppinng.getText().toString());
                     order.setAddress(address.getText().toString());
                       order.setContactNumber(contact.getText().toString());

                    DatabaseAssistant da = new DatabaseAssistant(addOrder.this);
                    da.AddOrder(order);


                     sendNotification();
                    Toast.makeText(addOrder.this,"Saved in database",Toast.LENGTH_SHORT).show();
                    finish();



                }

            }
        });
    }

    private  void sendNotification(){

        Intent intent = new Intent( addOrder.this, dashboard.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);




        String channelId = "Default";
        NotificationCompat.Builder builder = new NotificationCompat.Builder( addOrder.this, channelId)
                .setSmallIcon(R.drawable.ic_pizza_shop)
                .setContentTitle("New order Received");

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, "Default channel", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }
        Random random = new Random();
        int m = random.nextInt(9999 - 1000) + 1000;
        manager.notify(m, builder.build());
    }


}