package com.dam2020.globe.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.dam2020.globe.R;
import com.dam2020.globe.entity.Destino;

import java.util.List;

public class RecyclerDestinoAdapter extends RecyclerView.Adapter<RecyclerDestinoAdapter.DestinoViewHolder>{
    private List<Destino> mDataset;
    private AppCompatActivity activity;

    public RecyclerDestinoAdapter(List<Destino> myDataset, AppCompatActivity activity) {
        mDataset = myDataset;
        this.activity = activity;
    }

    public class DestinoViewHolder extends RecyclerView.ViewHolder {
        TextView tvPrecio, tvNombre, tvDescripcion, tvTipo, tvInternet, tvCapacidad;
        ProgressBar pbPrecio;
        Button btnVerEnMapa, btnReservar;

        public DestinoViewHolder(View v){
            super(v);
            tvPrecio=v.findViewById(R.id.tvPrecio);
            tvNombre=v.findViewById(R.id.tvNombre);
            tvDescripcion=v.findViewById(R.id.tvDescripcion);
            tvTipo=v.findViewById(R.id.tvTipo);
            tvInternet=v.findViewById(R.id.tvInternet);
            tvCapacidad=v.findViewById(R.id.tvCapacidad);
            pbPrecio=(ProgressBar) v.findViewById(R.id.pbPrecio);
            btnVerEnMapa=v.findViewById(R.id.btnVerEnMapa);
            btnReservar=v.findViewById(R.id.btnReservar);

            btnVerEnMapa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });;

            btnReservar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }

    @Override
    public RecyclerDestinoAdapter.DestinoViewHolder onCreateViewHolder(ViewGroup parent,
                                                                   int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fila_destinos_recycler, parent, false);
        DestinoViewHolder  vh = new DestinoViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DestinoViewHolder destinoHolder, final int position) {
        destinoHolder.btnVerEnMapa.setTag(position);
        destinoHolder.btnReservar.setTag(position);
        Destino destino = mDataset.get(position);

        destinoHolder.tvPrecio.setText("Precio habitación $"+destino.getPrecioDia());
        destinoHolder.tvNombre.setText(destino.getNombre());
        destinoHolder.tvDescripcion.setText(destino.getDescripcion());
        destinoHolder.tvTipo.setText(destino.getTipoPropiedad());
        destinoHolder.tvInternet.setText(destino.getInternet()==1 ? "Con internet" : "Sin internet");
        destinoHolder.pbPrecio.setProgress(destino.getPrecioDia().intValue());
        destinoHolder.tvCapacidad.setText(destino.getCapacidadPersonas() >= 10 ? "Capacidad maxima: Mas de 5 personas" : "Capacidad maxima: "+destino.getCapacidadPersonas()+" personas");


        if (destino.getPrecioDia() > 0.0 && destino.getPrecioDia() < 7000.0)
            destinoHolder.pbPrecio.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
        else if (destino.getPrecioDia() > 7000.01 && destino.getPrecioDia() < 14000.0)
            destinoHolder.pbPrecio.getProgressDrawable().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
        else if (destino.getPrecioDia() > 14000.01)
            destinoHolder.pbPrecio.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

//        float auxCalificacion = disco.getCalificacion()==null? 0.0F : disco.getCalificacion().floatValue();
//        discoHolder.rbCalificacion.setRating(auxCalificacion);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}

