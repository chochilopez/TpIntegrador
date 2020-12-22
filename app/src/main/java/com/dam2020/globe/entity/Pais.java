package com.dam2020.globe.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pais")
public class Pais {

    @PrimaryKey(autoGenerate = true)
    private Long id_pais;

    @ColumnInfo(defaultValue = "")
    private String codigo;

    @ColumnInfo(defaultValue = "")
    private String nombre;

    public Pais() {
    }

    public Pais(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getId_pais() {
        return id_pais;
    }

    public void setId_pais(Long id_pais) {
        this.id_pais = id_pais;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id_pais=" + id_pais +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
