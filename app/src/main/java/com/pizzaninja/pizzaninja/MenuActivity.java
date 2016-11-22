package com.pizzaninja.pizzaninja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    private ArrayList<FeedItem> feedsList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static MenuActivity ma = null;
    OrderDetails od;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        od = OrderDetails.getInstance();
        AddItems();

        mRecyclerView = (RecyclerView) findViewById(R.id.menu_list);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(MenuActivity.this, feedsList);
        mRecyclerView.setAdapter(mAdapter);
    }

    public static MenuActivity getInstance() {
        if (ma == null) {
            ma = new MenuActivity();
        }
        return ma;
    }

    public void AddItem(String item)
    {
        if (item.contains("Pizza"))
        {
            Intent intent = new Intent(this, BuildPizzaActivity.class);
            startActivity(intent);
        }
        else
        {
            od.addItem(new OrderDetails.Item(item, 2.99));
        }
    }

    private void AddItems()
    {
        feedsList = new ArrayList<>();
        for (int i = 0; i < 15; i++)
        {
            feedsList.add(new FeedItem());
        }
        feedsList.get(0).setTitle("Small Pizza");
        feedsList.get(1).setTitle("Medium Pizza");
        feedsList.get(2).setTitle("Large Pizza");
        feedsList.get(3).setTitle("XL Pizza");
        feedsList.get(4).setTitle("Calzone");
        feedsList.get(5).setTitle("Big Salad");
        feedsList.get(6).setTitle("Wings");
        feedsList.get(7).setTitle("Boneless Wings");
        feedsList.get(8).setTitle("Garlic Cheese Bread");
        feedsList.get(9).setTitle("Breadsticks");
        feedsList.get(10).setTitle("Garlic Cream Cheese");
        feedsList.get(11).setTitle("Garlic Butter");
        feedsList.get(12).setTitle("Marinara");
        feedsList.get(13).setTitle("Ranch Dressing");
        feedsList.get(14).setTitle("French Dressing");
    }

    public void OpenSpecials(View view)
    {
        Intent intent = new Intent(MenuActivity.this, SpecialsActivity.class);
        startActivity(intent);
    }

    public void OpenOrder(View view)
    {
        Intent intent = new Intent(MenuActivity.this, ConfirmOrderActivity.class);
        startActivity(intent);
    }
}
