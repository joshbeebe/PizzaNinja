package com.pizzaninja.pizzaninja;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class SpecialsActivity extends AppCompatActivity {
    OrderDetailsPN od;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specials);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        od = OrderDetailsPN.getInstance();
    }

    public void bigSalad_click(View view) {
        od.addItem(new OrderDetailsPN.Item("Big Salad", 2.99));
        Context context = getApplicationContext();
        CharSequence text = "Added Big Salad";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        finish();
    }

    public void largePizza_click(View view) {
        Intent intent = new Intent(this, BuildPizzaActivity.class);
        Bundle b = new Bundle();
        b.putString("pizzasize", "Large");
        b.putDouble("pizzacost", 7.49);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }
}
