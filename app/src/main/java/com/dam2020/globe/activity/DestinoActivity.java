package com.dam2020.globe.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dam2020.globe.R;
import com.dam2020.globe.adapter.RecyclerDestinoAdapter;
import com.dam2020.globe.entity.Destino;
import com.dam2020.globe.entity.Punto;
import com.dam2020.globe.singleton.AppDatabase;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class DestinoActivity extends AppCompatActivity {
    SeekBar seekPrecio;
    EditText editNombre;
    Spinner comboPersonas, comboTipoHabitacion;
    CheckBox cbInternet;
    Button btnBuscar;
    RecyclerView rvDestinos;
    TextView tvPrecio, tvResultado;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destino);

        seekPrecio=findViewById(R.id.seekPrecio);
        editNombre=findViewById(R.id.editNombre);
        comboPersonas=findViewById(R.id.comboPersonas);
        comboTipoHabitacion=findViewById(R.id.comboTipoHabitacion);
        cbInternet=findViewById(R.id.cbInternet);
        btnBuscar=findViewById(R.id.btnBuscar);
        rvDestinos=findViewById(R.id.rvDestinos);
        tvPrecio=findViewById(R.id.tvPrecio);
        tvResultado=findViewById(R.id.tvResultados);

        recyclerView = (RecyclerView) findViewById(R.id.rvDestinos);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Destino> destinos=new ArrayList<>();

        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            tvResultado.setText("Mostrando destinos en "+parametros.getString("nombre"));
            List<Punto> puntos=AppDatabase.getAppDatabase(this).puntoDao().findByPais(parametros.getLong("id_pais"));
            for (Punto punto : puntos){
                destinos.add(AppDatabase.getAppDatabase(this).destinoDao().findByPuntoId(punto.getId_punto()));
            }
        } else
            destinos=AppDatabase.getAppDatabase(this).destinoDao().getAll();

        mAdapter = new RecyclerDestinoAdapter(destinos,this);
        recyclerView.setAdapter(mAdapter);

        seekPrecio.setMin(0);
        seekPrecio.setMax(20000);
        seekPrecio.setProgress(10000);





        seekPrecio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvPrecio.setText("Hasta $"+seekBar.getProgress());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText("Mostrando");
                Integer personas=1;
                switch (comboPersonas.getSelectedItemPosition()){
                    case 0:
                        personas=1;
                        break;
                    case 1:
                        personas=2;
                        break;
                    case 2:
                        personas=3;
                        break;
                    case 3:
                        personas=4;
                        break;
                    case 4:
                        personas=10;
                        break;
                }
                String tipo="";
                switch (comboTipoHabitacion.getSelectedItemPosition()){
                    case 0:
                        tipo="%";
                        break;
                    case 1:
                        tipo="HABITACION_HOTEL";
                        break;
                    case 2:
                        tipo="CASA";
                        break;
                    case 3:
                        tipo="DEPARTAMENTO";
                        break;
                    case 4:
                        tipo="HOSTEL";
                        break;
                    case 5:
                        tipo="CABAÑA";
                        break;
                    case 6:
                        tipo="NO_INFORMA";
                        break;
                }
                //findByAll(String nombre, Integer internet, Double precio, Integer personas, String tipo);
                mAdapter=new RecyclerDestinoAdapter(
                        AppDatabase.getAppDatabase(
                                recyclerView.getContext()).destinoDao().findByAll(
                                        editNombre.getText().toString().isEmpty() ? "%" : editNombre.getText().toString(),
                                        cbInternet.isChecked() ? 1 : 0,
                                        (double)seekPrecio.getProgress(),
                                        personas,
                                        tipo

                        ),

//                        seekPrecio=findViewById(R.id.seekPrecio);
//                editNombre=findViewById(R.id.editNombre);
//                comboPersonas=findViewById(R.id.comboPersonas);
//                comboTipoHabitacion=findViewById(R.id.comboTipoHabitacion);
//                cbInternet=findViewById(R.id.cbInternet);
//                btnAgregarDestino=findViewById(R.id.btnAgregarDestino);
//                btnBuscar=findViewById(R.id.btnBuscar);
//                rvDestinos=findViewById(R.id.rvDestinos);
//                tvPrecio=findViewById(R.id.tvPrecio);
                        DestinoActivity.this);
                recyclerView.setAdapter(mAdapter);
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