package com.pizzaninja.pizzaninja;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        prefs = this.getSharedPreferences("com.pizzaninja.pizzaninja", Context.MODE_PRIVATE);
        prefs.edit().putString("storeNumber", "546").apply();
    }

    public void OpenLogin(View view)
    {
        Intent intent = new Intent(MainMenu.this, LoginActivity.class);
        startActivity(intent);
    }

    public void OpenMap(View view)
    {
        Intent intent = new Intent(MainMenu.this, FindStoreActivity.class);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String storeNumber = data.getStringExtra("storenumber");
                prefs.edit().putString("storeNumber", storeNumber).apply();
            }
        }
    }
}
