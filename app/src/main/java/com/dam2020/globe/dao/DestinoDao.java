package com.dam2020.globe.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.dam2020.globe.entity.Destino;
import com.dam2020.globe.entity.DestinoPunto;

import java.util.List;

@Dao
public interface DestinoDao {
    @Transaction
    @Query("SELECT * FROM destino")
    public List<DestinoPunto> getDestinosPuntos();

    @Query("select * from destino")
    List<Destino> getAll();

    @Query("select * from destino where nombre like :nombre")
    List<Destino> findByNombre(String nombre);

    @Query("select * from destino where precio_dia between :min and :max")
    List<Destino> findByPrecio(Double min, Double max);

    @Query("select * from destino where tipo like :tipo")
    List<Destino> findByTipo(String tipo);

    @Query("select * from destino where capacidad >= :capacidad")
    List<Destino> findByCapacidad(Integer capacidad);

    @Insert
    void insertAll(Destino... destinos);

    @Insert
    Long insert(Destino destino);

    @Update
    void update(Destino destino);

    @Delete
    void delete(Destino destino);
}

