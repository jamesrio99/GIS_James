package com.example.gisjamespolyline;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng home = new LatLng(-0.9258, 119.8874);
        LatLng bns_1 = new LatLng(-0.9192, 119.8931);
        LatLng bns_2 = new LatLng(-0.9292, 119.8850);
        LatLng bns_3 = new LatLng(-0.8889, 119.8781);

        //Custome size marker
        int tinggi = 100;
        int lebar = 50;
        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.home);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.bns);
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        //add marker to Map
        mMap.addMarker(new MarkerOptions().position(home).title("Marker In My Home")
                .snippet("Ini Adalah Rumah Saya")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(bns_1).title("Marker In BNS")
                .snippet("Ini Adalah BNS Dewi Sartika")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addMarker(new MarkerOptions().position(bns_2).title("Marker In BNS")
                .snippet("Ini Adalah BNS Towua")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addMarker(new MarkerOptions().position(bns_3).title("Marker In BNS")
                .snippet("Ini Adalah BNS S.Parman")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addPolyline(new PolylineOptions().add(
                home,
                new LatLng(-0.9258, 119.8874),
                new LatLng(-0.9257, 119.8876),
                new LatLng(-0.9252, 119.8876),
                new LatLng(-0.9252, 119.8888),
                new LatLng(-0.9247, 119.8888),
                new LatLng(-0.9248, 119.8915),
                new LatLng(-0.9248, 119.8946),
                new LatLng(-0.9248, 119.8952),
                new LatLng(-0.9240, 119.8951),
                new LatLng(-0.9237, 119.8949),
                new LatLng(-0.9224, 119.8943),
                new LatLng(-0.9219, 119.8941),
                new LatLng(-0.9212, 119.8939),
                new LatLng(-0.9206, 119.8937),
                new LatLng(-0.9193, 119.8929),
                new LatLng(-0.9192, 119.8931),
                bns_1
                ).width(7)
                        .color(Color.GREEN)
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home,15.5f));

    }
}