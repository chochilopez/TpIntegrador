package com.dam2020.globe.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "punto", indices = {@Index(value = {"latitud", "longitud"})})
public class Punto {
    @PrimaryKey(autoGenerate = true)
    private Long id_punto;
    @ColumnInfo(defaultValue = "")
    private String nombre;
    @ColumnInfo(defaultValue = "0.0")
    private Double latitud;
    @ColumnInfo(defaultValue = "0.0")
    private Double longitud;

    public Punto() {
    }

    public Punto(Double latitud, Double longitud, String nombre) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Long getId_punto() {
        return id_punto;
    }

    public void setId_punto(Long id_punto) {
        this.id_punto = id_punto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Punto{" +
                "id_punto=" + id_punto +
                ", nombre='" + nombre + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
