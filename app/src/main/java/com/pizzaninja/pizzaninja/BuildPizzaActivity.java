package com.pizzaninja.pizzaninja;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class BuildPizzaActivity extends AppCompatActivity {

    OrderDetails od = OrderDetails.getInstance();
    ArrayList<String> toppings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_pizza);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        toppings = new ArrayList<>();
    }


    public void btnDone_click(View view) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.toppingsList);
        int count = ll.getChildCount();

        OrderDetails.Item item = new OrderDetails.Item("Large Pizza", 8.99);
        item.pricePerTopping = 1.5;

        for (int i = 0; i < count; i++ ){
            CheckBox cb = (CheckBox) ll.getChildAt(i);
            if (cb.isChecked()) {
                item.addTopping(cb.getText().toString());
            }
        }
        od.addItem(item);
        finish();
    }
}
