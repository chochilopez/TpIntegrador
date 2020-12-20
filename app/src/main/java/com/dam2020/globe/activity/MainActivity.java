package com.dam2020.globe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dam2020.globe.R;
import com.dam2020.globe.adapter.ListViewPuntoAdapter;
import com.dam2020.globe.entity.Punto;
import com.dam2020.globe.singleton.AppDatabase;

public class MainActivity extends AppCompatActivity {

    Button btnMapa, btnBuscarDestino;
    ListView lvPuntos;
    private final static Integer CODIGO_MAPA=999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPuntos=findViewById(R.id.lvPuntos);
        btnMapa=findViewById(R.id.btnMapa);
        btnBuscarDestino=findViewById(R.id.btnBuscarDestino);
        //DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(MainActivity.super.getApplicationContext()));

        ArrayAdapter<Punto> adapter= new ListViewPuntoAdapter(this, AppDatabase.getAppDatabase(this).puntoDao().getAll(),this);
        lvPuntos.setAdapter(adapter);

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MapActivity.class);
                startActivityForResult(intent, CODIGO_MAPA);
            }
        });
    }
}