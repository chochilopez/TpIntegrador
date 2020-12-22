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
import com.dam2020.globe.entity.Destino;
import com.dam2020.globe.entity.Punto;
import com.dam2020.globe.helper.DatabaseInitializer;
import com.dam2020.globe.singleton.AppDatabase;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnMapa, btnBuscarDestino;
    ListView lvPuntos;
    private final static Integer CODIGO_MAPA=999, CODIGO_DESTINO=888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPuntos=findViewById(R.id.lvPuntos);
        btnMapa=findViewById(R.id.btnMapa);
        btnBuscarDestino=findViewById(R.id.btnBuscarDestino);
        //DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(MainActivity.super.getApplicationContext()));

        List<Destino>=AppDatabase.getAppDatabase(this).puntoDao().getAll();
        Collections.sort(personas, new Comparator() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return new Integer(p1.getEdad()).compareTo(new Integer(p2.getEdad()));
            }
        });

        ArrayAdapter<Punto> adapter= new ListViewPuntoAdapter(this, ,this);
        lvPuntos.setAdapter(adapter);

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MapActivity.class);
                startActivityForResult(intent, CODIGO_MAPA);
            }
        });

        btnBuscarDestino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, DestinoActivity.class);
                startActivityForResult(intent, CODIGO_DESTINO);
            }
        });
    }
}