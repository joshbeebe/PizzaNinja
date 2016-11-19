package com.pizzaninja.pizzaninja;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;

public class ConfirmOrderActivity extends AppCompatActivity {

    OrderDetails od;
    ArrayList<String> items =  new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        od = OrderDetails.getInstance();
        ListView list = (ListView) findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        list.setAdapter(adapter);

        populateList();
    }

    private void populateList() {
        for (OrderDetails.Item i : od.OrderList) {
            items.add(i.name);
        }
        adapter.notifyDataSetChanged();
    }
}
