package com.dam2020.globe.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

public class DestinoPunto {
    @Embedded
    private Destino destino;

    @Relation(
            parentColumn = "id_punto",
            entityColumn = "id_punto"
    )
    private Punto punto;

    public DestinoPunto() {
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }
}
