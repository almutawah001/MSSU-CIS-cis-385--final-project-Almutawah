package com.finalproject.smartpizzashop;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.finalproject.smartpizzashop.adapter.OrdersAdapter;
import com.finalproject.smartpizzashop.adapter.PizzaAdapter;
import com.finalproject.smartpizzashop.database.DatabaseAssistant;
import com.finalproject.smartpizzashop.model.Order;
import com.finalproject.smartpizzashop.model.Pizza;

import java.util.List;
import java.util.Random;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
RecyclerView rcv;
    Button btnAddOrder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        SharedPreferences sharedPrefs  = PreferenceManager.getDefaultSharedPreferences( getActivity());
        boolean darkTheme = sharedPrefs.getBoolean( SettingsFragment.PREFERENCE_THEME, false);
        if (darkTheme) {


        }
      View v =inflater.inflate(R.layout.fragment_order, container, false);
     rcv = v.findViewById(R.id.rcvOrders);
     loadAdapterData();

        btnAddOrder = v.findViewById(R.id.addOrder);
        btnAddOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent =  new Intent( getActivity(),addOrder.class);
                startActivity(intent);
            }
        });
      return  v;
    }

    private void saveData() {









    }


    private void loadAdapterData() {



        DatabaseAssistant da =  new DatabaseAssistant(getContext());
        List<Order> list;
        list=  da.getAllOrders();


        LinearLayoutManager layoutManager1 = new LinearLayoutManager( getContext(), LinearLayoutManager.VERTICAL, false);
        rcv.setLayoutManager(layoutManager1);

         OrdersAdapter adapter2 = new OrdersAdapter(list,getContext());
         rcv.setAdapter(adapter2);







    }
}