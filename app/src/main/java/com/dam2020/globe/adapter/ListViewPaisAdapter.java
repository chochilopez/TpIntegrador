package com.dam2020.globe.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.dam2020.globe.activity.DestinoActivity;
import com.dam2020.globe.activity.MainActivity;
import com.dam2020.globe.activity.MapActivity;
import com.dam2020.globe.entity.Destino;
import com.dam2020.globe.entity.Pais;

import java.util.List;

public class ListViewPaisAdapter extends ArrayAdapter<Pais> {

    private AppCompatActivity activity;
    private Context ctx;

    public ListViewPaisAdapter(Context ctx, List<Pais> datos, AppCompatActivity activity){
        super(ctx,0,datos);
        this.activity=activity;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Pais pais = super.getItem(position);
        View vistaAux;

        LayoutInflater inflador = LayoutInflater.from(this.getContext());
        if(convertView==null)
            vistaAux = inflador.inflate(R.layout.fila_main_listview,parent,false); // METODOD COSTOSO
        else
            vistaAux = convertView;

        PaisHolder paisHolder = (PaisHolder) vistaAux.getTag();
        if(paisHolder == null){
            paisHolder = new PaisHolder(vistaAux);
            vistaAux.setTag(paisHolder);
        }
        // configurar cada view con que fila del arreglo de datos coincide.
        paisHolder.btnIrMain.setTag(position);
        paisHolder.tvNombreMain.setText(pais.getNombre().toString());

        paisHolder.btnIrMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pos = (Integer)v.getTag();
                Intent intent = new Intent(ctx , DestinoActivity.class);
                Pais aux = getItem(pos);
                intent.putExtra("id_pais", aux.getId_pais());
                intent.putExtra("nombre", aux.getNombre());
                activity.startActivity(intent);
            }
        });

        return vistaAux;
    }

    public class PaisHolder {
        TextView tvNombreMain;
        Button btnIrMain;

        public PaisHolder(View v){
            tvNombreMain=v.findViewById(R.id.tvNombreMain);
            btnIrMain=v.findViewById(R.id.btnIrMain);
        }
    }
}
