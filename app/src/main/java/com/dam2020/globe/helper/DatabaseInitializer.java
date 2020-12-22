package com.dam2020.globe.helper;

import android.os.AsyncTask;

import androidx.annotation.NonNull;

import com.dam2020.globe.entity.Destino;
import com.dam2020.globe.entity.Pais;
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

    private static Pais addPais(final AppDatabase db, Pais pais) {
        db.paisDao().insert(pais);
        return pais;
    }

    private static void populateWithTestData(AppDatabase db) {

        addPais(db , new Pais("AR", "Argentina"));
        addPais(db , new Pais("BR", "Brasil"));
        addPais(db , new Pais("UR", "Uruguay"));

        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, 0,
                TipoAlojamiento.CABAÑA.toString(), 2,addPunto(db, new Punto(-32.087373, -64.797747, (long)1)), 8));
        addDestino(db, new Destino("Hotel Champaqui", "Un hotel 5 estrellas arriba del cerro" , 10567.65, 1,
                TipoAlojamiento.HABITACION_HOTEL.toString(), 3, addPunto(db, new Punto(-31.989878, -64.9345763, (long)1)), 2));
        addDestino(db, new Destino("La casa de Vazquez", "La casa del jefe del faro" , 543.00, 1,
                TipoAlojamiento.CASA.toString(), 6, addPunto(db, new Punto(-54.732778, -63.857830, (long)1)), 3));
        addDestino(db, new Destino("Hotel L'Auberge And Tea Room", "Esta pensión con encanto, que está situada en un edificio de ladrillo y madera construido en 1947 con vistas al mar y una gran torre de agua, se encuentra a 8 minutos a pie de Aqua Beach y a 7 km del museo del Mar." , 14832.12, 1,
                TipoAlojamiento.HABITACION_HOTEL.toString(), 4, addPunto(db, new Punto(-34.931856, -54.905911, (long)2)), 9));
        addDestino(db, new Destino("Ourilândia do Norte", "Cabañas." , 1298.21, 0,
                TipoAlojamiento.CABAÑA.toString(), 5, addPunto(db, new Punto(-7.966370, -51.354281, (long)3)), 3));


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
