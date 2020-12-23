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
    @Query("SELECT * FROM Destino d where d.id_destino=:id")
    public DestinoPunto getDestinoPunto(Long id);

    @Transaction
    @Query("SELECT * FROM Destino")
    public List<DestinoPunto> getDestinosPuntos();

    @Query("select * from Destino")
    List<Destino> getAll();

    @Query("select * from Destino d order by d.reservas desc limit 3")
    List<Destino> getTopReservas();

    @Query("select * from Destino d where d.nombre like :nombre")
    List<Destino> findByNombre(String nombre);

    @Query("select * from Destino d where d.id_punto=:id")
    Destino findByPuntoId(Long id);

    @Query("select * from Destino d where d.nombre like :nombre AND " +
            "d.internet=:internet AND " +
            "d.precio_dia BETWEEN 0 AND :precio AND " +
            "d.tipo like :tipo AND " +
            "d.capacidad >= :personas ")
    List<Destino> findByAll(String nombre, Integer internet, Double precio, Integer personas, String tipo);

    @Query("select * from Destino d where d.precio_dia between :min and :max")
    List<Destino> findByPrecio(Double min, Double max);

    @Query("select * from Destino d where d.tipo like :tipo")
    List<Destino> findByTipo(String tipo);

    @Query("select * from Destino d where d.capacidad >= :capacidad")
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

