package com.example.a15056112.firebaseinventoryapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15056112 on 1/8/2017.
 */

public class InventoryAdapter extends ArrayAdapter<Inventory> {

    private Context context;
    private ArrayList<Inventory> inventory;
    private int resource;
    private TextView tvName, tvPrice;
    private ImageView ivLogo;

    public InventoryAdapter(Context context, int resource, ArrayList<Inventory> alInventory) {
        super(context, resource, alInventory);
        this.context = context;
        this.resource = resource;
        this.inventory = alInventory;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.row, parent, false);

        tvName = (TextView)view.findViewById(R.id.tvName);
        tvPrice = (TextView)view.findViewById(R.id.tvPrice);
        ivLogo = (ImageView)view.findViewById(R.id.ivLogo);

        Inventory wholeLists = inventory.get(position);
        tvName.setText(wholeLists.getName());
        tvPrice.setText("" + wholeLists.getPrice());

        if (wholeLists.isLogo()) {
            ivLogo.setImageResource(R.drawable.smartphone);
        }

        return view;
    }
}
