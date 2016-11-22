package com.pizzaninja.pizzaninja;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    private ArrayList<FeedItem> feedsList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    OrderDetails od;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        od = OrderDetails.getInstance();
        FillItems();

        mRecyclerView = (RecyclerView) findViewById(R.id.menu_list);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(MenuActivity.this, feedsList);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void AddItem(String item)
    {
        if (item.contains("Pizza"))
        {
            double cost = 10.99;
            String size = "Large";
            if (item.contains("Small"))
            {
                size = "Small";
                cost = 6.99;
            }
            if (item.contains("Medium"))
            {
                size = "Medium";
                cost = 8.99;
            }
            if (item.contains("XL"))
            {
                size = "XL";
                cost = 12.99;
            }
            Intent intent = new Intent(this, BuildPizzaActivity.class);
            Bundle b = new Bundle();
            b.putString("pizzasize", size);
            b.putDouble("pizzacost", cost);
            intent.putExtras(b);
            startActivityForResult(intent, 1);
        }
        else
        {
            double cost = 3.99;
            switch (item)
            {
                case "Calzone":
                    cost = 6.99;
                    break;
                case "Big Salad":
                    cost = 4.99;
                    break;
                case "Wings":
                    cost = 5.99;
                    break;
                case "Boneless Wings":
                    cost = 5.99;
                    break;
                case "Garlic Cheese Bread":
                    cost = 4.99;
                    break;
                case "Breadsticks":
                    cost = 3.99;
                    break;
                case "Garlic Cream Cheese":
                    cost = 1.99;
                    break;
                case "Garlic Butter":
                    cost = 0.99;
                    break;
                case "Marinara":
                    cost = 0.99;
                    break;
                case "Ranch Dressing":
                    cost = 0.99;
                    break;
                case "French Dressing":
                    cost = 0.99;
                    break;
            }
            od.addItem(new OrderDetails.Item(item, cost));
            Context context = getApplicationContext();
            CharSequence text = "Added " + item;
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    private void FillItems()
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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                Context context = getApplicationContext();
                CharSequence text = "Added Pizza";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }
    }
}
