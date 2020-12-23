package com.dam2020.globe.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "punto", indices = {@Index(value = {"latitud", "longitud"})})
public class Punto {

    @PrimaryKey(autoGenerate = true)
    private Long id_punto;

    @ColumnInfo(defaultValue = "0.0")
    private Double latitud;

    @ColumnInfo(defaultValue = "0.0")
    private Double longitud;

    private Long id_pais;

    public Punto() {
    }

    public Punto(Double latitud, Double longitud, Long id_pais) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.id_pais=id_pais;
    }

    public Long getId_punto() {
        return id_punto;
    }

    public void setId_punto(Long id_punto) {
        this.id_punto = id_punto;
    }

    public Long getId_pais() {
        return id_pais;
    }

    public void setId_pais(Long id_pais) {
        this.id_pais = id_pais;
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
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punto punto = (Punto) o;
        return Objects.equals(id_punto, punto.id_punto) &&
                Objects.equals(latitud, punto.latitud) &&
                Objects.equals(longitud, punto.longitud) &&
                Objects.equals(id_pais, punto.id_pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_punto, latitud, longitud, id_pais);
    }
}
