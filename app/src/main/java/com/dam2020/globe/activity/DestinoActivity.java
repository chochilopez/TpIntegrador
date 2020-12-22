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
import com.dam2020.globe.singleton.AppDatabase;

public class DestinoActivity extends AppCompatActivity {
    SeekBar seekPrecio;
    EditText editNombre;
    Spinner comboPersonas, comboTipoHabitacion;
    CheckBox cbInternet;
    Button btnAgregarDestino, btnBuscar;
    RecyclerView rvDestinos;
    TextView tvPrecio;

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
        btnAgregarDestino=findViewById(R.id.btnAgregarDestino);
        btnBuscar=findViewById(R.id.btnBuscar);
        rvDestinos=findViewById(R.id.rvDestinos);
        tvPrecio=findViewById(R.id.tvPrecio);

        recyclerView = (RecyclerView) findViewById(R.id.rvDestinos);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecyclerDestinoAdapter(AppDatabase.getAppDatabase(this).destinoDao().getAll(),this);
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


}