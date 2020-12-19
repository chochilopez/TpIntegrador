package com.example.tpintegrador.dao;

import androidx.room.Dao;

@Dao
public class DestinoDao {
    @Query("select * from tarea")
    List<Tarea> getAll();

    @Query("select * from tarea where duracion > :inicio AND duracion < :fin")
    Tarea findByDuracion(Integer inicio, Integer fin);

    @Insert
    void insertAll(Tarea... tareas);

    @Update
    void update(Tarea tarea);

    @Delete
    void delete(Tarea tarea);
}
