package com.pizzaninja.pizzaninja;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    public void OpenLogin(View view)
    {
        Intent intent = new Intent(MainMenu.this, LoginActivity.class);
        startActivity(intent);
    }

    public void OpenMap(View view)
    {
        Intent intent = new Intent(MainMenu.this, FindStoreActivity.class);
        startActivity(intent);
    }
}
