package com.pizzaninja.pizzaninja;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RateUsActivity extends AppCompatActivity {
    int ratingStore = 0;
    int ratingDriver = 0;
    String storeNumber = "546";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        SharedPreferences prefs = this.getSharedPreferences("com.pizzaninja.pizzaninja", Context.MODE_PRIVATE);
        storeNumber = prefs.getString("storeNumber", "");
        String title = "Rate Store #" + storeNumber;
        TextView textView = (TextView) findViewById(R.id.textStore);
        textView.setText(title);

        TextView textDriver = (TextView) findViewById(R.id.textDriver);
        switch (storeNumber)
        {
            case "545":
                textDriver.setText("Driver Jerry Jones");
                break;
            case "546":
                textDriver.setText("Driver Jon Snow");
                break;
            case "523":
                textDriver.setText("Driver Dexter Morgan");
                break;
            default:
                textDriver.setText("Driver Jerry Jones");
                break;
        }
    }

    public void onClickStore(View view)
    {
        if (ratingStore > 4)
        {
            ratingStore = 0;
        }
        else
        {
            ratingStore++;
        }

        switch (ratingStore)
        {
            case 0:
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pz0);
                ImageView imageView = (ImageView) findViewById(R.id.imageStore);
                imageView.setImageBitmap(bitmap);
                break;
            case 1:
                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.pz1);
                ImageView imageView1 = (ImageView) findViewById(R.id.imageStore);
                imageView1.setImageBitmap(bitmap1);
                break;
            case 2:
                Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.pz2);
                ImageView imageView2 = (ImageView) findViewById(R.id.imageStore);
                imageView2.setImageBitmap(bitmap2);
                break;
            case 3:
                Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.pz3);
                ImageView imageView3 = (ImageView) findViewById(R.id.imageStore);
                imageView3.setImageBitmap(bitmap3);
                break;
            case 4:
                Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.pz4);
                ImageView imageView4 = (ImageView) findViewById(R.id.imageStore);
                imageView4.setImageBitmap(bitmap4);
                break;
            case 5:
                Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.pz5);
                ImageView imageView5 = (ImageView) findViewById(R.id.imageStore);
                imageView5.setImageBitmap(bitmap5);
                break;
            default:
                break;
        }
    }

    public void onClickDriver(View view)
    {
        if (ratingDriver > 4)
        {
            ratingDriver = 0;
        }
        else
        {
            ratingDriver++;
        }

        switch (ratingDriver)
        {
            case 0:
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pz0);
                ImageView imageView = (ImageView) findViewById(R.id.imageDriver);
                imageView.setImageBitmap(bitmap);
                break;
            case 1:
                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.pz1);
                ImageView imageView1 = (ImageView) findViewById(R.id.imageDriver);
                imageView1.setImageBitmap(bitmap1);
                break;
            case 2:
                Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.pz2);
                ImageView imageView2 = (ImageView) findViewById(R.id.imageDriver);
                imageView2.setImageBitmap(bitmap2);
                break;
            case 3:
                Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.pz3);
                ImageView imageView3 = (ImageView) findViewById(R.id.imageDriver);
                imageView3.setImageBitmap(bitmap3);
                break;
            case 4:
                Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.pz4);
                ImageView imageView4 = (ImageView) findViewById(R.id.imageDriver);
                imageView4.setImageBitmap(bitmap4);
                break;
            case 5:
                Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.pz5);
                ImageView imageView5 = (ImageView) findViewById(R.id.imageDriver);
                imageView5.setImageBitmap(bitmap5);
                break;
            default:
                break;
        }
    }

    public void Close(View view)
    {
        finish();
    }
}
