package com.dam2020.globe.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.dam2020.globe.entity.Punto;

import java.util.List;

@Dao
public interface PuntoDao {
    @Query("select * from Punto")
    List<Punto> getAll();

    @Insert
    void insertAll(Punto... puntos);

    @Insert
    Long insert(Punto punto);

    @Update
    void update(Punto punto);

    @Delete
    void delete(Punto punto);
}
