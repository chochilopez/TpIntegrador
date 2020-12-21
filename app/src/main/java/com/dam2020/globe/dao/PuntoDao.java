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
    @Query("select * from punto")
    List<Punto> getAll();

    @Query("select * from punto where nombre like :nombre")
    List<Punto> findByNombre(String nombre);

    @Query("select * from destino where precio_dia between :min and :max")
    List<Punto> findByLongitud(Double min, Double max);

    @Query("select * from destino where tipo like :tipo")
    List<Punto> findByLatitud(String tipo);

    @Query("select * from destino where capacidad >= :capacidad")
    List<Punto> findByLatLong(Integer capacidad);

    @Insert
    void insertAll(Punto... puntos);

    @Insert
    Long insert(Punto punto);

    @Update
    void update(Punto punto);

    @Delete
    void delete(Punto punto);
}
