package com.dam2020.globe.helper;

import android.os.AsyncTask;

import androidx.annotation.NonNull;

import com.dam2020.globe.entity.Destino;
import com.dam2020.globe.entity.Punto;
import com.dam2020.globe.entity.TipoAlojamiento;
import com.dam2020.globe.singleton.AppDatabase;

import java.util.List;

public class DatabaseInitializer {

    private static final String TAG = com.dam2020.globe.helper.DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Long addPunto(final AppDatabase db, Punto punto) {
        return db.puntoDao().insert(punto);
    }

    private static Destino addDestino(final AppDatabase db, Destino destino) {
        db.destinoDao().insert(destino);
        return destino;
    }

    private static void populateWithTestData(AppDatabase db) {

        //Double latitud, Double longitud, String nombre
        ;

        //String nombre, String descripcion, Double precioDia, Boolean poseeInternet, TipoAlojamiento tipoPropiedad, Integer capacidadPersonas, Punto punto
        //HABITACION_HOTEL,CASA,DEPARTAMENTO,HOSTEL, CABAÑA, NO_INFORMA
        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, 0,
                TipoAlojamiento.CABAÑA.toString(), 6,addPunto(db, new Punto(-32.087373, -64.797747, "Calamuchita")), 8));
        addDestino(db, new Destino("Hotel Champaqui", "Un hotel 5 estrellas arriba del cerro" , 10567.65, 1,
                TipoAlojamiento.HABITACION_HOTEL.toString(), 3, addPunto(db, new Punto(-31.989878, -64.9345763, "Calamuchita")), 2));
        addDestino(db, new Destino("La casa de Vazquez", "La casa del jefe del faro" , 543.00, 1,
                TipoAlojamiento.CASA.toString(), 6, addPunto(db, new Punto(-54.732778, -63.857830, "Isla de los Estados")), 3));
        addDestino(db, new Destino("El Vigilante", "Un edificio en un lugar raro" , 0.15, 0,
                TipoAlojamiento.DEPARTAMENTO.toString(), 6, addPunto(db, new Punto(-54.772796, -63.64296270, "Isla de los Estados")), 9));

        List<Destino> destinoList=db.destinoDao().getAll();
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }
    }

}
