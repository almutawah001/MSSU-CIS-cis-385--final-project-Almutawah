package com.finalproject.smartpizzashop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.finalproject.smartpizzashop.adapter.PizzaAdapter;
import com.finalproject.smartpizzashop.database.DatabaseAssistant;
import com.finalproject.smartpizzashop.model.Pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link pizzafragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class pizzafragment extends Fragment {
    Button btnAddPizza;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public pizzafragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment pizzafragment.
     */
    // TODO: Rename and change types and number of parameters
    public static pizzafragment newInstance(String param1, String param2) {
        pizzafragment fragment = new pizzafragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
RecyclerView rcv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // In
        // flate the layout for this fragment
        View v;


        v = inflater.inflate(R.layout.fragment_pizzafragment, container, false);
        btnAddPizza = v.findViewById(R.id.addPizza);
        rcv = v.findViewById(R.id.rcvPizza);
        loadAdapterData();
        btnAddPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),addPizza.class);
                startActivity(intent);

            }
        });
        return v;
    }

    private void loadAdapterData() {



        DatabaseAssistant da =  new DatabaseAssistant(getContext());
        ArrayList<Pizza> list;
        list=  da.getAllPizza();


        LinearLayoutManager layoutManager1 = new LinearLayoutManager( getContext(), LinearLayoutManager.VERTICAL, false);
        rcv.setLayoutManager(layoutManager1);

        PizzaAdapter adapter2 = new PizzaAdapter(list,getContext());
        rcv.setAdapter(adapter2);







    }


}