package com.apiforohub.apiforohub.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    public Perfil() {
    }

    public Perfil(String nombre) {
        this.nombre = nombre;
    }
}
