package com.example.tpintegrador.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.tpintegrador.R;
import com.example.tpintegrador.adapter.ListViewPuntoAdapter;
import com.example.tpintegrador.entity.Punto;
import com.example.tpintegrador.helper.DatabaseInitializer;
import com.example.tpintegrador.singleton.AppDatabase;

public class MainActivity extends AppCompatActivity {

    Button btnPoblar;
    ListView lvPuntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPuntos=findViewById(R.id.lvPuntos);
        //DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(MainActivity.super.getApplicationContext()));

        ArrayAdapter<Punto> adapter= new ListViewPuntoAdapter(this, AppDatabase.getAppDatabase(this).puntoDao().getAll(),this);
        lvPuntos.setAdapter(adapter);
    }
}