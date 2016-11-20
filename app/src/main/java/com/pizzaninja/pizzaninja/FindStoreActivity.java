package com.pizzaninja.pizzaninja;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class FindStoreActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String storeNumber = "546";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_store);
        EditText editText = (EditText) findViewById(R.id.textZip);
        editText.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                String input = s.toString();
                if(input.length() == 5)
                {
                    LatLng location;
                    switch (input) {
                        case "48502":
                            location = new LatLng(43.016683, -83.691543);
                            break;
                        case "48439":
                            location = new LatLng(42.943963, -83.691440);
                            break;
                        default:
                            location = new LatLng(43.016683, -83.691543);
                            break;
                    }
                    CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(location, 15);
                    mMap.animateCamera(cameraUpdate);
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void afterTextChanged(Editable s) {

            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void OpenRatings(View view)
    {
        Intent intent = new Intent(FindStoreActivity.this, RatingsActivity.class);
        Bundle b = new Bundle();
        b.putString("storenumber", storeNumber);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void CloseView(View view)
    {
        Intent intent = new Intent();
        intent.putExtra("storenumber", storeNumber);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                switch (marker.getTitle()) {
                    case "Pizza Ninja Store #546":
                        storeNumber = "546";
                        break;
                    case "Pizza Ninja Store #545":
                        storeNumber = "545";
                        break;
                    case "Pizza Ninja Store #523":
                        storeNumber = "523";
                        break;
                    default:
                        storeNumber = "546";
                        break;
                }
                Context context = getApplicationContext();
                CharSequence text = "Store #" + storeNumber + " Selected";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                return false;
            }
        });
        LatLng flint1 = new LatLng(43.016683, -83.691543);
        LatLng flint2 = new LatLng(43.016713, -83.685813);
        LatLng grandblanc = new LatLng(42.943963, -83.691440);
        mMap.addMarker(new MarkerOptions().position(flint1).title("Pizza Ninja Store #546").icon(BitmapDescriptorFactory.fromResource(R.drawable.pzmarker)));
        mMap.addMarker(new MarkerOptions().position(flint2).title("Pizza Ninja Store #545").icon(BitmapDescriptorFactory.fromResource(R.drawable.pzmarker)));
        mMap.addMarker(new MarkerOptions().position(grandblanc).title("Pizza Ninja Store #523").icon(BitmapDescriptorFactory.fromResource(R.drawable.pzmarker)));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(flint1, 15);
        mMap.animateCamera(cameraUpdate);
    }
}
