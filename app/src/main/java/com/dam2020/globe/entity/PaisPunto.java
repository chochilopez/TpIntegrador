package com.dam2020.globe.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class PaisPunto {
    @Embedded
    public Pais pais;

    @Relation(
            parentColumn = "id_pais",
            entityColumn = "id_pais"
    )
    public List<Punto> puntos;
}
