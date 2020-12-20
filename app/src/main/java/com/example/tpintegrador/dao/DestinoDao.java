package com.example.tpintegrador.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tpintegrador.entity.Destino;

import java.util.List;

@Dao
public interface DestinoDao {
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

    @Update
    void update(Destino destino);

    @Delete
    void delete(Destino destino);
}

