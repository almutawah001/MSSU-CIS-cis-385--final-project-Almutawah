package com.finalproject.smartpizzashop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.finalproject.smartpizzashop.R;
import com.finalproject.smartpizzashop.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class  PizzaAdapter   extends RecyclerView.Adapter< PizzaAdapter .ViewHolder> {

      ArrayList<Pizza> pizza = new ArrayList<>();

private Context mContext;

public  PizzaAdapter (ArrayList <Pizza> im, Context context) {
        mContext = context;

        pizza = im;


        }

@NonNull
@Override
public  PizzaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pizza_item, viewGroup, false);
        return new  PizzaAdapter .ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull PizzaAdapter.ViewHolder viewHolder, int i) {

         int size = pizza.size();

        if (pizza != null) {
        Pizza mPizza = pizza.get(i);
        viewHolder.name.setText(mPizza.getTitle());
        viewHolder.price.setText(mPizza.getPrice());
        viewHolder.size.setText(mPizza.getSize());
        viewHolder.ingredients.setText(mPizza.getIngredients());
        viewHolder.topping.setText(mPizza.getTopping());
        //String server =  image.getImageFromServer();
        //String local  =  image.getImageFromLockl();


        }


        }


@Override
public int getItemCount() {

        return pizza.size();


        }

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView name,price,size,topping,ingredients;


    public ViewHolder(@NonNull final View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        price= itemView.findViewById(R.id.price);
        size= itemView.findViewById(R.id.size);
        topping=  itemView.findViewById(R.id.topping);
        ingredients=  itemView.findViewById(R.id.ingredients);




    }


}

}