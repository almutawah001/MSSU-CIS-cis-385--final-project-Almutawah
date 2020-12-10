package com.finalproject.smartpizzashop.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.finalproject.smartpizzashop.model.Order;
import com.finalproject.smartpizzashop.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAssistant extends SQLiteOpenHelper {
        Context ctx;

public DatabaseAssistant(Context context) {
        super(context,  "SmartPizzaShop", null,  1);
        this.ctx = context;
        }

@Override
public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String qry = "create table " +  "Orders" + " ( "+
         " id INTEGER PRIMARY KEY, "
        + " customerName TEXT, "
        + " serving TEXT, "
        +  "pizzaName TEXT, "
                + " price TEXT, "
        +  " extraTopping TEXT, "
        +   " address TEXT, "
        +  "contactNUmber TEXT, "
        +  " crust   TEXT"  + " )";
        sqLiteDatabase.execSQL(qry);


        String qry1 = "create table " +  "PizzaTable" + " ( "+
                " id INTEGER PRIMARY KEY, "
                + "  title TEXT, "
                + " serving TEXT, "

                +  " topping TEXT, "
                +   " crust TEXT, "
                +  " size TEXT, "
                +  "  price  TEXT,"
                +  "  ingredients  TEXT"
                + " )";
        sqLiteDatabase.execSQL(qry1);




}

@Override
public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists PizzaTable");
        sqLiteDatabase.execSQL("drop table if exists Orders");
        onCreate(sqLiteDatabase);
        }
public void AddPizza(Pizza pizza
) {






        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put( "title",  pizza.getTitle());
        cv.put( "serving",  pizza.getServings());
        cv.put( "topping",  pizza.getTopping());
        cv.put( "crust",  pizza.getCrust());
        cv.put( "size",  pizza.getSize());
        cv.put( "price",  pizza.getPrice());
        cv.put( "ingredients",  pizza.getIngredients());



        db.insert( "PizzaTable", null, cv);
        Log.d("SAVED!!", "Saved to DB ");
        db.close();

        }

        public void AddOrder(Order order
        ) {



                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put( "customerName",  order.getCustomerName());
                cv.put( "serving",  order.getServings());
                cv.put( "pizzaName",  order.getPizzaName());
                cv.put( "extraTopping",  order.getExtraToppings());
                cv.put( "address",  order.getAddress());
                cv.put( "contactNUmber",  order.getContactNumber());
                cv.put( "crust",  order.getCrust());
                 cv.put( "price",  order.getPrice());




            db.insert( "Orders", null, cv);
                Log.d("SAVED!!", "Saved to DB ");
                db.close();

        }





   public ArrayList<Pizza> getAllPizza( ) {
        ArrayList<Pizza> recipeList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        String qry2 = "select * from  PizzaTable   " ;
        Cursor cursor = db.rawQuery(qry2, null);
        if (cursor.moveToFirst()) {
        do {
                  Pizza pizza = new Pizza();

                    pizza.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                    pizza.setPrice(cursor.getString(cursor.getColumnIndex("price")));
                    pizza.setSize(cursor.getString(cursor.getColumnIndex("size")));
                    pizza.setTopping(cursor.getString(cursor.getColumnIndex("topping")));
                    pizza.setIngredients(cursor.getString(cursor.getColumnIndex("ingredients")));
                    pizza.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    recipeList.add(pizza);
        } while (cursor.moveToNext());
        }
        return recipeList;
        }

        public Pizza getOnePizza(int id) {
                Pizza pizza = new Pizza();

                String qry2 = "select * from  PizzaTable  where  id = " + String.valueOf(id);

                SQLiteDatabase db = this.getReadableDatabase();
                Cursor cursor = db.rawQuery(qry2, null);
                if (cursor != null) cursor.moveToFirst();
                pizza.setId(cursor.getInt(cursor.getColumnIndex("id")));
                pizza.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                pizza.setServings(cursor.getString(cursor.getColumnIndex("serving")));
                pizza.setCrust(cursor.getString(cursor.getColumnIndex("crust")));
                pizza.setIngredients(cursor.getString(cursor.getColumnIndex("ingredients")));
                pizza.setTopping(cursor.getString(cursor.getColumnIndex("topping")));
                pizza.setSize(cursor.getString(cursor.getColumnIndex("size")));

                return pizza;

        }








        public List<Order> getAllOrders( ) {
                List<Order> OrderList = new ArrayList<>();
                SQLiteDatabase db = this.getWritableDatabase();

                String qry2 = "select * from   Orders " ;
                Cursor cursor = db.rawQuery(qry2, null);
                if (cursor.moveToFirst()) {
                        do {
                                Order order = new Order();

                                order.setCustomerName(cursor.getString(cursor.getColumnIndex("customerName")));
                                order.setPrice(cursor.getString(cursor.getColumnIndex("price")));
                                 order.setContactNumber (cursor.getString(cursor.getColumnIndex("contactNUmber")));
                                 order.setPizzaName(cursor.getString( cursor.getColumnIndex("pizzaName")));
                                 order.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                                order.setId(cursor.getInt(cursor.getColumnIndex("id")));
                                 OrderList.add(order);
                        } while (cursor.moveToNext());
                }
                return OrderList;
        }






        public Order getOneOrder(int id) {
                Order order = new Order();

                String qry2 = "select * from   Orders  where  id = " + String.valueOf(id);

                SQLiteDatabase db = this.getReadableDatabase();
                Cursor cursor = db.rawQuery(qry2, null);
                if (cursor != null) cursor.moveToFirst();
                order.setId(cursor.getInt(cursor.getColumnIndex("id")));
                order.setCustomerName(cursor.getString(cursor.getColumnIndex("customerName")));
                order.setServings(cursor.getString(cursor.getColumnIndex("serving")));
                order.setPizzaName(cursor.getString(cursor.getColumnIndex("pizzaName")));
                order.setExtraToppings(cursor.getString(cursor.getColumnIndex("extraTopping")));
                order.setContactNumber(cursor.getString(cursor.getColumnIndex("topping")));
                order.setCrust(cursor.getString(cursor.getColumnIndex("crust")));
                order.setAddress(cursor.getString(cursor.getColumnIndex("address")));

                return order;









        }

}

