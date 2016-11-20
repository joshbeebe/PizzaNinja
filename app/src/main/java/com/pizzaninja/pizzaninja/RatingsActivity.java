package com.pizzaninja.pizzaninja;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RatingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        SetRatings();
    }

    private void SetRatings()
    {
        Bitmap bitmapStore;
        String driver1;
        String driver2;
        String driver3;
        Bitmap bitmapDriver1;
        Bitmap bitmapDriver2;
        Bitmap bitmapDriver3;
        Intent intent = getIntent();
        String storenumber = intent.getStringExtra("storenumber");
        switch (storenumber) {
            case "545":
                bitmapStore = BitmapFactory.decodeResource(getResources(), R.drawable.pz2);
                driver1 = "Jerry Jones";
                driver2 = "Rick Harrison";
                driver3 = "Shelly Turner";
                bitmapDriver1 = BitmapFactory.decodeResource(getResources(), R.drawable.pz5);
                bitmapDriver2 = BitmapFactory.decodeResource(getResources(), R.drawable.pz4);
                bitmapDriver3 = BitmapFactory.decodeResource(getResources(), R.drawable.pz3);
                break;
            case "546":
                bitmapStore = BitmapFactory.decodeResource(getResources(), R.drawable.pz4);
                driver1 = "Jon Snow";
                driver2 = "Robb Stark";
                driver3 = "Ramsay Bolton";
                bitmapDriver1 = BitmapFactory.decodeResource(getResources(), R.drawable.pz4);
                bitmapDriver2 = BitmapFactory.decodeResource(getResources(), R.drawable.pz4);
                bitmapDriver3 = BitmapFactory.decodeResource(getResources(), R.drawable.pz1);
                break;
            case "523":
                bitmapStore = BitmapFactory.decodeResource(getResources(), R.drawable.pz5);
                driver1 = "Rick Grimes";
                driver2 = "James May";
                driver3 = "Dexter Morgan";
                bitmapDriver1 = BitmapFactory.decodeResource(getResources(), R.drawable.pz3);
                bitmapDriver2 = BitmapFactory.decodeResource(getResources(), R.drawable.pz5);
                bitmapDriver3 = BitmapFactory.decodeResource(getResources(), R.drawable.pz4);
                break;
            default:
                bitmapStore = BitmapFactory.decodeResource(getResources(), R.drawable.pz2);
                driver1 = "Jerry Jones";
                driver2 = "Rick Harrison";
                driver3 = "Shelly Turner";
                bitmapDriver1 = BitmapFactory.decodeResource(getResources(), R.drawable.pz5);
                bitmapDriver2 = BitmapFactory.decodeResource(getResources(), R.drawable.pz4);
                bitmapDriver3 = BitmapFactory.decodeResource(getResources(), R.drawable.pz3);
                break;
        }
        TextView textViewStore = (TextView) findViewById(R.id.textStore);
        textViewStore.setText("Store #" + storenumber + " Rating");
        ImageView imageViewStore = (ImageView) findViewById(R.id.imageStoreRating);
        imageViewStore.setImageBitmap(bitmapStore);
        TextView textViewDriver1 = (TextView) findViewById(R.id.textDriver1);
        textViewDriver1.setText(driver1);
        TextView textViewDriver2 = (TextView) findViewById(R.id.textDriver2);
        textViewDriver2.setText(driver2);
        TextView textViewDriver3 = (TextView) findViewById(R.id.textDriver3);
        textViewDriver3.setText(driver3);
        ImageView imageViewDriver1 = (ImageView) findViewById(R.id.imageDriver1);
        imageViewDriver1.setImageBitmap(bitmapDriver1);
        ImageView imageViewDriver2 = (ImageView) findViewById(R.id.imageDriver2);
        imageViewDriver2.setImageBitmap(bitmapDriver2);
        ImageView imageViewDriver3 = (ImageView) findViewById(R.id.imageDriver3);
        imageViewDriver3.setImageBitmap(bitmapDriver3);
    }
}
