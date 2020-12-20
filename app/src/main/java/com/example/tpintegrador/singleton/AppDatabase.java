package com.example.tpintegrador.singleton;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tpintegrador.dao.DestinoDao;
import com.example.tpintegrador.dao.PuntoDao;
import com.example.tpintegrador.entity.Destino;
import com.example.tpintegrador.entity.Punto;

//Singleton conexion a DB
@Database(entities = {Destino.class, Punto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract PuntoDao puntoDao();
    public abstract DestinoDao destinoDao();


    public static AppDatabase getAppDatabase(Context context){
        if (INSTANCE==null)
            INSTANCE= Room.databaseBuilder(context.getApplicationContext() , AppDatabase.class, "globe").allowMainThreadQueries().build();

        return INSTANCE;
    }

    public  static void destroyInstance(){
        INSTANCE=null;
    }
}
