package com.pizzaninja.pizzaninja;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class StatusActivity extends AppCompatActivity {
    OrderDetails od;
    LinearLayout myRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        od = OrderDetails.getInstance();

        myRoot = (LinearLayout) findViewById(R.id.itemList);

        populateList();
    }
    private void populateList() {
        double totalcost = 0.00;

        //Remove everything in list if necessary
        if (myRoot.getChildCount() > 0) myRoot.removeAllViews();


        for (OrderDetails.Item item : od.OrderList) {

            LinearLayout itemDetail = new LinearLayout(this);
            LinearLayout itemRow = new LinearLayout(this);
            itemRow.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams llparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            //setMargins takes px instead of dp, so we need to convert
            //Whole item row
            llparams.setMargins(px(40), px(20), px(40), px(5));
            itemDetail.setLayoutParams(llparams);


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

            totalcost += item.price;

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

        double tax = totalcost * .06;
        totalcost += tax;

        TextView texttax = (TextView) findViewById(R.id.textTax);
        texttax.setText("Tax: " + String.format("$%.2f", tax));
        TextView texttotal = (TextView) findViewById(R.id.textTotal);
        texttotal.setText("Total: " + String.format("$%.2f", totalcost));
    }

    int px(int d) {
        float fpx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, d, getResources().getDisplayMetrics());
        return (int) fpx;

    }

    public void OpenRateUs(View view)
    {
        Intent intent = new Intent(StatusActivity.this, RateUsActivity.class);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                Context context = getApplicationContext();
                CharSequence text = "Rating Submitted!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }
    }

    public void CloseStatus(View view)
    {
        finish();
    }
}
