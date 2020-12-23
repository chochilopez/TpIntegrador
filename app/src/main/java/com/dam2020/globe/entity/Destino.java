package com.dam2020.globe.entity;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "destino")
public class  Destino{

    @PrimaryKey(autoGenerate = true)
    private Long id_destino;

    @ColumnInfo(defaultValue = "")
    private String nombre;

    @ColumnInfo(defaultValue = "")
    private String descripcion;

    @ColumnInfo(name = "precio_dia", defaultValue = "0.0")
    private Double precioDia;

    @ColumnInfo(defaultValue = "0")
    private Integer internet;

    @ColumnInfo(name="tipo", defaultValue = "NO_INFORMA")
    private String tipoPropiedad;

    @ColumnInfo(name="capacidad", defaultValue = "0")
    private Integer capacidadPersonas;

    @ColumnInfo(defaultValue = "0")
    private Integer reservas;

    private Long id_punto;

    public Destino() {
    }

    public Destino(String nombre, String descripcion, Double precioDia, Integer poseeInternet, String tipoPropiedad, Integer capacidadPersonas, Long id_punto, Integer reservas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioDia = precioDia;
        this.internet = poseeInternet;
        this.tipoPropiedad = tipoPropiedad;
        this.capacidadPersonas = capacidadPersonas;
        this.id_punto = id_punto;
        this.reservas=reservas;
    }

    public Long getId_destino() {
        return id_destino;
    }

    public void setId_destino(Long id_destino) {
        this.id_destino = id_destino;
    }

    public Integer getReservas() {
        return reservas;
    }

    public void setReservas(Integer reservas) {
        this.reservas = reservas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(Double precioDia) {
        this.precioDia = precioDia;
    }

    public Integer getInternet() {
        return internet;
    }

    public void setInternet(Integer internet) {
        this.internet = internet;
    }

    public String getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    public Integer getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(Integer capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }

    public Long getId_punto() {
        return id_punto;
    }

    public void setId_punto(Long id_punto) {
        this.id_punto = id_punto;
    }

    @Override
    public String toString() {
        return "Destino{" +
                "id_destino=" + id_destino +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioDia=" + precioDia +
                ", poseeInternet=" + internet +
                ", tipoPropiedad='" + tipoPropiedad + '\'' +
                ", capacidadPersonas=" + capacidadPersonas +
                ", id_punto=" + id_punto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destino destino = (Destino) o;
        return Objects.equals(id_destino, destino.id_destino) &&
                Objects.equals(nombre, destino.nombre) &&
                Objects.equals(descripcion, destino.descripcion) &&
                Objects.equals(precioDia, destino.precioDia) &&
                Objects.equals(internet, destino.internet) &&
                Objects.equals(tipoPropiedad, destino.tipoPropiedad) &&
                Objects.equals(capacidadPersonas, destino.capacidadPersonas) &&
                Objects.equals(reservas, destino.reservas) &&
                Objects.equals(id_punto, destino.id_punto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_destino, nombre, descripcion, precioDia, internet, tipoPropiedad, capacidadPersonas, reservas, id_punto);
    }
}
