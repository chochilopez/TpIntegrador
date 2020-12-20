package com.dam2020.globe.singleton;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dam2020.globe.dao.DestinoDao;
import com.dam2020.globe.dao.PuntoDao;
import com.dam2020.globe.entity.Destino;
import com.dam2020.globe.entity.Punto;

//Singleton conexion a DB
@Database(entities = {Destino.class, Punto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static com.dam2020.globe.singleton.AppDatabase INSTANCE;

    public abstract PuntoDao puntoDao();
    public abstract DestinoDao destinoDao();


    public static com.dam2020.globe.singleton.AppDatabase getAppDatabase(Context context){
        if (INSTANCE==null)
            INSTANCE= Room.databaseBuilder(context.getApplicationContext() , com.dam2020.globe.singleton.AppDatabase.class, "globe").allowMainThreadQueries().build();

        return INSTANCE;
    }

    public  static void destroyInstance(){
        INSTANCE=null;
    }
}
