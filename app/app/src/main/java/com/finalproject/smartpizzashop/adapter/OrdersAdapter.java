package com.finalproject.smartpizzashop.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.finalproject.smartpizzashop.R;
import com.finalproject.smartpizzashop.model.Order;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrdersAdapter     extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {

    List<Order> orders  ;

    private Context mContext;

    public OrdersAdapter(  List<Order> im, Context context) {
        mContext = context;

        orders = im;


    }

    @NonNull
    @Override
    public OrdersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_item, viewGroup, false);
        return new OrdersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersAdapter.ViewHolder viewHolder, int i) {

        Bitmap bitmap;
        int size = orders.size();

        if (orders != null) {
            Order imOrder = orders.get(i);
             viewHolder.name.setText(imOrder.getCustomerName());
             viewHolder.price.setText(imOrder.getPrice());
             viewHolder.address.setText(imOrder.getAddress());
             viewHolder.pizza.setText(imOrder.getPizzaName());
             viewHolder.number.setText(imOrder.getContactNumber());
            //String server =  image.getImageFromServer();
            //String local  =  image.getImageFromLockl();


        }


    }


    @Override
    public int getItemCount() {

        return orders.size();


    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,price,number,pizza,address;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            price= itemView.findViewById(R.id.price);
            number= itemView.findViewById(R.id.number);
            pizza= itemView.findViewById(R.id.piza);
            address=  itemView.findViewById(R.id.address);



        }


    }

}