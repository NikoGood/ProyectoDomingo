package com.example.proyectodomingo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class gps extends AppCompatActivity implements OnMapReadyCallback,  GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {


    GoogleMap Maps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapClick(@NonNull LatLng latLng) {

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Maps=googleMap;
        this.Maps.setOnMapClickListener(this);
        this.Maps.setOnMapLongClickListener(this);
        LatLng st = new LatLng(-38.9328331, -72.0320492);
        Maps.addMarker(new MarkerOptions().position(st).title("Veterinaria ST"));
        Maps.moveCamera(CameraUpdateFactory.newLatLng(st));

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {

    }
}