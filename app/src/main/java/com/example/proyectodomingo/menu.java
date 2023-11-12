package com.example.proyectodomingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class menu extends AppCompatActivity {

    private TextView Nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Nombre=findViewById(R.id.viewuser);
        String nombreUser = getIntent().getStringExtra("Usuario");
        Nombre.setText("Bienvenido: " + nombreUser);
    }

    public void verAnimales(View view){
        Intent intent = new Intent(menu.this, lista.class);
        startActivity(intent);
    }
    public void verDireccion(View view){
        Intent intent = new Intent(menu.this, gps.class);
        startActivity(intent);
    }


}