package com.dam2020.globe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dam2020.globe.R;
import com.dam2020.globe.entity.Punto;

import java.util.List;

public class ListViewPuntoAdapter extends ArrayAdapter<Punto> {

    private AppCompatActivity activity;

    public ListViewPuntoAdapter(Context ctx, List<Punto> datos, AppCompatActivity activity){
        super(ctx,0,datos);
        this.activity=activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Punto punto = super.getItem(position);
        View vistaAux;

        LayoutInflater inflador = LayoutInflater.from(this.getContext());
        // EL IF QUE RECICLA
        // si la convertView que me pasa android  es null la tengo que crear
        // si ya fue creada la reuso, cambiandole los datos (cambia el titulo, la imagen)
        if(convertView==null)
            vistaAux = inflador.inflate(R.layout.fila_puntos_listview,parent,false); // METODOD COSTOSO
        else
            vistaAux = convertView;

        PuntoHolder puntoHolder = (PuntoHolder) vistaAux.getTag();
        if(puntoHolder == null){
            puntoHolder = new PuntoHolder(vistaAux);
            vistaAux.setTag(puntoHolder);
        }
        // configurar cada view con que fila del arreglo de datos coincide.
        puntoHolder.btnListaPunto.setTag(position);
        puntoHolder.tvPunto.setText(punto.getNombre());

        return vistaAux;
    }

    public class PuntoHolder {
        TextView tvPunto;
        Button btnListaPunto;

        public  PuntoHolder(View v){
            tvPunto=v.findViewById(R.id.tvDestino);
            btnListaPunto=v.findViewById(R.id.btnIrDestino);
        }
    }
}
