package com.pizzaninja.pizzaninja;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class ConfirmOrderActivity extends AppCompatActivity {

    OrderDetails od;
    LinearLayout myRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        od = OrderDetails.getInstance();

        myRoot = (LinearLayout) findViewById(R.id.itemList);

        populateList();
    }

    private void populateList() {
        for (OrderDetails.Item item : od.OrderList) {

            LinearLayout itemDetail = new LinearLayout(this);
            LinearLayout itemRow = new LinearLayout(this);
            itemRow.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams llparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            //setMargins takes px instead of dp, so we need to convert
            //Whole item row
            llparams.setMargins(px(40), px(20), px(40), px(5));
            itemDetail.setLayoutParams(llparams);

            //Remove item button
            TextView remove = new TextView(this);
            remove.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            remove.setText(R.string.action_remove);
            remove.setTextSize(18);

            LinearLayout.LayoutParams rparams = new LinearLayout.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
            rparams.setMargins(0,0,px(15),0);
            remove.setLayoutParams(rparams);
            itemDetail.addView(remove);


            //Item name
            TextView itemName = new TextView(this);
            itemName.setText(item.name);
            itemName.setTextColor(getResources().getColor(android.R.color.black));
            itemName.setTextSize(18);
            LinearLayout.LayoutParams nameParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            nameParams.weight = 1;
            itemName.setLayoutParams(nameParams);
            itemDetail.addView(itemName);


            //Item Price
            TextView itemPrice = new TextView(this);
            itemPrice.setText(String.format("$%.2f", item.price));
            itemPrice.setTextColor(getResources().getColor(android.R.color.black));
            itemPrice.setTextSize(18);
            itemDetail.addView(itemPrice);

            itemDetail.addView(itemRow);
            myRoot.addView(itemDetail);



            //Toppings
            for (String s: item.toppings) {
                TextView topping = new TextView(this);
                topping.setText(s);
                topping.setTextColor(getResources().getColor(android.R.color.black));
                topping.setTextSize(18);

                LinearLayout.LayoutParams toppingParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                toppingParams.setMargins(px(90),0,0,0);
                toppingParams.gravity = Gravity.LEFT;
                topping.setLayoutParams(toppingParams);

                myRoot.addView(topping);
            }

        }
    }

    public void Close(View view)
    {
        finish();
    }

    public void OpenCustomerInfo(View view)
    {
        Intent intent = new Intent(ConfirmOrderActivity.this, CustomerInfoActivity.class);
        startActivity(intent);
    }

    //Convert from dp to px
    int px(int d) {
        float fpx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, d, getResources().getDisplayMetrics());
        return (int) fpx;

    }
}
