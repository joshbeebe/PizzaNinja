package com.pizzaninja.pizzaninja;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SpecialsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specials);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        od = OrderDetails.getInstance();
    }

    OrderDetails od;

    public void bigSalad_click(View view) {
        od.addItem(new OrderDetails.Item("Big Salad", 2.99));

    }

    public void largePizza_click(View view) {
        Intent intent = new Intent(SpecialsActivity.this, BuildPizzaActivity.class);
        startActivity(intent);
    }


    public void confirmOrder_click(View view) {
        Intent intent = new Intent(SpecialsActivity.this, ConfirmOrderActivity.class);
        startActivity(intent);
    }
}
