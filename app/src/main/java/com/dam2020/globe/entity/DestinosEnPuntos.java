package com.dam2020.globe.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class DestinosEnPuntos {
    @Embedded
    private Punto punto;

    @Relation(parentColumn = "id", entityColumn = "id")
    private List<Destino> destinos;

    public DestinosEnPuntos() {
    }

    public DestinosEnPuntos(Punto punto, List<Destino> destinos) {
        this.punto = punto;
        this.destinos = destinos;
    }

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    public List<Destino> getDestinos() {
        return destinos;
    }

    public void setDestinos(List<Destino> destinos) {
        this.destinos = destinos;
    }
}
