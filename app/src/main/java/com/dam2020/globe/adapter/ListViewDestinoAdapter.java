package com.dam2020.globe.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.dam2020.globe.R;
import com.dam2020.globe.activity.MainActivity;
import com.dam2020.globe.activity.MapActivity;
import com.dam2020.globe.entity.Destino;
import com.dam2020.globe.entity.DestinoPunto;
import com.dam2020.globe.singleton.AppDatabase;

import java.util.List;

public class ListViewDestinoAdapter extends ArrayAdapter<Destino> {

    private AppCompatActivity activity;
    private Context ctx;

    public ListViewDestinoAdapter(Context ctx, List<Destino> datos, AppCompatActivity activity){
        super(ctx,0,datos);
        this.activity=activity;
        this.ctx=ctx;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Destino destino = super.getItem(position);
        View vistaAux;

        LayoutInflater inflador = LayoutInflater.from(this.getContext());
        // EL IF QUE RECICLA
        // si la convertView que me pasa android  es null la tengo que crear
        // si ya fue creada la reuso, cambiandole los datos (cambia el titulo, la imagen)
        if(convertView==null)
            vistaAux = inflador.inflate(R.layout.fila_main_listview,parent,false); // METODOD COSTOSO
        else
            vistaAux = convertView;

        DestinoHolder destinoHolder = (DestinoHolder) vistaAux.getTag();
        if(destinoHolder == null){
            destinoHolder = new DestinoHolder(vistaAux);
            vistaAux.setTag(destinoHolder);
        }
        // configurar cada view con que fila del arreglo de datos coincide.
        destinoHolder.btnIrMain.setTag(position);
        destinoHolder.tvNombreMain.setText(destino.getNombre().toString());

        destinoHolder.btnIrMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pos = (Integer)v.getTag();
                Intent intent = new Intent(ctx , MapActivity.class);
                Destino aux = getItem(pos);
                DestinoPunto punto= AppDatabase.getAppDatabase(ctx).destinoDao().getDestinoPunto(aux.getId_destino());
                intent.putExtra("latitud", punto.getPunto().getLatitud());
                intent.putExtra("longitud", punto.getPunto().getLongitud());
                activity.startActivity(intent);
            }
        });
        return vistaAux;
    }

    public class DestinoHolder {
        TextView tvNombreMain;
        Button btnIrMain;

        public DestinoHolder(View v){
            tvNombreMain=v.findViewById(R.id.tvNombreMain);
            btnIrMain=v.findViewById(R.id.btnIrMain);
        }
    }


}
