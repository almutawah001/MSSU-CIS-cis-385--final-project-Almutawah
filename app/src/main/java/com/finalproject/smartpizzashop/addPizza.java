package com.finalproject.smartpizzashop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.finalproject.smartpizzashop.database.DatabaseAssistant;
import com.finalproject.smartpizzashop.model.Pizza;
import com.google.android.material.textfield.TextInputEditText;

import java.security.SecurityPermission;

public class addPizza extends AppCompatActivity {
     Button btnAddPizza;
     TextInputEditText name, price,time,extraTopping,ingredients,size,crustType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pizza);
     btnAddPizza = findViewById(R.id.save);
        extraTopping =  findViewById(R.id.extraTopping);
     name = findViewById(R.id.name);
        size= findViewById(R.id.size);
        ingredients= findViewById(R.id.ingredients);
     price = findViewById(R.id.price);

     time=findViewById(R.id.prepTime);
        crustType= findViewById(R.id.crustType);
     btnAddPizza.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String Sname =  name.getText().toString();
             String Sprice=  price.getText().toString();
             String Stime = "";
             boolean errror=false;
             Pizza pizza =new Pizza();
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
                   pizza.setTitle(name.getText().toString());
                   pizza.setPrice(price.getText().toString());
                   pizza.setTopping(extraTopping.getText().toString());
                   pizza.setIngredients(ingredients.getText().toString());
                   pizza.setSize(size.getText().toString());
                    pizza.setCrust(crustType.getText().toString());


                  DatabaseAssistant da = new DatabaseAssistant(addPizza.this);
                  da.AddPizza(pizza);



                 Toast.makeText(addPizza.this,"Saved in database",Toast.LENGTH_SHORT).show();
                 finish();

             }

         }
     });
    }


}