package com.dam2020.globe.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "punto", indices = {@Index(value = {"latitud", "longitud"}, unique = true)})
public class Punto {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @ColumnInfo(defaultValue = "")
    private String nombre;
    @ColumnInfo(defaultValue = "0.0")
    private Double latitud;
    @ColumnInfo(defaultValue = "0.0")
    private Double longitud;
    @ColumnInfo(defaultValue = "0.0")
    private Double altura;

    public Punto() {
    }

    public Punto(Double latitud, Double longitud, String nombre) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre=nombre;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Punto{" +
                "latitud=" + latitud +
                ", longitud=" + longitud +
                ", altura=" + altura +
                '}';
    }
}
