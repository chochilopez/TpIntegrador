package com.dam2020.globe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dam2020.globe.R;
import com.dam2020.globe.adapter.ListViewDestinoAdapter;
import com.dam2020.globe.adapter.ListViewPaisAdapter;
import com.dam2020.globe.entity.Destino;
import com.dam2020.globe.entity.Pais;
import com.dam2020.globe.singleton.AppDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnMapa, btnBuscarDestino;
    ImageView imgBuscar;
    ListView lvMain;
    EditText editBuscar;
    TextView tvTextoLv;
    private final static Integer CODIGO_MAPA=999, CODIGO_DESTINO=888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain=findViewById(R.id.lvMain);
        btnMapa=findViewById(R.id.btnMapa);
        btnBuscarDestino=findViewById(R.id.btnBuscarDestino);
        editBuscar=findViewById(R.id.editBuscar);
        tvTextoLv=findViewById(R.id.tvTextoLv);
        imgBuscar=findViewById(R.id.imgBuscar);
        //DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(MainActivity.super.getApplicationContext()));

        ArrayAdapter<Destino> adapterDestino= new ListViewDestinoAdapter(this,AppDatabase.getAppDatabase(this).destinoDao().getTopReservas(),this);
        lvMain.setAdapter(adapterDestino);

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

        imgBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<Pais> adapterPais= new ListViewPaisAdapter(MainActivity.this, AppDatabase.getAppDatabase(MainActivity.this).paisDao().findByNombre("%"+editBuscar.getText().toString()+"%"),MainActivity.this);
                lvMain.setAdapter(adapterPais);
                tvTextoLv.setText("Paises con destinos:");
            }
        });
    }

    //TODO guardar parametros
//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        Log.d("EJECUCION", "SAVE INSTANCE STATE");
//        super.onSaveInstanceState(outState);
//        outState.putString("pelicula",tvPelicula.getText().toString());
//        outState.putString("episodio",tvEpisodio.getText().toString());
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        Log.d("EJECUCION", "RESTEORE INSTANCE STATE");
//        super.onRestoreInstanceState(savedInstanceState);
//        tvEpisodio.setText(savedInstanceState.getString("episodio"));
//        tvPelicula.setText(savedInstanceState.getString("pelicula"));
//        caratula(tvEpisodio.getText().toString());
//    }
}