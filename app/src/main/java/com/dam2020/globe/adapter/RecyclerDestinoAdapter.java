package com.dam2020.globe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.dam2020.globe.R;
import com.dam2020.globe.entity.Destino;

import java.util.List;

public class RecyclerDestinoAdapter extends RecyclerView.Adapter<RecyclerDestinoAdapter.DestinoViewHolder>{
    private List<Destino> mDataset;
    private AppCompatActivity activity;

    public RecyclerDestinoAdapter(List<Destino> myDataset, AppCompatActivity activity) {
        this.mDataset = myDataset;
        this.activity = activity;
    }

        public class DestinoViewHolder extends RecyclerView.ViewHolder{


            public DestinoViewHolder(View v) {
                super(v);

            }

        }
    @Override
    public RecyclerDestinoAdapter.DestinoViewHolder onCreateViewHolder(ViewGroup parent,
                                                                   int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fila_destinos_recycler, parent, false);
        //...
        DestinoViewHolder  vh = new DestinoViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(DestinoViewHolder discoHolder, final int position) {
//        discoHolder.rbCalificacion.setTag(position);
//        discoHolder.imgFavorito.setTag(position);
//        discoHolder.btnElegir.setTag(position);
//        Disco disco = mDataset.get(position);
//        if(disco.getFavorito())
//            discoHolder.imgFavorito.setImageResource(android.R.drawable.star_big_on);
//        else
//            discoHolder.imgFavorito.setImageResource(android.R.drawable.star_big_off);
//        discoHolder.tvAlbum.setText(disco.getNombre());
//        discoHolder.tvInterprete.setText(disco.getInterprete());
//        discoHolder.tvPublicacion.setText("Año: "+disco.getPublicacion());
//        discoHolder.tvCopias.setText("Copias: "+disco.getCopias());
//        discoHolder.pbRanking.setProgress(disco.getRanking());
//        discoHolder.rbCalificacion.setRating(disco.getCalificacion());
//        float auxCalificacion = disco.getCalificacion()==null? 0.0F : disco.getCalificacion().floatValue();
//        discoHolder.rbCalificacion.setRating(auxCalificacion);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
