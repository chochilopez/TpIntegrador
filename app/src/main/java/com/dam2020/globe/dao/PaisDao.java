package com.dam2020.globe.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.dam2020.globe.entity.Pais;
import com.dam2020.globe.entity.PaisPunto;

import java.util.List;

@Dao
public interface PaisDao {
    @Transaction
    @Query("SELECT * FROM Pais")
    List<PaisPunto> getPaisPuntos();

    @Query("select * from Pais")
    List<Pais> getAll();

    @Query("select * from Pais p where p.nombre like :nombre")
    List<Pais> findByNombre(String nombre);

    @Query("select * from Pais p where p.codigo like :codigo")
    List<Pais> findByCodigo(String codigo);

    @Insert
    void insertAll(Pais... paises);

    @Insert
    Long insert(Pais pais);

    @Update
    void update(Pais pais);

    @Delete
    void delete(Pais pais);
}
