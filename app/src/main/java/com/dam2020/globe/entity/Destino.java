package com.dam2020.globe.entity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "destino")
public class  Destino{
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(defaultValue = "")
    private String nombre;

    @ColumnInfo(defaultValue = "")
    private String descripcion;

    @ColumnInfo(name = "precio_dia", defaultValue = "0.0")
    private Double precioDia;

    @ColumnInfo(name="internet", defaultValue = "false")
    private Boolean poseeInternet;

    @ColumnInfo(name="tipo", defaultValue = "NO_INFORMA")
    private String tipoPropiedad;

    @ColumnInfo(name="capacidad", defaultValue = "0")
    private Integer capacidadPersonas;

    @Ignore
    private Punto punto;

    public Destino() {
    }

    public Destino(String nombre, String descripcion, Double precioDia, Boolean poseeInternet, String tipoPropiedad, Integer capacidadPersonas, Punto punto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioDia = precioDia;
        this.poseeInternet = poseeInternet;
        this.tipoPropiedad = tipoPropiedad;
        this.capacidadPersonas = capacidadPersonas;
        this.punto = punto;
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

    public Boolean getPoseeInternet() {
        return poseeInternet;
    }

    public void setPoseeInternet(Boolean poseeInternet) {
        this.poseeInternet = poseeInternet;
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

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    @Override
    public String toString() {
        return "Destino{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioDia=" + precioDia +
                ", poseeInternet=" + poseeInternet +
                ", tipoPropiedad=" + tipoPropiedad +
                ", capacidadPersonas=" + capacidadPersonas +
                ", punto=" + punto +
                '}';
    }
}
