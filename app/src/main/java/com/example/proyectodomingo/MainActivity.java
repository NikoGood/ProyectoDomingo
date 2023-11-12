package com.example.proyectodomingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button iniciar;
    private EditText user, password;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = findViewById(R.id.btnIniciar);
        user = findViewById(R.id.txtUser);
        password = findViewById(R.id.txtPassword);
        pb = findViewById(R.id.progressBar);

        iniciar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                new Task().execute(user.getText().toString());
            }
        });

    }
    class Task extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute(){
            pb.setVisibility(View.VISIBLE);
            iniciar.setEnabled(false);
        }
        @Override
        protected String doInBackground(String... strings){
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            return strings[0];
        }
        @Override
        protected void onPostExecute(String s){
            pb.setVisibility(View.VISIBLE);
            iniciar.setEnabled(true);
            Intent intent = new Intent(MainActivity.this, menu.class);
            intent.putExtra("Usuario", user.getText().toString());
            startActivity(intent);
        }
    }
}