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

    private static Punto addPunto(final AppDatabase db, Punto punto) {
        db.puntoDao().insertAll(punto);
        return punto;
    }

    private static Destino addDestino(final AppDatabase db, Destino destino) {
        db.destinoDao().insertAll(destino);
        return destino;
    }

    private static void populateWithTestData(AppDatabase db) {

        //Double latitud, Double longitud, String nombre
        ;

        //String nombre, String descripcion, Double precioDia, Boolean poseeInternet, TipoAlojamiento tipoPropiedad, Integer capacidadPersonas, Punto punto
        //HABITACION_HOTEL,CASA,DEPARTAMENTO,HOSTEL, CABAÑA, NO_INFORMA
        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
                TipoAlojamiento.CABAÑA.toString(), 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
        addDestino(db, new Destino("Hotel Champaqui", "Un hotel 5 estrellas arriba del cerro" , 10567.65, true,
                TipoAlojamiento.HABITACION_HOTEL.toString(), 3, addPunto(db, new Punto(-31.989575, -64.934300, "Calamuchita"))));
        addDestino(db, new Destino("La casa de Vazquez", "La casa del jefe del faro" , 543.00, true,
                TipoAlojamiento.CASA.toString(), 6, addPunto(db, new Punto(-54.732778, -63.857830, "Isla de los Estados"))));
        addDestino(db, new Destino("El Vigilante", "Un edificio en un lugar raro" , 0.15, true,
                TipoAlojamiento.DEPARTAMENTO.toString(), 6, addPunto(db, new Punto(-54.772796, -63.64296270, "Isla de los Estados"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));
//        addDestino(db, new Destino("Las Marias", "Cabañas de madera con pileta" , 2570.65, false,
//                TipoAlojamiento.CABAÑA, 6, addPunto(db, new Punto(-32.078964, -64.796011, "Calamuchita"))));


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
